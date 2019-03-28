package edu.eci.arsw.weather.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;

@Service
public class HttpConnection {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String API_KEY = "334f7a1f347cd5f9fd8eb539637f2ad4";
    private String get_url;    

    public HttpConnection() {
        get_url = "";
    }    

    public String getResponse(String nombre) throws IOException {
        
        get_url = "http://api.openweathermap.org/data/2.5/weather?q="+nombre+"&appid=334f7a1f347cd5f9fd8eb539637f2ad4";
        
        URL obj = new URL(get_url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        String responseContent = "";
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            responseContent = response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return responseContent;
    }

}
