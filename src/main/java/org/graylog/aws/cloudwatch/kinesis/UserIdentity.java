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
        "type",
        "principalId",
        "arn",
        "accountId",
        "accessKeyId",
        "sessionContext"
})
public class UserIdentity implements Serializable
{

    @JsonProperty("type")
    private String type;
    @JsonProperty("principalId")
    private String principalId;
    @JsonProperty("arn")
    private String arn;
    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("accessKeyId")
    private String accessKeyId;
    @JsonProperty("sessionContext")
    private SessionContext sessionContext;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6465047098911995720L;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("principalId")
    public String getPrincipalId() {
        return principalId;
    }

    @JsonProperty("principalId")
    public void setPrincipalId(String principalId) {
        this.principalId = principalId;
    }

    @JsonProperty("arn")
    public String getArn() {
        return arn;
    }

    @JsonProperty("arn")
    public void setArn(String arn) {
        this.arn = arn;
    }

    @JsonProperty("accountId")
    public String getAccountId() {
        return accountId;
    }

    @JsonProperty("accountId")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("accessKeyId")
    public String getAccessKeyId() {
        return accessKeyId;
    }

    @JsonProperty("accessKeyId")
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    @JsonProperty("sessionContext")
    public SessionContext getSessionContext() {
        return sessionContext;
    }

    @JsonProperty("sessionContext")
    public void setSessionContext(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
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
        return new ToStringBuilder(this).append("type", type).append("principalId", principalId).append("arn", arn).append("accountId", accountId).append("accessKeyId", accessKeyId).append("sessionContext", sessionContext).append("additionalProperties", additionalProperties).toString();
    }
}