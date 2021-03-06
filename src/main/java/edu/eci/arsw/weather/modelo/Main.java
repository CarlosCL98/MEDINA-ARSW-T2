package edu.eci.arsw.weather.modelo;

/**
 * ESta clase representa las caracteristicas principales del clima de una ciudad
 *
 * @author Carlos Medina
 */
public class Main {

    private double temp;
    private int humidity;
    private int pressure;
    private double temp_min;
    private double temp_max;

    public Main() {
    }
    
    public Main(double temp, int humidity, int pressure, double temp_min, double temp_max) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

}
