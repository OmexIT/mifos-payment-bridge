package com.omexit.mifospaymentbridge.util;

import lombok.Data;

/**
 * @author Antony Omeri
 */
@Data
public class RestError {

    private Integer status;
    private Integer code;
    private String message;
    private String developerMessage;
    private String exceptionMessage;


    public RestError(Integer status, Integer code, String message, String developerMessage, String exceptionMessage) {
        super();
        if (status == null) {
            throw new NullPointerException("HttpStatus argument cannot be null.");
        }
        this.status = status;
        this.code = code;
        this.message = message;
        this.developerMessage = developerMessage;
        this.exceptionMessage=exceptionMessage;
    }
}