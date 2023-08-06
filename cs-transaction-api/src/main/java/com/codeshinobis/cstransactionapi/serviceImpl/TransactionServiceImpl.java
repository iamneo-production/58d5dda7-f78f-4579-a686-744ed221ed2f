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

import com.codeshinobis.cstransactionapi.custom.TransactionNotFoundException;
import com.codeshinobis.cstransactionapi.dto.TransactionRequest;
import com.codeshinobis.cstransactionapi.dto.TransactionResponse;
import com.codeshinobis.cstransactionapi.entity.Transaction;
import com.codeshinobis.cstransactionapi.repository.TransactionRepository;
import com.codeshinobis.cstransactionapi.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionRepository transactionRepo;
	
	final Logger logger= LoggerFactory.getLogger(TransactionService.class);


	@Override
	public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
		if( transactionRequest==null) throw new IllegalArgumentException();
		Transaction transaction=mapTransaction(transactionRequest);
		logger.info("transaction is :"+transaction);
		
		String ldt=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		transaction.setTransactionDateTime(ldt);
		logger.info("time added to transaction : "+ transaction);
		
		Transaction response=transactionRepo.save(transaction);
		logger.info("save transaction : "+ response);
		return mapTransactionResponse(response);
	}

	@Override
	public Transaction getSingleTransaction(Long transactionId) {
		Optional<Transaction> res=transactionRepo.findById(transactionId);
		if(res.isPresent()) return res.get();
//		else throw new TransactionNotFoundException();
		else return null;
		
	}

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
	public List<Transaction> getAllTransactionByUserId(String userId) {
		
		try {
			logger.info("transaction by userid");
			System.out.println(this.transactionRepo.getByUserID(userId));
			if(this.transactionRepo.getByUserID(userId).size() > 0) return this.transactionRepo.getAllByUserID(userId);
			return null;			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return null;
	}

	private Transaction mapTransaction(TransactionRequest request) {
		Transaction transaction = new Transaction();
		transaction.setConvertedAmount(request.getConvertedAmount());
		transaction.setRequestAmount(request.getRequestAmount());
		transaction.setSourceCurrency(request.getSourceCurrency());
		transaction.setTargetCurrency(request.getTargetCurrency());
		transaction.setExchangeRate(request.getExchangeRate());
		transaction.setUserID(request.getUserID());
		return transaction;
	}

	private TransactionResponse mapTransactionResponse(Transaction transaction) {
		TransactionResponse response = new TransactionResponse();
		response.setConvertedAmount(transaction.getConvertedAmount());
		response.setRequestAmount(transaction.getRequestAmount());
		response.setSourceCurrency(transaction.getSourceCurrency());
		response.setTargetCurrency(transaction.getTargetCurrency());
		response.setExchangeRate(transaction.getExchangeRate());
		response.setUserID(transaction.getUserID());
		response.setTransactionID(transaction.getTransactionID());
		response.setTransactionDateTime(new Date());
		return response;
	}

}