package de.telran.datasource;

import de.telran.model.Forecast;
import de.telran.model.SearchResult;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HttpDataSourceTest {
    DataSource dataSource;
    @Before
    public void setUp(){
        dataSource = new HttpDataSource();
    }

    @Test
    public void testFindCityByName(){
        SearchResult berlin = dataSource.findCityByName("Berlin");
        assertNotNull("search result ", berlin);
        assertEquals("Berlin", berlin.getTitle());
        assertEquals("638242", berlin.getWoeid());
    }
    @Test
    public void testGetForecast(){
        Forecast forecast = dataSource.getForecast("638242");
        assertNotNull("consolidated weather" , forecast.getConsolidatedWeather());
        System.out.println(forecast);

    }
}
