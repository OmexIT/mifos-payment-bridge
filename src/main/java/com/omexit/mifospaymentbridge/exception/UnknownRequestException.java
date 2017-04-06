package com.omexit.mifospaymentbridge.exception;


import com.omexit.mifospaymentbridge.types.ReasonCode;

/**
 * Created by aomeri on 12/9/2015.
 */
public class UnknownRequestException extends Exception {
    private static final long serialVersionUID = 48598860123L;
    private String developerMessage;
    private ReasonCode reasonCode;
    private String message;

    public UnknownRequestException(String message, String developerMessage, ReasonCode reasonCode) {
        super(developerMessage);
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
