package com.codeshinobis.csloggerapi.controller;

import com.codeshinobis.csloggerapi.model.LoggerDto;
import com.codeshinobis.csloggerapi.model.ResponseDto;
import com.codeshinobis.csloggerapi.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController {

    private LoggerService service;

    @Autowired
    public LoggerController(LoggerService service) {
        this.service = service;
    }

    @PostMapping("/log")
    public ResponseEntity<ResponseDto<String>> logger(@RequestBody LoggerDto dto) {
        service.logging(dto.getMessage(), dto.getLevel(), dto.getClassName(), dto.getMethodName());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess("Logging Successful"));
    }

}
