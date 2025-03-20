package com.example.kafkaconsumerapp.consumer;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

import com.example.vo.AccountTransactionVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaConsumer {

	// @RetryableTopic is used for Dead Letter Topics or Dead Letter Queue
	@RetryableTopic(attempts = "3")
	@KafkaListener(topics = "transactions", groupId = "transactions_group")
	public void subscribeTransactionMessage(AccountTransactionVo transactionVo) {
		log.info("Received: {}", transactionVo);
		if (transactionVo.getAmount() > 0) {
			log.info("Account Transaction Subscribed :: {}",transactionVo);
		} else {
			throw new org.springframework.kafka.KafkaException("Transaction amount is not valid!!");
		}
	}

	@DltHandler
	public void handleDLT(AccountTransactionVo transactionVo) {
		log.info("DLT : {}",transactionVo);
	}

}
