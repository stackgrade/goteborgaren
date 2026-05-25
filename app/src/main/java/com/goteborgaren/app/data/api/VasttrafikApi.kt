package com.goteborgaren.app.data.api

import com.goteborgaren.app.data.model.DepartureResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface VasttrafikApi {
    @GET("api/v1/departures/{stopId}")
    suspend fun getDepartures(
        @Path("stopId") stopId: String
    ): List<DepartureResponse>
}
