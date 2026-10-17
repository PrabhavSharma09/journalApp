package net.engineeringdigest.journalApp1.Scheduler;

import net.engineeringdigest.journalApp1.cache.AppCache;
import net.engineeringdigest.journalApp1.entity.JournalEntry;
import net.engineeringdigest.journalApp1.enums.Sentiment;
import net.engineeringdigest.journalApp1.repository.UserRepositoryImpl;
import net.engineeringdigest.journalApp1.service.EmailService;
import net.engineeringdigest.journalApp1.service.SentimentAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import net.engineeringdigest.journalApp1.entity.User;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserScheduler {
    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    @Autowired
    private AppCache appCache;

    //@Scheduled(cron = "0 0 9 * * SUN") // Runs every Sunday at 9 AM, --> can generate this expression from cronMaker.
    public void fetchUsersAndSendSAMail(){
        List<User> Users = userRepository.getUserForSA();
        for(User user : Users){
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<Sentiment> sentiments = journalEntries.stream().filter(x->x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x->x.getSentiment()).collect(Collectors.toList());
            Map<Sentiment, Integer> sentimentCounts = new HashMap<>();
            for (Sentiment sentiment : sentiments) {
                if (sentiment != null) {
                    sentimentCounts.put(sentiment, sentimentCounts.getOrDefault(sentiment, 0) + 1);
                }
            }
            Sentiment mostFrequentSentiment = null;
            int maxCount = 0;
            for (Map.Entry<Sentiment, Integer> entry : sentimentCounts.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    mostFrequentSentiment = entry.getKey();
                }
            }
            if (mostFrequentSentiment != null) {
                emailService.sendEmail(user.getEmail(), "Sentiment for last 7 days ", mostFrequentSentiment.toString());
            }
        }
    }

    @Scheduled(cron = "0 0/10 * ? * *") // Runs every 10 minutes
    public void clearCache(){
        appCache.init();
    }

}
