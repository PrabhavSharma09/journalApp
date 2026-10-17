package net.engineeringdigest.journalApp1.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "config_journal_app")
public class ConfigJournalAppApiEntity {
    private String Key;
    private String Value;
}
