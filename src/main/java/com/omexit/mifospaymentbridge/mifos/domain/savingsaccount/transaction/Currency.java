
package com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.transaction;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "name",
    "decimalPlaces",
    "inMultiplesOf",
    "displaySymbol",
    "nameCode",
    "displayLabel"
})
public class Currency implements Serializable
{

    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("decimalPlaces")
    private Long decimalPlaces;
    @JsonProperty("inMultiplesOf")
    private Long inMultiplesOf;
    @JsonProperty("displaySymbol")
    private String displaySymbol;
    @JsonProperty("nameCode")
    private String nameCode;
    @JsonProperty("displayLabel")
    private String displayLabel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5821135110648085438L;

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("decimalPlaces")
    public Long getDecimalPlaces() {
        return decimalPlaces;
    }

    @JsonProperty("decimalPlaces")
    public void setDecimalPlaces(Long decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    @JsonProperty("inMultiplesOf")
    public Long getInMultiplesOf() {
        return inMultiplesOf;
    }

    @JsonProperty("inMultiplesOf")
    public void setInMultiplesOf(Long inMultiplesOf) {
        this.inMultiplesOf = inMultiplesOf;
    }

    @JsonProperty("displaySymbol")
    public String getDisplaySymbol() {
        return displaySymbol;
    }

    @JsonProperty("displaySymbol")
    public void setDisplaySymbol(String displaySymbol) {
        this.displaySymbol = displaySymbol;
    }

    @JsonProperty("nameCode")
    public String getNameCode() {
        return nameCode;
    }

    @JsonProperty("nameCode")
    public void setNameCode(String nameCode) {
        this.nameCode = nameCode;
    }

    @JsonProperty("displayLabel")
    public String getDisplayLabel() {
        return displayLabel;
    }

    @JsonProperty("displayLabel")
    public void setDisplayLabel(String displayLabel) {
        this.displayLabel = displayLabel;
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
