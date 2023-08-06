package com.codeshinobis.cstransactionapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="exchange_transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transaction_id")
	long transactionID;
	String sourceCurrency;
	String targetCurrency;
	double requestAmount;
	double convertedAmount;
	double exchangeRate;
	String transactionDateTime;
	@Column(name="user_id")
	String userID;

}
