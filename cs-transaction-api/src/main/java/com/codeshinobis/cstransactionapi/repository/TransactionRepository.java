package com.codeshinobis.cstransactionapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeshinobis.cstransactionapi.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	
	public List<Transaction> getByUserID(String userId);

	@Query(value = "SELECT * FROM exchange_transactions WHERE user_id=?", nativeQuery = true)
	public List<Transaction> getAllByUserID(String userId);
	
	public boolean findByUserID(String userId);

}
