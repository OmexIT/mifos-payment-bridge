
package com.omexit.mifospaymentbridge.mifos.domain.client;

import java.io.Serializable;
import java.util.HashMap;
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
    "constitution",
    "mainBusinessLine"
})
public class ClientNonPersonDetails implements Serializable
{

    @JsonProperty("constitution")
    private Constitution constitution;
    @JsonProperty("mainBusinessLine")
    private MainBusinessLine mainBusinessLine;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4852239197180105576L;

    @JsonProperty("constitution")
    public Constitution getConstitution() {
        return constitution;
    }

    @JsonProperty("constitution")
    public void setConstitution(Constitution constitution) {
        this.constitution = constitution;
    }

    @JsonProperty("mainBusinessLine")
    public MainBusinessLine getMainBusinessLine() {
        return mainBusinessLine;
    }

    @JsonProperty("mainBusinessLine")
    public void setMainBusinessLine(MainBusinessLine mainBusinessLine) {
        this.mainBusinessLine = mainBusinessLine;
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
