package com.omexit.mifospaymentbridge.types;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by aomeri on 11/21/2015.
 */
public enum EntityType {

    INVALID_ID(0, "invalid"),
    SAVINGS_ACCOUNT(1, "SAVINGS_ACCOUNT"),
    LOAN(2, "LOAN");

    private final Integer value;
    private final String name;

    private EntityType(final Integer value, final String name) {
        this.value = value;
        this.name = name;
    }

    public static EntityType fromInt(final Integer typeValue) {
        EntityType enumeration = EntityType.INVALID_ID;
        switch (typeValue) {
            case 1:
                enumeration = EntityType.SAVINGS_ACCOUNT;
                break;
            case 2:
                enumeration = EntityType.LOAN;
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

    public boolean hasTypeOf(final EntityType type) {
        return this.value.equals(type.getValue());
    }

    public boolean isInvalId() {
        return this.value.equals(EntityType.INVALID_ID.getValue());
    }

    public boolean isSavingsAccount() {
        return this.value.equals(EntityType.SAVINGS_ACCOUNT.getValue());
    }

    public boolean isLoan() {
        return this.value.equals(EntityType.LOAN.getValue());
    }

}