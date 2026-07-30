package com.ilearn.notification_service.service;

import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

    private static final String ACCOUNT_SID = "YOUR_ACCOUNT_SID";
    private static final String AUTH_TOKEN = "YOUR_AUTH_TOKEN";
    private static final String FROM_NUMBER = "+1234567890";

    public SmsService() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public void sendSms(String mobile, String message) {
        Message.creator(
                new PhoneNumber("+91" + mobile),
                new PhoneNumber(FROM_NUMBER),
                message
        ).create();
    }
}
