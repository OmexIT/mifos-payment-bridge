package com.omexit.mifospaymentbridge.types;

/**
 * Created by aomeri on 8/4/15.
 */
public enum SecurityPrivilage {
    LOG_IN(1, "securityPrivilage.login"),
    CREATE_CUSTOMER(2, "securityPrivilage.createcustomer");


    private final Integer value;
    private final String code;

    private SecurityPrivilage(final Integer value, final String code) {
        this.value = value;
        this.code = code;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }

    public static SecurityPrivilage fromInt(final Integer selectedMethod) {

        SecurityPrivilage securityPrivilage = null;
        switch (selectedMethod) {
            case 1:
                securityPrivilage = SecurityPrivilage.LOG_IN;
                break;
            default:
                securityPrivilage = SecurityPrivilage.CREATE_CUSTOMER;
                break;
        }
        return securityPrivilage;
    }

    public boolean isLogin() {
        return this.value.equals(SecurityPrivilage.LOG_IN.getValue());
    }

    public boolean isCreateCustomer() {
        return this.value.equals(SecurityPrivilage.CREATE_CUSTOMER.getValue());
    }
}
