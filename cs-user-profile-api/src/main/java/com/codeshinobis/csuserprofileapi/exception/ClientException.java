package com.codeshinobis.csuserprofileapi.exception;

import static com.codeshinobis.csuserprofileapi.constants.ErrorConstants.CLIENT_ERROR_CODE;

import lombok.Data;

@Data
public class ClientException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public ClientException(String errorMessage) {
        this.errorCode = CLIENT_ERROR_CODE;
        this.errorMessage = errorMessage;
    }
    
}
