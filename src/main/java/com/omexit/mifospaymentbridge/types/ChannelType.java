package com.omexit.mifospaymentbridge.types;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Antony on 2/10/2016.
 */
public enum ChannelType {
    INVALID_ID(0, "INVALID_ID"),
    MOBILE_MONEY_CHANNEL(1, "MOBILE_MONEY_CHANNEL"),
    BANKING_CHANNEL(2, "BANKING_CHANNEL"),
    EMAIL_MONEY_CHANNEL(3, "EMAIL_MONEY_CHANNEL");

    private final Integer value;
    private final String code;

    ChannelType(final Integer value, final String code) {
        this.value = value;
        this.code = code;
    }

    public static ChannelType fromInt(final Integer typeValue) {
        ChannelType enumeration = ChannelType.INVALID_ID;
        switch (typeValue) {
            case 1:
                enumeration = ChannelType.MOBILE_MONEY_CHANNEL;
                break;
            case 2:
                enumeration = ChannelType.BANKING_CHANNEL;
                break;
            case 3:
                enumeration = ChannelType.EMAIL_MONEY_CHANNEL;
                break;
        }

        return enumeration;
    }

    @JsonValue
    public Integer getValue() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }

    public boolean hasTypeOf(final ChannelType type) {
        return this.value.equals(type.getValue());
    }

    public boolean isInvalId() {
        return this.value.equals(ChannelType.INVALID_ID.getValue());
    }

    public boolean isMobileMoneyChannel() {
        return this.value.equals(ChannelType.MOBILE_MONEY_CHANNEL.getValue());
    }

    public boolean isBankingChannel() {
        return this.value.equals(ChannelType.BANKING_CHANNEL.getValue());
    }

    public boolean isEmailMoneyChannel() {
        return this.value.equals(ChannelType.EMAIL_MONEY_CHANNEL.getValue());
    }
}
