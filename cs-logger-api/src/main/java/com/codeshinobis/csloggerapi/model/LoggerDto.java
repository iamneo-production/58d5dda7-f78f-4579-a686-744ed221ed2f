package com.codeshinobis.csloggerapi.model;

import lombok.Data;

@Data
public class LoggerDto {

    private String message;

    private String level;

    private String className;

    private String methodName;
}
