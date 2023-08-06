package com.codeshinobis.cstransactionapi.controller;

import com.codeshinobis.cstransactionapi.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codeshinobis.cstransactionapi.dto.TransactionRequest;
import com.codeshinobis.cstransactionapi.dto.TransactionResponse;
import com.codeshinobis.cstransactionapi.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/cs/exchange-transactions")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/transaction")
	public ResponseEntity<TransactionResponse> saveTransaction(@RequestBody TransactionRequest transactionRequest) {
		System.out.println(transactionRequest);
		TransactionResponse res= transactionService.createTransaction(transactionRequest);
        return new ResponseEntity<TransactionResponse>(res, HttpStatus.OK);
		
	}
	@GetMapping("/transaction/{Id}")
	public ResponseEntity<Transaction> getSingleTransactionById(@PathVariable long Id) {
		return new ResponseEntity<>(transactionService.getSingleTransaction(Id), HttpStatus.OK);
	}


}
