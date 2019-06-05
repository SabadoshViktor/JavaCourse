package de.telran.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class SearchResult {


    String title;
    String lolocationType;
    String woeid;

    public SearchResult() { }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLolocationType() {
        return lolocationType;
    }

    public void setLolocationType(String lolocationType) {
        this.lolocationType = lolocationType;
    }

    public String getWoeid() {
        return woeid;
    }

    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "title='" + title + '\'' +
                ", lolocationType='" + lolocationType + '\'' +
                ", woeid='" + woeid + '\'' +
                '}';
    }
}
