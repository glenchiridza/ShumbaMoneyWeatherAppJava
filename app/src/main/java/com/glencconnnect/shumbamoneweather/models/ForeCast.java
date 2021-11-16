/**
 * Created by glenc on Nov 2021
 **/

package com.glencconnnect.shumbamoneweather.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ForeCast {

    @SerializedName("cod")
    private String cod;

    @SerializedName("message")
    private String message;

    @SerializedName("cnt")
    private String cnt;

    //the city is an object inside the List, so it will appear in here
    @SerializedName("city")
    private City city;

    @SerializedName("list")
    private ArrayList<List> list;

    public ForeCast(String cod, String message, String cnt, City city, ArrayList<List> list) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.city = city;
        this.list = list;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ArrayList<List> getList() {
        return list;
    }

    public void setList(ArrayList<List> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ForeCast{" +
                "cod='" + cod + '\'' +
                ", message='" + message + '\'' +
                ", cnt='" + cnt + '\'' +
                ", city=" + city +
                ", list=" + list +
                '}';
    }
}


