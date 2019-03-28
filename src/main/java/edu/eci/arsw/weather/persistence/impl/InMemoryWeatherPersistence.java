package edu.eci.arsw.weather.persistence.impl;

import edu.eci.arsw.weather.connection.HttpConnection;
import edu.eci.arsw.weather.modelo.Ciudad;
import edu.eci.arsw.weather.persistence.WeatherPersistence;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Medina
 */
@Service
public class InMemoryWeatherPersistence implements WeatherPersistence {
    
    @Autowired
    private HttpConnection httpConnection;
    
    private Map<String, Ciudad> ciudades = new HashMap<>();

    @Override
    public Ciudad getCiudadByName(String nombre) {
        Ciudad ciudad = new Ciudad();
        if (ciudades.containsKey(nombre)) {
            ciudad = ciudades.get(nombre);
        } else {
            try {
                ciudad = httpConnection.getResponse(nombre);
                ciudades.put(nombre, ciudad);
            } catch (IOException ex) {
                Logger.getLogger(InMemoryWeatherPersistence.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ciudad;
    }
    
}
