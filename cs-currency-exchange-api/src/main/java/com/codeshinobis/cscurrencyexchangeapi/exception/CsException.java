package com.codeshinobis.cscurrencyexchangeapi.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CsException extends Exception {

    private CsErrorCodes code;

    public CsException(CsErrorCodes code) {
        this.code = code;
    }

}
