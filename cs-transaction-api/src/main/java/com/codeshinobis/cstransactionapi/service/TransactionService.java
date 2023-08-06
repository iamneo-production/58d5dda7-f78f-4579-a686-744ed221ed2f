package com.codeshinobis.cstransactionapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.codeshinobis.cstransactionapi.dto.TransactionRequest;
import com.codeshinobis.cstransactionapi.dto.TransactionResponse;
import com.codeshinobis.cstransactionapi.entity.Transaction;

public interface TransactionService {
	
	
	public ResponseEntity<List<Transaction>> getAllTransaction();
	public ResponseEntity<List<Transaction>> getAllTransactionByUserId(String userId);
	

}
