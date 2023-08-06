package com.codeshinobis.csuserprofileapi.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codeshinobis.csuserprofileapi.model.ResponseDto;
import com.codeshinobis.csuserprofileapi.model.UserTransaction;

@Component
@FeignClient(name = "cs-api-gateway")
public interface TransactionAPI {

    @GetMapping("/api/cs/exchange-transactions/transactions/{userId}")
    ResponseDto<List<UserTransaction>> getUserTransactions(@PathVariable String userId);
    
}
