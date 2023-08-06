package com.codeshinobis.csloggerapi.service.impl;

import com.codeshinobis.csloggerapi.service.LoggerService;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class LoggerServiceImpl implements LoggerService {

    Logger logger = Logger.getLogger("LoggerService");

    @Override
    public void logging(String message, String level, String className, String methodName) {
        if(level.equalsIgnoreCase("error")) {
            level = "SEVERE";
        }
        logger.logp(Level.parse(level), className, methodName, message);
    }
}
