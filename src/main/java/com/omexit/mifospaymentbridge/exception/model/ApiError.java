package com.omexit.mifospaymentbridge.exception.model;

/**
 * Created by aomeri on 1/28/17.
 */
public class ApiError {
    private int status;
    private String message;
    private String developerMessage;

    public ApiError(int status, String message, String developerMessage) {
        this.setStatus(status);
        this.setMessage(message);
        this.setDeveloperMessage(developerMessage);
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiError apiError = (ApiError) o;

        if (status != apiError.status) return false;
        if (!message.equals(apiError.message)) return false;
        return developerMessage.equals(apiError.developerMessage);
    }

    @Override
    public int hashCode() {
        int result = status;
        result = 31 * result + message.hashCode();
        result = 31 * result + developerMessage.hashCode();
        return result;
    }
}
