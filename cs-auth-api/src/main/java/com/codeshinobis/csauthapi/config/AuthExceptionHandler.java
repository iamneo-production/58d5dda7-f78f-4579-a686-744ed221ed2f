package com.codeshinobis.csauthapi.config;

import com.codeshinobis.csauthapi.exception.ClientException;
import com.codeshinobis.csauthapi.exception.InvalidRequestException;
import com.codeshinobis.csauthapi.exception.TokenException;
import com.codeshinobis.csauthapi.model.ErrorDto;
import com.codeshinobis.csauthapi.model.ResponseDto;

import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

import static com.codeshinobis.csauthapi.constants.ErrorConstants.*;

@ControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(value = InvalidRequestException.class)
    public ResponseEntity<ResponseDto<Object>> handleInvalidRequestException(InvalidRequestException ex) {
        ErrorDto error = new ErrorDto(ex.getErrorCode(), ex.getErrorMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDto.forError(Arrays.asList(error)));
    }

    @ExceptionHandler(value = TokenException.class)
    public ResponseEntity<ResponseDto<Object>> handleTokenException(TokenException ex) {
        ErrorDto error = new ErrorDto(ex.getErrorCode(), ex.getErrorMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseDto.forError(Arrays.asList(error)));
    }

    @ExceptionHandler(value = ClientException.class)
    public ResponseEntity<ResponseDto<Object>> handleClientException(ClientException ex) {
        ErrorDto error = new ErrorDto(ex.getErrorCode(), ex.getErrorMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseDto.forError(Arrays.asList(error)));
    }

    @ExceptionHandler(value = SignatureException.class)
    public ResponseEntity<ResponseDto<Object>> handleSignatureException(SignatureException ex) {
        ErrorDto error = new ErrorDto(TOKEN_ERROR_CODE, ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseDto.forError(Arrays.asList(error)));
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ResponseDto<Object>> handleRuntimeException(RuntimeException ex) {
        ErrorDto error = new ErrorDto(UNKNOWN_ERROR_CODE, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseDto.forError(Arrays.asList(error)));
    }

}
