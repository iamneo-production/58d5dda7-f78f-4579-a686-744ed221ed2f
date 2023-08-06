package com.codeshinobis.cscurrencyexchangeapi.exception;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codeshinobis.cscurrencyexchangeapi.model.ErrorDto;
import com.codeshinobis.cscurrencyexchangeapi.model.ResponseDto;

@RestControllerAdvice
public class ApiExceptionHandler {

    private final Map<CsErrorCodes,ErrorDto> errorCodeMap;

    public ApiExceptionHandler() {
        this.errorCodeMap = registerErrorCodeMap();
    }

    @ExceptionHandler(CsException.class)
    public ResponseEntity<ResponseDto<Object>> handleCsException(CsException csException) {
        ResponseDto<Object> responseBody = 
            ResponseDto.forError(Collections.singletonList(
                this.errorCodeMap.getOrDefault(csException.getCode(), this.errorCodeMap.get(CsErrorCodes.UNKNOWN_ERROR))));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto<Object>> handleException(Exception exception) {
        ResponseDto<Object> responseBody = 
            ResponseDto.forError(Collections.singletonList(
                this.errorCodeMap.get(CsErrorCodes.UNKNOWN_ERROR)));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    private Map<CsErrorCodes,ErrorDto> registerErrorCodeMap() {
        Map<CsErrorCodes,ErrorDto> errorCodeMap = new HashMap<>();
        errorCodeMap.put(CsErrorCodes.UNAUTHORIZED_USER, new ErrorDto("1000", "User not authorized!"));
        errorCodeMap.put(CsErrorCodes.INVALID_REQUEST, new ErrorDto("1001", "Invalid Request"));
        errorCodeMap.put(CsErrorCodes.INVALID_CURRENCY_TYPE, new ErrorDto("1002", "Invalid Currency Type"));
        errorCodeMap.put(CsErrorCodes.UNKNOWN_ERROR, new ErrorDto("1099", "Unexpected Error Occurred!"));
        return errorCodeMap;
    }
    
}
