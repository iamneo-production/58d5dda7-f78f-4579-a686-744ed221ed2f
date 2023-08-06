package com.codeshinobis.cstransactionapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeshinobis.cstransactionapi.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	
	public List<Transaction> getByUserId(String userId);

	@Query(value = "SELECT * FROM transaction WHERE user_id=?", nativeQuery = true)
	public List<Transaction> getAllByUserId(String userId);
	
	public boolean findByUserId(String userId);

}
