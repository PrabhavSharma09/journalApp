package net.engineeringdigest.journalApp1.service;

import net.engineeringdigest.journalApp1.entity.User;
import net.engineeringdigest.journalApp1.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserRepository userRepository;

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "ram",
            "shyam",
            "hari"
    })
    public void testFindByUsername(String name) {
        assertNotNull(userRepository.findByUserName(name));
    }
    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "2, 3, 5",
            "3, 4, 8"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a + b);
    }
}
