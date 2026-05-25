package com.goteborgaren.app.data.model

// 🚋 Västtrafik — Avgångar
data class DepartureResponse(
    val departureTime: String,
    val line: String,
    val direction: String,
    val stopPointName: String
)

// 🌤️ SMHI — Väder
data class WeatherResponse(
    val timeSeries: List<WeatherTimePoint>
)

data class WeatherTimePoint(
    val validTime: String,
    val parameters: List<WeatherParameter>
)

data class WeatherParameter(
    val name: String,
    val values: List<Double>
)

// Representerar ett väder för en dag
data class DayWeather(
    val date: String,
    val temp: Double,
    val feelsLike: Double,
    val windSpeed: Double,
    val windDirection: Int,
    val humidity: Int,
    val pressure: Double,
    val cloudiness: Int,
    val symbol: String
)

// Vald väderparameter
enum class WeatherParam(val key: String) {
    TEMPERATURE("t"),
    FEELS_LIKE("t"),
    WIND_SPEED("ws"),
    WIND_DIRECTION("wd"),
    HUMIDITY("r"),
    PRESSURE("msl"),
    CLOUDINESS("tcc_mean")
}

// 📍 Platser
data class Place(
    val name: String,
    val description: String,
    val category: String,
    val latitude: Double,
    val longitude: Double,
    val imageUrl: String = ""
)

data class DepartureDisplay(
    val line: String,
    val direction: String,
    val time: String,          // HH:mm
    val stopPoint: String,
    val minutesLeft: Int
)
