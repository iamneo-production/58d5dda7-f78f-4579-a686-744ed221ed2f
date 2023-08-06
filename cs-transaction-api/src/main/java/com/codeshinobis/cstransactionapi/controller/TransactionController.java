package com.codeshinobis.cstransactionapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeshinobis.cstransactionapi.dto.TransactionRequest;
import com.codeshinobis.cstransactionapi.dto.TransactionResponse;
import com.codeshinobis.cstransactionapi.entity.Transaction;
import com.codeshinobis.cstransactionapi.service.TransactionService;


@RestController
@RequestMapping("/api/exchange-transactions")
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
