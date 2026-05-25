package com.goteborgaren.app.data.repository

import com.goteborgaren.app.data.model.DayWeather
import kotlinx.coroutines.delay
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor() {

    // Mock-data baserad på typiskt Göteborgsväder
    private val weatherPhrases = listOf(
        "🌦️", "☁️", "🌧️", "⛅", "🌤️", "🌫️", "🌬️"
    )

    suspend fun getForecast(): List<DayWeather> {
        delay(400)
        val today = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("E d MMM")

        return List(7) { offset ->
            val date = today.plusDays(offset.toLong())
            val temp = (8..20).random() + (offset % 3) * 2
            DayWeather(
                date = date.format(formatter),
                temp = temp.toDouble(),
                feelsLike = (temp - 2 - (0..3).random()).toDouble(),
                windSpeed = (2..12).random().toDouble(),
                windDirection = listOf(0, 45, 90, 135, 180, 225, 270, 315).random(),
                humidity = (55..95).random(),
                pressure = (990..1035).random().toDouble(),
                cloudiness = (20..100).random(),
                symbol = weatherPhrases[(offset + temp) % weatherPhrases.size]
            )
        }
    }
}
