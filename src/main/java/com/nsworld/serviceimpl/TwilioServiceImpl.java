package com.nsworld.serviceimpl;

import com.nsworld.service.TwilioService;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;

@Service
public class TwilioServiceImpl implements TwilioService {
    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;

    // Initialize Twilio with credentials
    public void init() {
        System.out.println("sid"+accountSid +"---"+"token"+authToken);
        Twilio.init(accountSid, authToken);
    }

    // Method to send SMS
    public String sendSms(String to, String message) {
        init(); // Ensure Twilio is initialized

        Message sms = Message.creator(
                new PhoneNumber(to),       // To phone number
                new PhoneNumber(fromPhoneNumber), // From Twilio phone number
                message                    // SMS body
        ).create();

        return sms.getSid();  // Returns the unique message SID for tracking
    }
}
