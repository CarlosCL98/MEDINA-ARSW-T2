package edu.eci.arsw.weather.controller;

import edu.eci.arsw.weather.services.WeatherServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Medina
 */
@RestController
@RequestMapping(value = "/ciudades")
public class WeatherController {
    
    @Autowired
    private WeatherServices weatherServices;
    
    @RequestMapping(value = "/{nombre}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorRecursoGetCiudad(@PathVariable String nombre) {
        try {
            return new ResponseEntity<>(weatherServices.getCiudadByName(nombre), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
}
