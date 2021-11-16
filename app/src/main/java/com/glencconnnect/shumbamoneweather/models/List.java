/**
 * Created by glenc on Nov 2021
 **/

package com.glencconnnect.shumbamoneweather.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class List {

    @SerializedName("dt")
    private Long dt;

    @SerializedName("sunrise")
    private Long sunrise;

    @SerializedName("sunset")
    private Long sunset;

    //the temperature is an object inside the List, so it will appear in here, which in itself contains a list of items
    @SerializedName("temp")
    private ArrayList<Temp> temp;

    @SerializedName("pressure")
    private double pressure;

    @SerializedName("humidity")
    private int humidity;

    //the Weather is an object inside the List, so it will appear in here, which in itself contains a list of items
    @SerializedName("weather")
    private ArrayList<Weather> weather;

    public List(Long dt, Long sunrise, Long sunset, ArrayList<Temp> temp, double pressure, int humidity, ArrayList<Weather> weather) {
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weather = weather;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public ArrayList<Temp> getTemp() {
        return temp;
    }

    public void setTemp(ArrayList<Temp> temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }
}


