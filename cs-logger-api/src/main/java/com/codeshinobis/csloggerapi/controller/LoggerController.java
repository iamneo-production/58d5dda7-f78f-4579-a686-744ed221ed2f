package com.codeshinobis.csloggerapi.controller;

import com.codeshinobis.csloggerapi.model.LogDto;
import com.codeshinobis.csloggerapi.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logger")
public class LoggerController {

    @Autowired
    private LoggerService loggerService;

    @PostMapping("/log")
    public ResponseEntity<Void> logger(@RequestBody LogDto logData) {
        loggerService.log(logData);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
