
package com.omexit.mifospaymentbridge.mifos.domain.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "submittedOnDate",
    "submittedByUsername",
    "submittedByFirstname",
    "submittedByLastname",
    "activatedOnDate",
    "activatedByUsername",
    "activatedByFirstname",
    "activatedByLastname"
})
public class Timeline implements Serializable
{

    @JsonProperty("submittedOnDate")
    private List<Long> submittedOnDate = new ArrayList<Long>();
    @JsonProperty("submittedByUsername")
    private String submittedByUsername;
    @JsonProperty("submittedByFirstname")
    private String submittedByFirstname;
    @JsonProperty("submittedByLastname")
    private String submittedByLastname;
    @JsonProperty("activatedOnDate")
    private List<Long> activatedOnDate = new ArrayList<Long>();
    @JsonProperty("activatedByUsername")
    private String activatedByUsername;
    @JsonProperty("activatedByFirstname")
    private String activatedByFirstname;
    @JsonProperty("activatedByLastname")
    private String activatedByLastname;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1234767196932350290L;

    @JsonProperty("submittedOnDate")
    public List<Long> getSubmittedOnDate() {
        return submittedOnDate;
    }

    @JsonProperty("submittedOnDate")
    public void setSubmittedOnDate(List<Long> submittedOnDate) {
        this.submittedOnDate = submittedOnDate;
    }

    @JsonProperty("submittedByUsername")
    public String getSubmittedByUsername() {
        return submittedByUsername;
    }

    @JsonProperty("submittedByUsername")
    public void setSubmittedByUsername(String submittedByUsername) {
        this.submittedByUsername = submittedByUsername;
    }

    @JsonProperty("submittedByFirstname")
    public String getSubmittedByFirstname() {
        return submittedByFirstname;
    }

    @JsonProperty("submittedByFirstname")
    public void setSubmittedByFirstname(String submittedByFirstname) {
        this.submittedByFirstname = submittedByFirstname;
    }

    @JsonProperty("submittedByLastname")
    public String getSubmittedByLastname() {
        return submittedByLastname;
    }

    @JsonProperty("submittedByLastname")
    public void setSubmittedByLastname(String submittedByLastname) {
        this.submittedByLastname = submittedByLastname;
    }

    @JsonProperty("activatedOnDate")
    public List<Long> getActivatedOnDate() {
        return activatedOnDate;
    }

    @JsonProperty("activatedOnDate")
    public void setActivatedOnDate(List<Long> activatedOnDate) {
        this.activatedOnDate = activatedOnDate;
    }

    @JsonProperty("activatedByUsername")
    public String getActivatedByUsername() {
        return activatedByUsername;
    }

    @JsonProperty("activatedByUsername")
    public void setActivatedByUsername(String activatedByUsername) {
        this.activatedByUsername = activatedByUsername;
    }

    @JsonProperty("activatedByFirstname")
    public String getActivatedByFirstname() {
        return activatedByFirstname;
    }

    @JsonProperty("activatedByFirstname")
    public void setActivatedByFirstname(String activatedByFirstname) {
        this.activatedByFirstname = activatedByFirstname;
    }

    @JsonProperty("activatedByLastname")
    public String getActivatedByLastname() {
        return activatedByLastname;
    }

    @JsonProperty("activatedByLastname")
    public void setActivatedByLastname(String activatedByLastname) {
        this.activatedByLastname = activatedByLastname;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
