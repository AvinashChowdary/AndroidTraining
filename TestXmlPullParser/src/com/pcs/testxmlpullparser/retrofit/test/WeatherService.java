package com.pcs.testxmlpullparser.retrofit.test;

import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

public interface WeatherService {
    @GET("/weather")
    Response getWeather(@Query("q") String city, @Query("mode") String mode);
}
