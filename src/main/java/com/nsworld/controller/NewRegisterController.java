package com.nsworld.controller;

import com.nsworld.entity.NewRegister;
import com.nsworld.repository.NewRegisterRepository;
import com.nsworld.service.EmailService;
import com.nsworld.service.NewRegisterService;
import com.nsworld.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class NewRegisterController {

    @Autowired
    NewRegisterService newRegisterService;
    @Autowired
    EmailService emailService;
    @Autowired
    TwilioService twilioService;
    @PostMapping("/new")
    public ResponseEntity<String> createNewRegister(@RequestBody NewRegister newRegister) {
        NewRegister savedRegister = newRegisterService.registerStudent(newRegister);
        if (savedRegister != null) {
            // Send emails to both user and admin

            emailService.sendRegistrationEmails(newRegister.getEmail(), newRegister.getName());
        //    twilioService.sendSms("+919326378171", "hello,5000 amount deducated from ur Gramin Bank");
            // Return success response with 201 Created
            return new ResponseEntity<>("User registered successfully, email sent to both user and admin.", HttpStatus.CREATED);
        }

        // Return an error response if registration failed
        return new ResponseEntity<>("Registration failed.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/regstudentlist")

    public List<NewRegister> getAllRegistersWithCourses() {
        return newRegisterService.getAllStudentDetails();
    }
    @GetMapping("/searchuser/{userName}")
    public ResponseEntity <List<NewRegister>> searchUser(@PathVariable String userName){
        List<NewRegister> users = newRegisterService.serachUser(userName);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}

