package net.engineeringdigest.journalApp1.repository;

import net.engineeringdigest.journalApp1.entity.JournalEntry;
import net.engineeringdigest.journalApp1.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String username);
    void deleteByUserName(String username);
}


