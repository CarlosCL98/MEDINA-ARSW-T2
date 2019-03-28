package edu.eci.arsw.weather.modelo;

import java.util.List;

/**
 *
 * @author Carlos Medina
 */
public class Ciudad {
    
    private String name;
    private int dt;
    private int id;
    private int cod;
    private Main main;
    private List<Weather> weathers;
    private Coordenadas coord;
    private Sys sys;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;

    public Ciudad() {
    }

    public Ciudad(String name, int dt, int id, int cod, Main main, List<Weather> weathers, Coordenadas coord, Sys sys, Wind wind, Rain rain, Clouds clouds) {
        this.name = name;
        this.dt = dt;
        this.id = id;
        this.cod = cod;
        this.main = main;
        this.weathers = weathers;
        this.coord = coord;
        this.sys = sys;
        this.wind = wind;
        this.rain = rain;
        this.clouds = clouds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public Coordenadas getCoord() {
        return coord;
    }

    public void setCoord(Coordenadas coord) {
        this.coord = coord;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }
        
}
