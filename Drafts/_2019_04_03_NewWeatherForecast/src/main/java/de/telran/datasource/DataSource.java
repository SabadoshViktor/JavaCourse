package de.telran.datasource;

import de.telran.model.Forecast;
import de.telran.model.SearchResult;

public interface DataSource {
    SearchResult findCityByName(String cityName);
    Forecast getForecast(String woeid);
}
