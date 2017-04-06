
package com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.deposit;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "locale",
    "dateFormat",
    "transactionDate",
    "transactionAmount",
    "paymentTypeId",
    "accountNumber",
    "checkNumber",
    "routingCode",
    "receiptNumber",
    "bankNumber"
})
public class SavingsAccountDepositRequest implements Serializable
{

    @JsonProperty("locale")
    private String locale;
    @JsonProperty("dateFormat")
    private String dateFormat;
    @JsonProperty("transactionDate")
    private String transactionDate;
    @JsonProperty("transactionAmount")
    private String transactionAmount;
    @JsonProperty("paymentTypeId")
    private String paymentTypeId;
    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("checkNumber")
    private String checkNumber;
    @JsonProperty("routingCode")
    private String routingCode;
    @JsonProperty("receiptNumber")
    private String receiptNumber;
    @JsonProperty("bankNumber")
    private String bankNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6494314273771094973L;

    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
    }

    @JsonProperty("dateFormat")
    public String getDateFormat() {
        return dateFormat;
    }

    @JsonProperty("dateFormat")
    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @JsonProperty("transactionDate")
    public String getTransactionDate() {
        return transactionDate;
    }

    @JsonProperty("transactionDate")
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    @JsonProperty("transactionAmount")
    public String getTransactionAmount() {
        return transactionAmount;
    }

    @JsonProperty("transactionAmount")
    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @JsonProperty("paymentTypeId")
    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    @JsonProperty("paymentTypeId")
    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    @JsonProperty("accountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }

    @JsonProperty("accountNumber")
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @JsonProperty("checkNumber")
    public String getCheckNumber() {
        return checkNumber;
    }

    @JsonProperty("checkNumber")
    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @JsonProperty("routingCode")
    public String getRoutingCode() {
        return routingCode;
    }

    @JsonProperty("routingCode")
    public void setRoutingCode(String routingCode) {
        this.routingCode = routingCode;
    }

    @JsonProperty("receiptNumber")
    public String getReceiptNumber() {
        return receiptNumber;
    }

    @JsonProperty("receiptNumber")
    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    @JsonProperty("bankNumber")
    public String getBankNumber() {
        return bankNumber;
    }

    @JsonProperty("bankNumber")
    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
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
