package com.example.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionVo {

	private String transactionId;
	private String accountNo;
	private double amount;
	private String operation;
	private Timestamp transactionTimestamp;
	
}
