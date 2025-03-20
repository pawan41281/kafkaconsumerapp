package com.example.vo;

import java.io.Serializable;
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
public class AccountTransactionVo implements Serializable {

	private Integer transactionId;
	private Integer accountNo;
	private Double amount;
	private String operation;
	private Timestamp transactionTimestamp;
	
}
