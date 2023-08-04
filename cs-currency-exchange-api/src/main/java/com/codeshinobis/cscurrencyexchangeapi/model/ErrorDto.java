package com.codeshinobis.cscurrencyexchangeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorDto {

    private String code;
    private String message;
    
}
