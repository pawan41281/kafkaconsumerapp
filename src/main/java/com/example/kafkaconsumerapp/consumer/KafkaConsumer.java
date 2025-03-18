package com.example.kafkaconsumerapp.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "my-topic", groupId = "consumergroup1")
	public void consumeMessage(String message) {
		System.out.println("consumer1|subscribed message|" + message);
	}
	
}
