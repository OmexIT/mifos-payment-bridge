
package com.omexit.mifospaymentbridge.mifos.domain.client;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "accountNo",
    "externalId",
    "status",
    "subStatus",
    "active",
    "activationDate",
    "firstname",
    "middlename",
    "lastname",
    "displayName",
    "mobileNo",
    "dateOfBirth",
    "gender",
    "clientType",
    "clientClassification",
    "officeId",
    "officeName",
    "staffId",
    "staffName",
    "timeline",
    "savingsAccountId",
    "legalForm",
    "groups",
    "clientNonPersonDetails"
})
public class Client implements Serializable
{

    @JsonProperty("id")
    private Long id;
    @JsonProperty("accountNo")
    private String accountNo;
    @JsonProperty("externalId")
    private String externalId;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("subStatus")
    private SubStatus subStatus;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("activationDate")
    private List<Long> activationDate = new ArrayList<Long>();
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("middlename")
    private String middlename;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("mobileNo")
    private String mobileNo;
    @JsonProperty("dateOfBirth")
    private List<Long> dateOfBirth = new ArrayList<Long>();
    @JsonProperty("gender")
    private Gender gender;
    @JsonProperty("clientType")
    private ClientType clientType;
    @JsonProperty("clientClassification")
    private ClientClassification clientClassification;
    @JsonProperty("officeId")
    private Long officeId;
    @JsonProperty("officeName")
    private String officeName;
    @JsonProperty("staffId")
    private Long staffId;
    @JsonProperty("staffName")
    private String staffName;
    @JsonProperty("timeline")
    private Timeline timeline;
    @JsonProperty("savingsAccountId")
    private Long savingsAccountId;
    @JsonProperty("legalForm")
    private LegalForm legalForm;
    @JsonProperty("groups")
    private List<Group> groups = new ArrayList<Group>();
    @JsonProperty("clientNonPersonDetails")
    private ClientNonPersonDetails clientNonPersonDetails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -628456597535640137L;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("accountNo")
    public String getAccountNo() {
        return accountNo;
    }

    @JsonProperty("accountNo")
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @JsonProperty("externalId")
    public String getExternalId() {
        return externalId;
    }

    @JsonProperty("externalId")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("subStatus")
    public SubStatus getSubStatus() {
        return subStatus;
    }

    @JsonProperty("subStatus")
    public void setSubStatus(SubStatus subStatus) {
        this.subStatus = subStatus;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("activationDate")
    public List<Long> getActivationDate() {
        return activationDate;
    }

    @JsonProperty("activationDate")
    public void setActivationDate(List<Long> activationDate) {
        this.activationDate = activationDate;
    }

    @JsonProperty("firstname")
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty("firstname")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @JsonProperty("middlename")
    public String getMiddlename() {
        return middlename;
    }

    @JsonProperty("middlename")
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    @JsonProperty("lastname")
    public String getLastname() {
        return lastname;
    }

    @JsonProperty("lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("mobileNo")
    public String getMobileNo() {
        return mobileNo;
    }

    @JsonProperty("mobileNo")
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @JsonProperty("dateOfBirth")
    public List<Long> getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(List<Long> dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @JsonProperty("gender")
    public Gender getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @JsonProperty("clientType")
    public ClientType getClientType() {
        return clientType;
    }

    @JsonProperty("clientType")
    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    @JsonProperty("clientClassification")
    public ClientClassification getClientClassification() {
        return clientClassification;
    }

    @JsonProperty("clientClassification")
    public void setClientClassification(ClientClassification clientClassification) {
        this.clientClassification = clientClassification;
    }

    @JsonProperty("officeId")
    public Long getOfficeId() {
        return officeId;
    }

    @JsonProperty("officeId")
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    @JsonProperty("officeName")
    public String getOfficeName() {
        return officeName;
    }

    @JsonProperty("officeName")
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    @JsonProperty("staffId")
    public Long getStaffId() {
        return staffId;
    }

    @JsonProperty("staffId")
    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    @JsonProperty("staffName")
    public String getStaffName() {
        return staffName;
    }

    @JsonProperty("staffName")
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @JsonProperty("timeline")
    public Timeline getTimeline() {
        return timeline;
    }

    @JsonProperty("timeline")
    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    @JsonProperty("savingsAccountId")
    public Long getSavingsAccountId() {
        return savingsAccountId;
    }

    @JsonProperty("savingsAccountId")
    public void setSavingsAccountId(Long savingsAccountId) {
        this.savingsAccountId = savingsAccountId;
    }

    @JsonProperty("legalForm")
    public LegalForm getLegalForm() {
        return legalForm;
    }

    @JsonProperty("legalForm")
    public void setLegalForm(LegalForm legalForm) {
        this.legalForm = legalForm;
    }

    @JsonProperty("groups")
    public List<Group> getGroups() {
        return groups;
    }

    @JsonProperty("groups")
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @JsonProperty("clientNonPersonDetails")
    public ClientNonPersonDetails getClientNonPersonDetails() {
        return clientNonPersonDetails;
    }

    @JsonProperty("clientNonPersonDetails")
    public void setClientNonPersonDetails(ClientNonPersonDetails clientNonPersonDetails) {
        this.clientNonPersonDetails = clientNonPersonDetails;
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
