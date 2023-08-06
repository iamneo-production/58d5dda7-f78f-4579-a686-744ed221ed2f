package com.codeshinobis.cscurrencyexchangeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogDto {

    private String serviceID;
    private String level;
    private String className;
    private String message;

}
