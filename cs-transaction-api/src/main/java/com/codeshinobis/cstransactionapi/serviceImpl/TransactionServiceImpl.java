package com.codeshinobis.cstransactionapi.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codeshinobis.cstransactionapi.dto.TransactionRequest;
import com.codeshinobis.cstransactionapi.dto.TransactionResponse;
import com.codeshinobis.cstransactionapi.entity.Transaction;
import com.codeshinobis.cstransactionapi.repository.TransactionRepository;
import com.codeshinobis.cstransactionapi.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionRepository transactionRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	final Logger logger= LoggerFactory.getLogger(TransactionService.class);



	@Override
	public ResponseEntity<List<Transaction>> getAllTransaction() {
		try {
			logger.info("all transction");
			return new ResponseEntity<List<Transaction>>((List<Transaction>) this.transactionRepo.findAll(), HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return new ResponseEntity<List<Transaction>>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
		
			
	}

	@Override
	public ResponseEntity<List<Transaction>> getAllTransactionByUserId(String userId) {
		
		try {
			
			logger.info("transaction by userid");
			System.out.println(this.transactionRepo.getByUserId(userId));
			if(this.transactionRepo.getByUserId(userId).size() > 0) return new ResponseEntity<List<Transaction>>(this.transactionRepo.getAllByUserId(userId), HttpStatus.OK);
			return new ResponseEntity<List<Transaction>>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
			//throw new Exception("something");
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return new ResponseEntity<List<Transaction>>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		
	}

}