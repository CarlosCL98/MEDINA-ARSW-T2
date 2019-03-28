package edu.eci.arsw.weather.services;

import edu.eci.arsw.weather.modelo.Ciudad;

/**
 *
 * @author Carlos Medina
 */
public interface WeatherServices {
    
    public Ciudad getCiudadByName(String nombre);
    
}
