import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import de.telran.model.GetingWoeid;
import de.telran.model.SearchResult;
import de.telran.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(Main.class.getResourceAsStream("user.json"), User.class);

        URL url = new URL("https://www.metaweather.com/api/location/search/?query=berlin");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();
        System.out.println(urlConnection.getResponseCode() + " " + urlConnection.getResponseMessage());

        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        getWOEID(urlConnection, mapper);

        searchResult(urlConnection, mapper);
    }
/*    public static double getTemperature(String city){

        return 1222.44;

    }*/

    public static SearchResult [] searchResult (HttpURLConnection urlConnection, ObjectMapper mapper) throws IOException {
        SearchResult [] searchResult = new SearchResult[1];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            Optional<String> reduce = reader.lines().reduce((a, b) -> a + b);
            if (reduce.isPresent()) {
                System.out.println(reduce.get());
                searchResult = mapper.readValue(reduce.get(), SearchResult[].class);
                System.out.println(searchResult[0]);

            }
        }
        return searchResult;
    }

    public static GetingWoeid [] getWOEID (HttpURLConnection urlConnection, ObjectMapper mapper) throws IOException {
        GetingWoeid [] getingWoeid = new GetingWoeid [1] ;
        try (BufferedReader reader2 = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            Optional<String> reduce2 = reader2.lines().reduce((a, b) -> a + b);
            if (reduce2.isPresent()) {
                System.out.println(reduce2.get());
                getingWoeid = mapper.readValue(reduce2.get(), GetingWoeid[].class);
                System.out.println(getingWoeid[0]);


            }

        }
        return getingWoeid;
    }
}

//  System.out.println(user);
/*
        User user1 = new User();
        user1.setAge(33);
        user1.setFirstName("Viktor");
        user1.setLastName("Sabov");

        mapper.writeValue(new File("saved_user.json"), user1);
  */