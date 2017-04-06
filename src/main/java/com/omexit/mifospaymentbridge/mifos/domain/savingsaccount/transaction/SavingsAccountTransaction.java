
package com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.transaction;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "transactionType",
    "accountId",
    "accountNo",
    "date",
    "currency",
    "amount",
    "runningBalance",
    "reversed",
    "submittedOnDate",
    "interestedPostedAsOn"
})
public class SavingsAccountTransaction implements Serializable
{

    @JsonProperty("id")
    private Long id;
    @JsonProperty("transactionType")
    private TransactionType transactionType;
    @JsonProperty("accountId")
    private Long accountId;
    @JsonProperty("accountNo")
    private String accountNo;
    @JsonProperty("date")
    private List<Long> date = new ArrayList<Long>();
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("amount")
    private Long amount;
    @JsonProperty("runningBalance")
    private Long runningBalance;
    @JsonProperty("reversed")
    private Boolean reversed;
    @JsonProperty("submittedOnDate")
    private List<Long> submittedOnDate = new ArrayList<Long>();
    @JsonProperty("interestedPostedAsOn")
    private Boolean interestedPostedAsOn;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1095804615370873468L;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("transactionType")
    public TransactionType getTransactionType() {
        return transactionType;
    }

    @JsonProperty("transactionType")
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @JsonProperty("accountId")
    public Long getAccountId() {
        return accountId;
    }

    @JsonProperty("accountId")
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("accountNo")
    public String getAccountNo() {
        return accountNo;
    }

    @JsonProperty("accountNo")
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @JsonProperty("date")
    public List<Long> getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(List<Long> date) {
        this.date = date;
    }

    @JsonProperty("currency")
    public Currency getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @JsonProperty("amount")
    public Long getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @JsonProperty("runningBalance")
    public Long getRunningBalance() {
        return runningBalance;
    }

    @JsonProperty("runningBalance")
    public void setRunningBalance(Long runningBalance) {
        this.runningBalance = runningBalance;
    }

    @JsonProperty("reversed")
    public Boolean getReversed() {
        return reversed;
    }

    @JsonProperty("reversed")
    public void setReversed(Boolean reversed) {
        this.reversed = reversed;
    }

    @JsonProperty("submittedOnDate")
    public List<Long> getSubmittedOnDate() {
        return submittedOnDate;
    }

    @JsonProperty("submittedOnDate")
    public void setSubmittedOnDate(List<Long> submittedOnDate) {
        this.submittedOnDate = submittedOnDate;
    }

    @JsonProperty("interestedPostedAsOn")
    public Boolean getInterestedPostedAsOn() {
        return interestedPostedAsOn;
    }

    @JsonProperty("interestedPostedAsOn")
    public void setInterestedPostedAsOn(Boolean interestedPostedAsOn) {
        this.interestedPostedAsOn = interestedPostedAsOn;
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
