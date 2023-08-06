package com.codeshinobis.csuserprofileapi.exception;

import lombok.Getter;

import static com.codeshinobis.csuserprofileapi.constants.ErrorConstants.INVALID_REQUEST_ERROR_CODE;

@Getter
public class InvalidRequestException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public InvalidRequestException(String errorMessage) {
        this.errorCode = INVALID_REQUEST_ERROR_CODE;
        this.errorMessage = errorMessage;
    }
}
