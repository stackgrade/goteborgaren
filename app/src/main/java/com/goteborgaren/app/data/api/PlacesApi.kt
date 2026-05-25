package com.goteborgaren.app.data.api

import com.goteborgaren.app.data.api.PlaceType.Companion.toApiUrl
import com.goteborgaren.app.data.model.Place
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

enum class PlaceType(val query: String, val svLabel: String) {
    LANDMARK("tourism=attraction", "Sevärdheter"),
    MUSEUM("tourism=museum", "Museer"),
    PARK("leisure=park", "Parker"),
    CAFE("amenity=cafe", "Caféer"),
    RESTAURANT("amenity=restaurant", "Restauranger"),
    VIEWPOINT("tourism=viewpoint", "Utsiktsplatser");

    companion object {
        fun PlaceType.toApiUrl(lat: Double, lon: Double, radius: Int = 5000): String {
            return "https://overpass-api.de/api/interpreter?" +
                    "data=[out:json];(node[$query](around:$radius,$lat,$lon);" +
                    "way[$query](around:$radius,$lat,$lon););out center;"
        }
    }
}

class OverpassApi {
    suspend fun getPlaces(
        lat: Double,
        lon: Double,
        type: PlaceType,
        radius: Int = 5000
    ): List<Place> {
        val url = URL(type.toApiUrl(lat, lon, radius))
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "GET"
        conn.connectTimeout = 10000
        conn.readTimeout = 10000

        val response = conn.inputStream.bufferedReader().readText()
        val json = JSONObject(response)
        val elements = json.getJSONArray("elements")

        val places = mutableListOf<Place>()
        for (i in 0 until elements.length()) {
            val el = elements.getJSONObject(i)
            val tags = el.optJSONObject("tags") ?: continue
            val name = tags.optString("name", "")
            if (name.isBlank()) continue

            val lat2 = el.optDouble("lat", el.optDouble("center/lat", lat))
            val lon2 = el.optDouble("lon", el.optDouble("center/lon", lon))

            places.add(
                Place(
                    name = name,
                    description = tags.optString("description", tags.optString("wikipedia", "")),
                    category = type.svLabel,
                    latitude = lat2,
                    longitude = lon2
                )
            )
        }
        return places
    }
}
