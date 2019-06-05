package de.telran.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class GetingWoeid {

    String woeid;

    public GetingWoeid() { }

    public String getWoeid() {
        return woeid;
    }

    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }

    @Override
    public String toString() {
        return "GetingWoeid{" +
                "woeid='" + woeid + '\'' +
                '}';
    }
}
