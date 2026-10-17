package net.engineeringdigest.journalApp1.repository;

import net.engineeringdigest.journalApp1.entity.ConfigJournalAppApiEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppApiRepository extends MongoRepository<ConfigJournalAppApiEntity, ObjectId> {
}
