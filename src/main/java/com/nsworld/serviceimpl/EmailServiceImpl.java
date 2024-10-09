package com.nsworld.serviceimpl;

import com.nsworld.constant.TwilioSMSSendConstant;
import com.nsworld.entity.NewRegister;
import com.nsworld.repository.NewRegisterRepository;
import com.nsworld.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    NewRegisterRepository newRegisterRepository;

    @Override
    public void sendSimpleEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("namo.shelke92@gmail.com");  // Sender email
        message.setTo(toEmail);  // Receiver email
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);
        System.out.println("email sended successfully...");

    }

    @Override
    public void sendRegistrationEmails(String userEmail, String userName) {
        // Email to registered user
       // String userSubject = "Welcome to NSWorld platform!";
       // String userBody = "Dear " + userName + ",\n\nThank you for registering with us.
        // we have 10 years experty to teach you\n\nBest regards,\nNSWorld Pvt.Ltd";
        sendSimpleEmail(userEmail, TwilioSMSSendConstant.USER_SUBJECT, TwilioSMSSendConstant.USER_BODY+userName+TwilioSMSSendConstant.USER_BODY_MSG);
    }

    @Override
    @Scheduled(cron = "0 */10 * * * ?") // Runs every 10 minutes
    public String sendEmailoAllStudents() {
        List<NewRegister> allStudents = newRegisterRepository.findAll();

        for (NewRegister user : allStudents) {
            // Check if email and name are not null
            if (user.getEmail() != null && user.getName() != null) {
                sendSimpleEmail(
                        user.getEmail(),
                        TwilioSMSSendConstant.USER_SUBJECT,
                        TwilioSMSSendConstant.USER_BODY + user.getName() + TwilioSMSSendConstant.USER_BODY_MSG
                );
            } else {
                // Log or handle the case where email or name is null
                System.out.println("Email or name is missing for user: " + user.getId());
            }
        }
        return "Emails sent successfully!";
    }
}
