package com.goteborgaren.app.data.repository

import com.goteborgaren.app.data.model.DepartureDisplay
import kotlinx.coroutines.delay
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DepartureRepository @Inject constructor() {

    // Mock-data för Västtrafik-avgångar
    private val mockStops = mapOf(
        "brunnsparken" to "Brunnsparken",
        "centralen" to "Göteborg Central",
        "korsvägen" to "Korsvägen",
        "johanneberg" to "Chalmers/Johanneberg",
        "lindholmen" to "Lindholmen",
    )

    suspend fun getDepartures(stopId: String = "centralen"): List<DepartureDisplay> {
        delay(500) // Simulera nätverk
        val now = LocalTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm")

        val lines = listOf(
            "4", "5", "6", "7", "10", "13",
            "16", "18", "19", "25", "52", "55",
            "X1", "X3", "X4"
        )
        val directions = listOf(
            "Angered", "Frölunda", "Kungssten", "Mölndal",
            "Saltholmen", "Länsmansgården", "Bergsjön",
            "Gamlestaden", "Backa", "Högsbo", "Brämaregården",
            "Tynnered", "Östra Sjukhuset", "Chalmers"
        )

        return List(10) { index ->
            val depTime = now.plusMinutes((1 + index * 2 + (0..3).random()).toLong())
            DepartureDisplay(
                line = lines.random(),
                direction = directions.random(),
                time = depTime.format(formatter),
                stopPoint = mockStops[stopId] ?: "Göteborg",
                minutesLeft = 1 + index * 2 + (0..2).random()
            )
        }.sortedBy { it.minutesLeft }
    }
}
