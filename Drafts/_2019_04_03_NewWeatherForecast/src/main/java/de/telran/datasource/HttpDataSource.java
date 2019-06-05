package de.telran.datasource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import de.telran.model.Forecast;
import de.telran.model.SearchResult;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class HttpDataSource implements DataSource {

    private static String WEATHER_SERVER = "https://www.metaweather.com";
    private static String SEARCH_PATH = "/api/location/";
    private static String SEARCH_QUERY = "search?query=";



    RestTemplate rest;

    public HttpDataSource() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        rest = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList();
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonMessageConverter.setObjectMapper(mapper);
        messageConverters.add(jsonMessageConverter);
        rest.setMessageConverters(messageConverters);
    }

    @Override
    public SearchResult findCityByName(String cityName) {
        String url = WEATHER_SERVER + SEARCH_PATH + SEARCH_QUERY + cityName;
        ResponseEntity<SearchResult[]> exchange = rest.exchange(url, HttpMethod.GET, null, SearchResult[].class);
        SearchResult[] searchResults = exchange.getBody();
        return searchResults[0];
    }

    @Override
    public Forecast getForecast(String woeid) {
        String url = WEATHER_SERVER + SEARCH_PATH + woeid;
        ResponseEntity<Forecast> exchange = rest.exchange(url, HttpMethod.GET, null, Forecast.class);
        return exchange.getBody();
    }


}
