package com.stockx.service.representation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Shoe {
    private String display;
    private String key;
    @JsonProperty("true_to_size_score")
    private String trueToSizeScore;

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTrueToSizeScore() {
        return trueToSizeScore;
    }

    public void setTrueToSizeScore(String trueToSizeScore) {
        this.trueToSizeScore = trueToSizeScore;
    }
}
