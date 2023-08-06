package com.codeshinobis.cstransactionapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeshinobis.cstransactionapi.entity.Transaction;
import com.codeshinobis.cstransactionapi.service.TransactionService;


@RestController
@RequestMapping("/api/cs/exchange-transactions")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	


	@GetMapping("/transactions/{userId}")
	public ResponseEntity<List<Transaction>>  getAllTransactionByUserId(@PathVariable String userId) {
		return this.transactionService.getAllTransactionByUserId(userId);
	}

	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getAllTransactions(){
		return this.transactionService.getAllTransaction();
	}

}
