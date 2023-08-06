package com.codeshinobis.csloggerapi.service;

public interface LoggerService {

    void logging(String message, String level, String className, String methodName);
}
