package com.goteborgaren.app.data.api

import com.goteborgaren.app.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SmhiApi {
    @GET("api/version/2/category/forecast/geopoint/1.0/point")
    suspend fun getForecast(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double
    ): WeatherResponse
}
