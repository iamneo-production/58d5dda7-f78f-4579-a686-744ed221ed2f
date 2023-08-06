package com.codeshinobis.csuserprofileapi.config;

import com.codeshinobis.csuserprofileapi.exception.InvalidRequestException;
import com.codeshinobis.csuserprofileapi.model.ErrorDto;
import com.codeshinobis.csuserprofileapi.model.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

import static com.codeshinobis.csuserprofileapi.constants.ErrorConstants.*;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = InvalidRequestException.class)
    public ResponseEntity<ResponseDto<Object>> handleInvalidRequestException(InvalidRequestException ex) {
        ErrorDto error = new ErrorDto(ex.getErrorCode(), ex.getErrorMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDto.forError(Arrays.asList(error)));
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ResponseDto<Object>> handleRuntimeException(RuntimeException ex) {
        ErrorDto error = new ErrorDto(UNKNOWN_ERROR_CODE, ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseDto.forError(Arrays.asList(error)));
    }

}
