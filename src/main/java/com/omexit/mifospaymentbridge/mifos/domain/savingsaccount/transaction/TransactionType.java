
package com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.transaction;

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
    "id",
    "code",
    "value",
    "deposit",
    "dividendPayout",
    "withdrawal",
    "interestPosting",
    "feeDeduction",
    "initiateTransfer",
    "approveTransfer",
    "withdrawTransfer",
    "rejectTransfer",
    "overdraftInterest",
    "writtenoff",
    "overdraftFee",
    "withholdTax",
    "escheat"
})
public class TransactionType implements Serializable
{

    @JsonProperty("id")
    private Long id;
    @JsonProperty("code")
    private String code;
    @JsonProperty("value")
    private String value;
    @JsonProperty("deposit")
    private Boolean deposit;
    @JsonProperty("dividendPayout")
    private Boolean dividendPayout;
    @JsonProperty("withdrawal")
    private Boolean withdrawal;
    @JsonProperty("interestPosting")
    private Boolean interestPosting;
    @JsonProperty("feeDeduction")
    private Boolean feeDeduction;
    @JsonProperty("initiateTransfer")
    private Boolean initiateTransfer;
    @JsonProperty("approveTransfer")
    private Boolean approveTransfer;
    @JsonProperty("withdrawTransfer")
    private Boolean withdrawTransfer;
    @JsonProperty("rejectTransfer")
    private Boolean rejectTransfer;
    @JsonProperty("overdraftInterest")
    private Boolean overdraftInterest;
    @JsonProperty("writtenoff")
    private Boolean writtenoff;
    @JsonProperty("overdraftFee")
    private Boolean overdraftFee;
    @JsonProperty("withholdTax")
    private Boolean withholdTax;
    @JsonProperty("escheat")
    private Boolean escheat;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5824567383144158238L;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("deposit")
    public Boolean getDeposit() {
        return deposit;
    }

    @JsonProperty("deposit")
    public void setDeposit(Boolean deposit) {
        this.deposit = deposit;
    }

    @JsonProperty("dividendPayout")
    public Boolean getDividendPayout() {
        return dividendPayout;
    }

    @JsonProperty("dividendPayout")
    public void setDividendPayout(Boolean dividendPayout) {
        this.dividendPayout = dividendPayout;
    }

    @JsonProperty("withdrawal")
    public Boolean getWithdrawal() {
        return withdrawal;
    }

    @JsonProperty("withdrawal")
    public void setWithdrawal(Boolean withdrawal) {
        this.withdrawal = withdrawal;
    }

    @JsonProperty("interestPosting")
    public Boolean getInterestPosting() {
        return interestPosting;
    }

    @JsonProperty("interestPosting")
    public void setInterestPosting(Boolean interestPosting) {
        this.interestPosting = interestPosting;
    }

    @JsonProperty("feeDeduction")
    public Boolean getFeeDeduction() {
        return feeDeduction;
    }

    @JsonProperty("feeDeduction")
    public void setFeeDeduction(Boolean feeDeduction) {
        this.feeDeduction = feeDeduction;
    }

    @JsonProperty("initiateTransfer")
    public Boolean getInitiateTransfer() {
        return initiateTransfer;
    }

    @JsonProperty("initiateTransfer")
    public void setInitiateTransfer(Boolean initiateTransfer) {
        this.initiateTransfer = initiateTransfer;
    }

    @JsonProperty("approveTransfer")
    public Boolean getApproveTransfer() {
        return approveTransfer;
    }

    @JsonProperty("approveTransfer")
    public void setApproveTransfer(Boolean approveTransfer) {
        this.approveTransfer = approveTransfer;
    }

    @JsonProperty("withdrawTransfer")
    public Boolean getWithdrawTransfer() {
        return withdrawTransfer;
    }

    @JsonProperty("withdrawTransfer")
    public void setWithdrawTransfer(Boolean withdrawTransfer) {
        this.withdrawTransfer = withdrawTransfer;
    }

    @JsonProperty("rejectTransfer")
    public Boolean getRejectTransfer() {
        return rejectTransfer;
    }

    @JsonProperty("rejectTransfer")
    public void setRejectTransfer(Boolean rejectTransfer) {
        this.rejectTransfer = rejectTransfer;
    }

    @JsonProperty("overdraftInterest")
    public Boolean getOverdraftInterest() {
        return overdraftInterest;
    }

    @JsonProperty("overdraftInterest")
    public void setOverdraftInterest(Boolean overdraftInterest) {
        this.overdraftInterest = overdraftInterest;
    }

    @JsonProperty("writtenoff")
    public Boolean getWrittenoff() {
        return writtenoff;
    }

    @JsonProperty("writtenoff")
    public void setWrittenoff(Boolean writtenoff) {
        this.writtenoff = writtenoff;
    }

    @JsonProperty("overdraftFee")
    public Boolean getOverdraftFee() {
        return overdraftFee;
    }

    @JsonProperty("overdraftFee")
    public void setOverdraftFee(Boolean overdraftFee) {
        this.overdraftFee = overdraftFee;
    }

    @JsonProperty("withholdTax")
    public Boolean getWithholdTax() {
        return withholdTax;
    }

    @JsonProperty("withholdTax")
    public void setWithholdTax(Boolean withholdTax) {
        this.withholdTax = withholdTax;
    }

    @JsonProperty("escheat")
    public Boolean getEscheat() {
        return escheat;
    }

    @JsonProperty("escheat")
    public void setEscheat(Boolean escheat) {
        this.escheat = escheat;
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
