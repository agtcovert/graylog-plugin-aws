package org.graylog.aws.cloudwatch;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.graylog.aws.cloudwatch.kinesis.Detail;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "version",
        "id",
        "detail-type",
        "source",
        "account",
        "time",
        "region",
        "resources",
        "detail"
})
public class CloudWatchKinesisMessage implements Serializable
{

    @JsonProperty("version")
    private String version;
    @JsonProperty("id")
    private String id;
    @JsonProperty("detail-type")
    private String detailType;
    @JsonProperty("source")
    private String source;
    @JsonProperty("account")
    private String account;
    @JsonProperty("time")
    private String time;
    @JsonProperty("region")
    private String region;
    @JsonProperty("resources")
    private List<Object> resources = null;
    @JsonProperty("detail")
    private Detail detail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8505448016117381371L;

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("detail-type")
    public String getDetailType() {
        return detailType;
    }

    @JsonProperty("detail-type")
    public void setDetailType(String detailType) {
        this.detailType = detailType;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("account")
    public String getAccount() {
        return account;
    }

    @JsonProperty("account")
    public void setAccount(String account) {
        this.account = account;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("resources")
    public List<Object> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<Object> resources) {
        this.resources = resources;
    }

    @JsonProperty("detail")
    public Detail getDetail() {
        return detail;
    }

    @JsonProperty("detail")
    public void setDetail(Detail detail) {
        this.detail = detail;
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
        return new ToStringBuilder(this).append("version", version).append("id", id).append("detailType", detailType).append("source", source).append("account", account).append("time", time).append("region", region).append("resources", resources).append("detail", detail).append("additionalProperties", additionalProperties).toString();
    }
}


