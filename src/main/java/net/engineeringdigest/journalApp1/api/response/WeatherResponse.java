package net.engineeringdigest.journalApp1.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private Main main;

    public String name;
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Main {

        @JsonProperty("feels_like")
        private double feelsLike;
    }

}
