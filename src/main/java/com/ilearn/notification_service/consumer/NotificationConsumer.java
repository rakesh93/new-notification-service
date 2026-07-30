package com.ilearn.notification_service.consumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ilearn.notification_service.model.AccountCreatedEvent;

@Component
public class NotificationConsumer {

	@KafkaListener(topics = "account-created-topic", groupId = "notification-group")
	public void consume(AccountCreatedEvent event) {
		System.out.println("Received Event : " + event);
		System.out.println("Sending SMS to " + event.getMobileNumber());
	}

}
