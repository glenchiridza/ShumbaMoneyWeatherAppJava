/**
 * Created by glenc on Nov 2021
 **/
package com.glencconnnect.shumbamoneweather.retrofit;

import com.glencconnnect.shumbamoneweather.models.OuterContainer;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.glencconnnect.shumbamoneweather.constants.ApiConstants.API_KEY;

public interface RetrieveWeather {

    @GET("/data/2.5/forecast?q=Harare&&units=metric&cnt=16&appid="+ API_KEY)
    Call<OuterContainer> getData();
}
