package com.example.mvcproject.service;

import com.example.mvcproject.domain.SendEmailRequest;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceClient {
    public void sendEmail(SendEmailRequest request) {
        System.out.println("Sending email to: " + request.getToAddress());
        System.out.println("Subject: " + request.getSubject());
        System.out.println("Body: " + request.getBody());
    }
}
