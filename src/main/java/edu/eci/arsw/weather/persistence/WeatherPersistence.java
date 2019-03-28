package edu.eci.arsw.weather.persistence;

import edu.eci.arsw.weather.modelo.Ciudad;

/**
 *
 * @author Carlos Medina
 */
public interface WeatherPersistence {
    
    public Ciudad getCiudadByName(String nombre);
}
