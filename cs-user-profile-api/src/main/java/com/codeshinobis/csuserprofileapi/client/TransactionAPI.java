package com.codeshinobis.csuserprofileapi.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codeshinobis.csuserprofileapi.model.UserTransaction;

@FeignClient(value = "transaction-api", url="lb://cs-transaction-api")
public interface TransactionAPI {

    @GetMapping("/api/cs/exchange-transactions/transactions/{userId}")
    ResponseEntity<List<UserTransaction>> getUserTransactions(@PathVariable String userId);
    
}
