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
        "mfaAuthenticated",
        "creationDate"
})
public class Attributes implements Serializable {

    @JsonProperty("mfaAuthenticated")
    private String mfaAuthenticated;
    @JsonProperty("creationDate")
    private String creationDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1535164869373504100L;

    @JsonProperty("mfaAuthenticated")
    public String getMfaAuthenticated() {
        return mfaAuthenticated;
    }

    @JsonProperty("mfaAuthenticated")
    public void setMfaAuthenticated(String mfaAuthenticated) {
        this.mfaAuthenticated = mfaAuthenticated;
    }

    @JsonProperty("creationDate")
    public String getCreationDate() {
        return creationDate;
    }

    @JsonProperty("creationDate")
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
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
        return new ToStringBuilder(this).append("mfaAuthenticated", mfaAuthenticated).append("creationDate", creationDate).append("additionalProperties", additionalProperties).toString();
    }
}
