package edu.eci.arsw.weather.connection;

import com.restfb.json.JsonArray;
import edu.eci.arsw.weather.modelo.Coordenadas;
        
import com.restfb.json.JsonObject;
import edu.eci.arsw.weather.modelo.Ciudad;
import edu.eci.arsw.weather.modelo.Clouds;
import edu.eci.arsw.weather.modelo.Main;
import edu.eci.arsw.weather.modelo.Rain;
import edu.eci.arsw.weather.modelo.Sys;
import edu.eci.arsw.weather.modelo.Weather;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HttpConnection {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String API_KEY = "334f7a1f347cd5f9fd8eb539637f2ad4";
    private String get_url;    

    public HttpConnection() {
        get_url = "";
    }    

    public Ciudad getResponse(String nombre) throws IOException {
        
        get_url = "http://api.openweathermap.org/data/2.5/weather?q="+nombre+"&appid=334f7a1f347cd5f9fd8eb539637f2ad4";
        
        URL obj = new URL(get_url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        String responseContent = "";
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        Ciudad data = new Ciudad();
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
            JsonObject json = new JsonObject(responseContent);
            String coord = json.get("coord").toString();
            String sys = json.get("sys").toString();
            JsonArray weather = json.getJsonArray("weather");
            String main = json.get("main").toString();
            String wind = json.get("wind").toString();
            //String rain = json.get("rain").toString();
            String clouds = json.get("clouds").toString();
            JsonObject jsonc = new JsonObject(coord);
            JsonObject jsons = new JsonObject(sys);
            JsonObject jsonm = new JsonObject(main);
            //JsonObject jsonr = new JsonObject(rain);
            JsonObject jsoncl = new JsonObject(clouds);
            data.setDt((int) json.get("dt"));
            data.setId((int) json.get("id"));
            data.setName((String) json.get("name"));
            data.setCod((int) json.get("cod"));
            data.setCoord(new Coordenadas((double) jsonc.get("lon"), (double) jsonc.get("lat")));
            data.setSys(new Sys((String) jsons.get("country"), (int) jsons.get("sunrise"), (int) jsons.get("sunset")));
            data.setMain(new Main((double) jsonm.get("temp"), (int) jsonm.get("humidity"), (int) jsonm.get("pressure"), (double) jsonm.get("temp_min"), (double) jsonm.get("temp_max")));
            //data.setRain(new Rain((int) jsonr.get("3h")));
            data.setClouds(new Clouds((int) jsoncl.get("all")));
            Weather w = new Weather();
            for (int i = 0; i < weather.length(); i++) {
                JsonObject jo = weather.getJsonObject(i);
                w.setId((int) jo.get("id"));
                w.setMain((String) jo.get("main"));
                w.setDescription((String) jo.get("description"));
                w.setIcon((String) jo.get("icon"));
                List<Weather> wh = data.getWeathers();
                wh.add(w);
                data.setWeathers(wh);
            }
            System.out.println(data);
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return data;
    }

}
