/**
 * Created by glenc on Nov 2021
 **/

package com.glencconnnect.shumbamoneweather.models;

import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("name")
    private  String name;

    @SerializedName("country")
    private String country;

    @SerializedName("timezone")
    private String timezone;

}


