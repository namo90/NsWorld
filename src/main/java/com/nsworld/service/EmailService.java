package com.nsworld.service;

public interface EmailService {
    public void sendSimpleEmail(String toEmail, String subject, String body);
     void sendRegistrationEmails(String userEmail, String userName);
     public String sendEmailoAllStudents();
}
