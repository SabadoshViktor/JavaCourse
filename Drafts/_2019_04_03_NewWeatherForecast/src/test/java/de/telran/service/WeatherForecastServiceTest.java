package de.telran.service;

import de.telran.datasource.DataSource;
import de.telran.datasource.HttpDataSource;
import de.telran.model.ConsolidatedWeather;
import de.telran.model.Forecast;
import de.telran.model.SearchResult;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class WeatherForecastServiceTest {

//    DataSource source;

    DataSource s = Mockito.mock(DataSource.class);
    private Object when;

  /*  @Before
    public void setUp(){
        source = new HttpDataSource();
    }
*/

    @Test
    public void testGetTemperature(){

        SearchResult result = new SearchResult();
        result.setTitle("berlin");
        result.setWoeid("12345");

        when(s.findCityByName("berlin")).thenReturn(result);

        Forecast forecast = new Forecast();
        ConsolidatedWeather weather = new ConsolidatedWeather();
        weather.setTheTemp(15);
        ConsolidatedWeather[] consolidatedWeather = {weather};
        forecast.setConsolidatedWeather(consolidatedWeather);
        when(s.getForecast("12345")).thenReturn(forecast);


        DataSource source = new HttpDataSource();

        WeatherForecastService service = new WeatherForecastService(s);
        double berlin = service.getTemperature("berlin");
        System.out.println(berlin);
        assertTrue("temperature", 15.0 == berlin);
    }
}
