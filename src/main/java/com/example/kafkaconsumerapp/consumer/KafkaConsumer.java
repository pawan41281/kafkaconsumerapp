package com.example.kafkaconsumerapp.consumer;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

import com.example.vo.TransactionVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaConsumer {

	// @RetryableTopic is used for Dead Letter Topics or Dead Letter Queue
	@RetryableTopic(attempts = "3", backoff = @Backoff(delay = 2000, multiplier = 2))
	@KafkaListener(topics = "transactions", groupId = "transactions_group")
	public void subscribeTransactionMessage(TransactionVo transactionVo) {
		log.info("Received: {}", transactionVo);
		if (transactionVo.getAmount() > 0) {
			System.out.println("consumer1|subscribe Transaction Message|" + transactionVo);
		} else {
			throw new RuntimeException("Transaction amount is not valid!!");
		}
	}

	@DltHandler
	public void handleDLT(TransactionVo transactionVo) {
		log.info("DLT : {}",transactionVo);
	}

}
