package com.codeshinobis.cstransactionapi.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
		
		
		
		if( transactionRequest==null) throw new IllegalArgumentException();
//		Transaction transaction =Transaction.builder()
//				.id()
		Transaction transaction=modelMapper.map(transactionRequest, Transaction.class);
		logger.info("transaction is :"+transaction);
		
		String ldt=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		transaction.setTransactionDateTime(ldt);
		logger.info("time added to transaction : "+ transaction);
		
		Transaction response=transactionRepo.save(transaction);
		logger.info("save transaction : "+ response);
		return  new TransactionResponse("success",response,null);
		
		
	}

	@Override
	public Transaction getSingleTransaction(Long transactionId) {
		Optional<Transaction> res=transactionRepo.findById(transactionId);
		if(res.isPresent()) return res.get();
//		else throw new TransactionNotFoundException();
		else return null;
		
	}


}
