package com.example.mvcproject.controller;

import com.example.mvcproject.domain.SendEmailRequest;
import com.example.mvcproject.service.EmailServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/email")
public class EmailController {

    // EmailServiceClient를 주입 받음
    @Autowired
    private EmailServiceClient emailServiceClient;

    // http://localhost:8080/email/sendemail
    @RequestMapping(value = "/sendemail")
    @ResponseBody
    public String sendEmail() {
        // EmailServiceClient emailServiceClient = new EmailServiceClient();
        SendEmailRequest sendEmailRequest = generateEmailRequest();
        emailServiceClient.sendEmail(sendEmailRequest);
        return "Success";
    }

    public SendEmailRequest generateEmailRequest() {
        SendEmailRequest request = new SendEmailRequest();
        request.setToAddress("test@example.com");
        request.setSubject("Test Email");
        request.setBody("This is a test email");
        return request;
    }
}
