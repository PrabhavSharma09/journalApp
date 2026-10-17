package net.engineeringdigest.journalApp1.cache;

import jakarta.annotation.PostConstruct;
import net.engineeringdigest.journalApp1.entity.ConfigJournalAppApiEntity;
import net.engineeringdigest.journalApp1.repository.ConfigJournalAppApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {
    @Autowired
    private ConfigJournalAppApiRepository configJournalAppApiRepository;

    public Map<String , String> APP_CACHE;

    @PostConstruct
    public void init(){
        APP_CACHE = new HashMap<>();
        List<ConfigJournalAppApiEntity> all = configJournalAppApiRepository.findAll();
        for(ConfigJournalAppApiEntity configJournalAppApiEntity : all){
            APP_CACHE.put(configJournalAppApiEntity.getKey(), configJournalAppApiEntity.getValue());
        }
    }
}
