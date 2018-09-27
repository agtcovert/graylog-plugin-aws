package org.graylog.aws.cloudwatch.kinesis;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "logGroupName",
        "logStreamName"
})
public class RequestParameters implements Serializable
{

    @JsonProperty("logGroupName")
    private String logGroupName;
    @JsonProperty("logStreamName")
    private String logStreamName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2698615554148840394L;

    @JsonProperty("logGroupName")
    public String getLogGroupName() {
        return logGroupName;
    }

    @JsonProperty("logGroupName")
    public void setLogGroupName(String logGroupName) {
        this.logGroupName = logGroupName;
    }

    @JsonProperty("logStreamName")
    public String getLogStreamName() {
        return logStreamName;
    }

    @JsonProperty("logStreamName")
    public void setLogStreamName(String logStreamName) {
        this.logStreamName = logStreamName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("logGroupName", logGroupName).append("logStreamName", logStreamName).append("additionalProperties", additionalProperties).toString();
    }
}
