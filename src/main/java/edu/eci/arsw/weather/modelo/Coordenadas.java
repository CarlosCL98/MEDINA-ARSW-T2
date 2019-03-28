package edu.eci.arsw.weather.modelo;

/**
 *
 * @author Carlos Medina
 */
class Coordenadas {
    
    private double lon;
    private double lat;

    public Coordenadas() {
    }

    public Coordenadas(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
    
}
