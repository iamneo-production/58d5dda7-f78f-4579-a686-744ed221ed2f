package com.codeshinobis.csloggerapi.model;

import lombok.Data;

@Data
public class LogDto {

    private String serviceID;
    private String level;
    private String className;
    private String message;

}
