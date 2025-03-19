package com.example.kafkaconsumerapp.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.vo.TransactionVo;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "my-topic2", groupId = "consumergroup2")
	public void subscribeTransactionMessage(TransactionVo transactionVo) {
		System.out.println("consumer1|subscribe Transaction Message|" + transactionVo);
	}
	
}
