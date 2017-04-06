package com.omexit.mifospaymentbridge.types;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Antony on 2/11/2016.
 */
public enum PaymentType {
    INVALID_ID(0, "INVALID_ID"),
    INCOMING(1, "INCOMING"),
    OUTGOING(2, "OUTGOING");

    private final Integer value;
    private final String code;

    PaymentType(final Integer value, final String code) {
        this.value = value;
        this.code = code;
    }

    public static PaymentType fromInt(final Integer typeValue) {
        PaymentType enumeration = PaymentType.INVALID_ID;
        switch (typeValue) {
            case 1:
                enumeration = PaymentType.INCOMING;
                break;
            case 2:
                enumeration = PaymentType.OUTGOING;
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

    public boolean isInvalidPaymentType() {
        return this.value.equals(PaymentType.INVALID_ID.getValue());
    }

    public boolean isIncomingPayment() {
        return this.value.equals(PaymentType.INCOMING.getValue());
    }

    public boolean isOutgoingPayment() {
        return this.value.equals(PaymentType.OUTGOING.getValue());
    }
}
