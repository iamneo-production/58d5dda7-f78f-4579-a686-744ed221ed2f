package com.codeshinobis.csauthapi.exception;

import lombok.Getter;

import static com.codeshinobis.csauthapi.constants.ErrorConstants.TOKEN_ERROR_CODE;

@Getter
public class TokenException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public TokenException(String errorMessage) {
        this.errorCode = TOKEN_ERROR_CODE;
        this.errorMessage = errorMessage;
    }
}
