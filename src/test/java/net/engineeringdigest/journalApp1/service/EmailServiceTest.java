package net.engineeringdigest.journalApp1.service;

import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {
    @Autowired
    EmailService emailService;

    @Disabled
    void testSendMail(){
        emailService.sendEmail("abc@gmail.com",
                "Test",
                "How are you");
    }
}
