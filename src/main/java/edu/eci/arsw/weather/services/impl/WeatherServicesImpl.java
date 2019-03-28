package edu.eci.arsw.weather.services.impl;

import edu.eci.arsw.weather.modelo.Ciudad;
import edu.eci.arsw.weather.persistence.WeatherPersistence;

import edu.eci.arsw.weather.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Medina
 */
@Service
public class WeatherServicesImpl implements WeatherServices {
    
    @Autowired
    private WeatherPersistence weatherPersistence;

    @Override
    public String getCiudadByName(String nombre) {
        return weatherPersistence.getCiudadByName(nombre);
    }
    
}
