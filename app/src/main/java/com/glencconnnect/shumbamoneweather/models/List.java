/**
 * Created by glenc on Nov 2021
 **/

package com.glencconnnect.shumbamoneweather.models;

public class List {
    "dt":1568977200,
            "sunrise":1568958164,
            "sunset":1569002733,
            "temp":{
        "day":293.79,
                "min":288.85,
                "max":294.47,
                "night":288.85,
                "eve":290.44,
                "morn":293.79
    },

    private Long dt;
    private Long sunrise;
    private Long sunset;

    //the temperature is an object inside the List, so it will appear in here
    private Temp temp;




}


