package com.ilearn.notification_service.consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ilearn.notification_service.model.AccountCreatedEvent;
import com.ilearn.notification_service.service.SmsService;

@Component
public class NotificationConsumer {

	@Autowired
    private SmsService smsService;
	
	@KafkaListener(topics = "account-created-topic", groupId = "notification-group")
	public void consume(AccountCreatedEvent event) {
		
		smsService.sendSms(
                event.getMobileNumber(),
                "Dear " + event.getFirstName()
                        + ", your account has been created successfully."
        );

        System.out.println("SMS Sent Successfully");
		System.out.println("Received Event : " + event);
		System.out.println("Sending SMS to " + event.getMobileNumber());
	}

}
