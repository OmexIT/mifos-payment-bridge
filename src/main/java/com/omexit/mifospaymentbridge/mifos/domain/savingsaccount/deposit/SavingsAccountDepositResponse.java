
package com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.deposit;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "officeId",
    "clientId",
    "savingsId",
    "resourceId",
    "changes"
})
public class SavingsAccountDepositResponse implements Serializable
{

    @JsonProperty("officeId")
    private Long officeId;
    @JsonProperty("clientId")
    private Long clientId;
    @JsonProperty("savingsId")
    private Long savingsId;
    @JsonProperty("resourceId")
    private Long resourceId;
    @JsonProperty("changes")
    private Changes changes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -9073044646450774495L;

    @JsonProperty("officeId")
    public Long getOfficeId() {
        return officeId;
    }

    @JsonProperty("officeId")
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    @JsonProperty("clientId")
    public Long getClientId() {
        return clientId;
    }

    @JsonProperty("clientId")
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @JsonProperty("savingsId")
    public Long getSavingsId() {
        return savingsId;
    }

    @JsonProperty("savingsId")
    public void setSavingsId(Long savingsId) {
        this.savingsId = savingsId;
    }

    @JsonProperty("resourceId")
    public Long getResourceId() {
        return resourceId;
    }

    @JsonProperty("resourceId")
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    @JsonProperty("changes")
    public Changes getChanges() {
        return changes;
    }

    @JsonProperty("changes")
    public void setChanges(Changes changes) {
        this.changes = changes;
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
