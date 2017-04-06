package com.omexit.mifospaymentbridge.types;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by aomeri on 11/21/2015.
 */
public enum ActionType {

    INVALID_ID(0, "invalid"),
    WITHDRAW(1, "WITHDRAW"),
    DEPOSIT(2, "DEPOSIT"),
    DISBURSE(3, "DISBURSE");

    private final Integer value;
    private final String name;

    private ActionType(final Integer value, final String name) {
        this.value = value;
        this.name = name;
    }

    public static ActionType fromInt(final Integer typeValue) {
        ActionType enumeration = ActionType.INVALID_ID;
        switch (typeValue) {
            case 1:
                enumeration = ActionType.WITHDRAW;
                break;
            case 2:
                enumeration = ActionType.DEPOSIT;
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

    public boolean hasTypeOf(final ActionType type) {
        return this.value.equals(type.getValue());
    }

    public boolean isInvalId() {
        return this.value.equals(ActionType.INVALID_ID.getValue());
    }

    public boolean isWithdraw() {
        return this.value.equals(ActionType.WITHDRAW.getValue());
    }

    public boolean isDeposit() {
        return this.value.equals(ActionType.DEPOSIT.getValue());
    }

    public boolean isDisburse() {
        return this.value.equals(ActionType.DISBURSE.getValue());
    }
}