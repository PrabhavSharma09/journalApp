package net.engineeringdigest.journalApp1.service;

import net.engineeringdigest.journalApp1.repository.UserRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserRepositoryImplTest {
    @Autowired
    UserRepositoryImpl userRepositoryImpl;

    @Disabled
    @Test
    public void testSaveNewUser() {
        Assertions.assertNotNull(userRepositoryImpl.getUserForSA());
    }
}
