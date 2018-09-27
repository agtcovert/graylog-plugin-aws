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
        "attributes",
        "sessionIssuer"
})
public class SessionContext implements Serializable
{

    @JsonProperty("attributes")
    private Attributes attributes;
    @JsonProperty("sessionIssuer")
    private SessionIssuer sessionIssuer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3208720249318977429L;

    @JsonProperty("attributes")
    public Attributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("sessionIssuer")
    public SessionIssuer getSessionIssuer() {
        return sessionIssuer;
    }

    @JsonProperty("sessionIssuer")
    public void setSessionIssuer(SessionIssuer sessionIssuer) {
        this.sessionIssuer = sessionIssuer;
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
        return new ToStringBuilder(this).append("attributes", attributes).append("sessionIssuer", sessionIssuer).append("additionalProperties", additionalProperties).toString();
    }
}
