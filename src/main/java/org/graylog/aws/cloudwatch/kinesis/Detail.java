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
        "eventVersion",
        "userIdentity",
        "eventTime",
        "eventSource",
        "eventName",
        "awsRegion",
        "sourceIPAddress",
        "userAgent",
        "requestParameters",
        "responseElements",
        "requestID",
        "eventID",
        "eventType",
        "apiVersion"
})
public class Detail implements Serializable
{

    @JsonProperty("eventVersion")
    private String eventVersion;
    @JsonProperty("userIdentity")
    private UserIdentity userIdentity;
    @JsonProperty("eventTime")
    private String eventTime;
    @JsonProperty("eventSource")
    private String eventSource;
    @JsonProperty("eventName")
    private String eventName;
    @JsonProperty("awsRegion")
    private String awsRegion;
    @JsonProperty("sourceIPAddress")
    private String sourceIPAddress;
    @JsonProperty("userAgent")
    private String userAgent;
    @JsonProperty("requestParameters")
    private RequestParameters requestParameters;
    @JsonProperty("responseElements")
    private Object responseElements;
    @JsonProperty("requestID")
    private String requestID;
    @JsonProperty("eventID")
    private String eventID;
    @JsonProperty("eventType")
    private String eventType;
    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -9114768594637319109L;

    @JsonProperty("eventVersion")
    public String getEventVersion() {
        return eventVersion;
    }

    @JsonProperty("eventVersion")
    public void setEventVersion(String eventVersion) {
        this.eventVersion = eventVersion;
    }

    @JsonProperty("userIdentity")
    public UserIdentity getUserIdentity() {
        return userIdentity;
    }

    @JsonProperty("userIdentity")
    public void setUserIdentity(UserIdentity userIdentity) {
        this.userIdentity = userIdentity;
    }

    @JsonProperty("eventTime")
    public String getEventTime() {
        return eventTime;
    }

    @JsonProperty("eventTime")
    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    @JsonProperty("eventSource")
    public String getEventSource() {
        return eventSource;
    }

    @JsonProperty("eventSource")
    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    @JsonProperty("eventName")
    public String getEventName() {
        return eventName;
    }

    @JsonProperty("eventName")
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @JsonProperty("awsRegion")
    public String getAwsRegion() {
        return awsRegion;
    }

    @JsonProperty("awsRegion")
    public void setAwsRegion(String awsRegion) {
        this.awsRegion = awsRegion;
    }

    @JsonProperty("sourceIPAddress")
    public String getSourceIPAddress() {
        return sourceIPAddress;
    }

    @JsonProperty("sourceIPAddress")
    public void setSourceIPAddress(String sourceIPAddress) {
        this.sourceIPAddress = sourceIPAddress;
    }

    @JsonProperty("userAgent")
    public String getUserAgent() {
        return userAgent;
    }

    @JsonProperty("userAgent")
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @JsonProperty("requestParameters")
    public RequestParameters getRequestParameters() {
        return requestParameters;
    }

    @JsonProperty("requestParameters")
    public void setRequestParameters(RequestParameters requestParameters) {
        this.requestParameters = requestParameters;
    }

    @JsonProperty("responseElements")
    public Object getResponseElements() {
        return responseElements;
    }

    @JsonProperty("responseElements")
    public void setResponseElements(Object responseElements) {
        this.responseElements = responseElements;
    }

    @JsonProperty("requestID")
    public String getRequestID() {
        return requestID;
    }

    @JsonProperty("requestID")
    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    @JsonProperty("eventID")
    public String getEventID() {
        return eventID;
    }

    @JsonProperty("eventID")
    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    @JsonProperty("eventType")
    public String getEventType() {
        return eventType;
    }

    @JsonProperty("eventType")
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
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
        return new ToStringBuilder(this).append("eventVersion", eventVersion).append("userIdentity", userIdentity).append("eventTime", eventTime).append("eventSource", eventSource).append("eventName", eventName).append("awsRegion", awsRegion).append("sourceIPAddress", sourceIPAddress).append("userAgent", userAgent).append("requestParameters", requestParameters).append("responseElements", responseElements).append("requestID", requestID).append("eventID", eventID).append("eventType", eventType).append("apiVersion", apiVersion).append("additionalProperties", additionalProperties).toString();
    }
}
