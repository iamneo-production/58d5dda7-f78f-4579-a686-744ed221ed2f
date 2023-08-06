package com.codeshinobis.csloggerapi.service.impl;

import com.codeshinobis.csloggerapi.model.LogDto;
import com.codeshinobis.csloggerapi.service.LoggerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoggerServiceImpl implements LoggerService {

    @Override
    public void log(LogDto logData) {
        log.atLevel(Level.valueOf(logData.getLevel()))
                .log("Service : {} | Class : {} | Message : {}",
                        logData.getServiceID(), logData.getClassName(), logData.getMessage());
    }

}
