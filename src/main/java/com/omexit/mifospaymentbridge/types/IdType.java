package com.omexit.mifospaymentbridge.types;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by aomeri on 11/21/2015.
 */
public enum IdType {

    INVALID_ID(0, "invalid"),
    NATIONAL_ID(1, "National Id"),
    PASSPORT_NUMBER(2, "Passport Number");

    private final Integer value;
    private final String name;

    private IdType(final Integer value, final String name) {
        this.value = value;
        this.name = name;
    }

    public static IdType fromInt(final Integer typeValue) {
        IdType enumeration = IdType.INVALID_ID;
        switch (typeValue) {
            case 1:
                enumeration = IdType.NATIONAL_ID;
                break;
            case 2:
                enumeration = IdType.PASSPORT_NUMBER;
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

    public boolean hasTypeOf(final IdType type) {
        return this.value.equals(type.getValue());
    }

    public boolean isInvalId() {
        return this.value.equals(IdType.INVALID_ID.getValue());
    }

    public boolean isNationalId() {
        return this.value.equals(IdType.NATIONAL_ID.getValue());
    }

    public boolean isPassportNumber() {
        return this.value.equals(IdType.PASSPORT_NUMBER.getValue());
    }
}