package com.nsworld.service;

public interface TwilioService {
    public void init();
    public String sendSms(String to, String message);
}
