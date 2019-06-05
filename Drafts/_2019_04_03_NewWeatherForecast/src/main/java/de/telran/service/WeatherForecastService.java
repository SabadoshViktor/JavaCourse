package de.telran.service;

import de.telran.datasource.DataSource;
import de.telran.model.Forecast;
import de.telran.model.SearchResult;

public class WeatherForecastService {
    private final DataSource source;

    public WeatherForecastService(DataSource source) {
        this.source = source;
    }

    public double getTemperature(String city){
        SearchResult cityByName = source.findCityByName(city);
        String woeid = cityByName.getWoeid();
        Forecast forecast = source.getForecast(woeid);
        return  forecast.getConsolidatedWeather()[0].getTheTemp();

    }
}
