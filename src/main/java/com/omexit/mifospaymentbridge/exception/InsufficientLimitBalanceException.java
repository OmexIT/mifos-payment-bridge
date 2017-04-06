package com.omexit.mifospaymentbridge.exception;


import com.omexit.mifospaymentbridge.types.ReasonCode;

/**
 * Created by Antony on 7/19/2016.
 */
public class InsufficientLimitBalanceException extends Exception {

    private static final long serialVersionUID = 48598860121L;
    private String developerMessage;
    private ReasonCode reasonCode;
    private String message;

    public InsufficientLimitBalanceException(String message, String developerMessage, ReasonCode reasonCode) {
        super(message);
        this.developerMessage = developerMessage;
        this.reasonCode = reasonCode;
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public ReasonCode getReasonCode() {
        return reasonCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
