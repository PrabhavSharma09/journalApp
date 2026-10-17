package net.engineeringdigest.journalApp1.service;
import net.engineeringdigest.journalApp1.entity.User;
import net.engineeringdigest.journalApp1.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean saveNewEntry(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error("hahaha");
            log.warn("hahaha");
            log.info("hahaha");
            log.debug("hahaha");
            log.trace("hahaha");
            return false;
        }
    }

    public void saveEntry(User user) {
        userRepository.save(user);
    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

//    public Optional<User> findById(ObjectId id) {
//        return UserRepository.findById(id);
//    }
//
//    public void deleteById(ObjectId id){
//        UserRepository.deleteById(id);
//    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}


