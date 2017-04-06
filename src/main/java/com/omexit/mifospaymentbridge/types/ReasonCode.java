package com.omexit.mifospaymentbridge.types;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by aomeri on 11/21/2015.
 */
public enum ReasonCode {

    OK(0,"OK"),
    CHANNEL_NOT_FOUND(1000, "Channel not found!"),
    RESOURCE_NOT_FOUND(1002, "Resource not found!"),
    INVALID_PHONE_NUMBER(1003, "Invalid phone number!");

    private final Integer value;
    private final String name;

    private ReasonCode(final Integer value, final String name) {
        this.value = value;
        this.name = name;
    }

    public static ReasonCode fromInt(final Integer typeValue) {
        ReasonCode enumeration = ReasonCode.OK;
        switch (typeValue) {
            case 1000:
                enumeration = ReasonCode.CHANNEL_NOT_FOUND;
                break;
            case 1002:
                enumeration = ReasonCode.RESOURCE_NOT_FOUND;
                break;
            case 1003:
                enumeration = ReasonCode.INVALID_PHONE_NUMBER;
                break;
        }

        return enumeration;
    }

    @JsonValue
    public Integer getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public boolean hasTypeOf(final ReasonCode type) {
        return this.value.equals(type.getValue());
    }

    public boolean isOK() {
        return this.value.equals(ReasonCode.OK.getValue());
    }

}