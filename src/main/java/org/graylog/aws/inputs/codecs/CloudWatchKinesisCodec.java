package org.graylog.aws.inputs.codecs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.assistedinject.Assisted;
import org.graylog.aws.AWS;
import org.graylog.aws.cloudwatch.CloudWatchKinesisMessage;
import org.graylog.aws.plugin.AWSObjectMapper;
import org.graylog2.plugin.Message;
import org.graylog2.plugin.configuration.Configuration;
import org.graylog2.plugin.configuration.ConfigurationRequest;
import org.graylog2.plugin.inputs.annotations.ConfigClass;
import org.graylog2.plugin.inputs.annotations.FactoryClass;
import org.graylog2.plugin.inputs.codecs.AbstractCodec;
import org.graylog2.plugin.inputs.codecs.Codec;
import org.graylog2.plugin.journal.RawMessage;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CloudWatchKinesisCodec extends AbstractCodec implements Codec {
    private static final Logger LOG = LoggerFactory.getLogger(CloudWatchKinesisCodec.class);

    public static final String NAME = "AWSCloudWatchKinesis";

    private final ObjectMapper objectMapper;

    @Inject
    public CloudWatchKinesisCodec(@Assisted Configuration configuration, @AWSObjectMapper ObjectMapper objectMapper) {
        super(configuration);
        this.objectMapper = objectMapper;
    }

    @Nullable
    @Override
    public Message decode(@Nonnull RawMessage rawMessage) {
        try {
            final String source = configuration.getString(CloudWatchKinesisCodec.Config.CK_OVERRIDE_SOURCE, "aws-cloudwatch-kinesis");
            final CloudWatchKinesisMessage data = objectMapper.readValue(rawMessage.getPayload(), CloudWatchKinesisMessage.class);
            final Message message = new Message(buildSummary(data), source, DateTime.parse(data.getDetail().getEventTime()));

            LOG.info("CloudWatchKinesisMessage->data: " + buildFields(data).toString());

            message.addFields(buildFields(data));
            message.addField(AWS.FIELD_LOG_GROUP, data.getDetail().getRequestParameters().getLogGroupName());
            message.addField(AWS.FIELD_LOG_STREAM, data.getDetail().getRequestParameters().getLogStreamName());
            //message.addField(AWS.SOURCE_GROUP_IDENTIFIER, true);
            return message;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't deserialize log data", e);
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    @FactoryClass
    public interface Factory extends Codec.Factory<CloudWatchKinesisCodec> {
        @Override
        CloudWatchKinesisCodec create(Configuration configuration);

        @Override
        Config getConfig();
    }

    @ConfigClass
    public static class Config extends AbstractCodec.Config {
        @Override
        public ConfigurationRequest getRequestedConfiguration() {
            return new ConfigurationRequest();
        }

        @Override
        public void overrideDefaultValues(@Nonnull ConfigurationRequest cr) {
        }
    }

    private String buildSummary(CloudWatchKinesisMessage msg) {
        return new StringBuilder()
                .append(msg.getId()).append(" ")
                .append(msg.getSource()).append(" ")
                .append(msg.getDetail().getEventName()).append(" ")
                .append(msg.getDetail().getEventType()).append(" ")
                .toString();
    }

    private Map<String, Object> buildFields(CloudWatchKinesisMessage msg) {
        return new HashMap<String, Object>() {{
            put("version", msg.getVersion());
            put("id", msg.getId());
            put("source", msg.getSource());
            put("account", msg.getAccount());
            put("logTime", msg.getTime());
            put("region", msg.getRegion());
            put("eventTime", msg.getDetail().getEventTime());
            put("eventSource", msg.getDetail().getEventSource());
            put("eventName", msg.getDetail().getEventName());
            put("awsRegion", msg.getDetail().getAwsRegion());
            put("sourceIPAddress", msg.getDetail().getSourceIPAddress());
            put("userAgent", msg.getDetail().getUserAgent());
            put("requestID", msg.getDetail().getRequestID());
            put("eventID", msg.getDetail().getEventID());
            put("eventType", msg.getDetail().getEventType());
            put("apiVersion", msg.getDetail().getApiVersion());
            put("logGroupName", msg.getDetail().getRequestParameters().getLogGroupName());
            put("logStreamName", msg.getDetail().getRequestParameters().getLogStreamName());

        }};
    }
}
