/**
 * Created by glenc on Nov 2021
 **/

package com.glencconnnect.shumbamoneweather.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OuterContainer {

//    @SerializedName("cod")
//    private String cod;
//
//    @SerializedName("message")
//    private String message;
//
//    @SerializedName("cnt")
//    private String cnt;
//
//    //the city is an object inside the List, so it will appear in here
//    @SerializedName("city")
//    private City city;

    @SerializedName("list")
    private ArrayList<List> list;

    public OuterContainer(ArrayList<List> list) {
        this.list = list;
    }

    public ArrayList<List> getList() {
        return list;
    }

    public void setList(ArrayList<List> list) {
        this.list = list;
    }
}