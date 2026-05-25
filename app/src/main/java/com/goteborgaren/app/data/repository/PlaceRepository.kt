package com.goteborgaren.app.data.repository

import com.goteborgaren.app.data.model.Place
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlaceRepository @Inject constructor() {

    // Kända platser i Göteborg — kategoriserade
    private val allPlaces = listOf(
        Place("Trädgårdsföreningen", "Vacker park mitt i city", "Park", 57.7045, 11.9747, "🌳"),
        Place("Slottsskogen", "Göteborgs största park med djurpark", "Park", 57.6885, 11.9450, "🌲"),
        Place("Liseberg", "Skandinaviens största nöjespark", "Sevärdhet", 57.6951, 11.9919, "🎢"),
        Place("Universeum", "Science center med regnskog och haj", "Sevärdhet", 57.6945, 11.9890, "🔬"),
        Place("Göteborgs Konstmuseum", "Imponerande konstsamling", "Museum", 57.6979, 11.9796, "🎨"),
        Place("Sjöfartsmuseet", "Sveriges främsta sjöfartsmuseum", "Museum", 57.6992, 11.9559, "⚓"),
        Place("Världskulturmuseet", "Modernt museum med globala utställningar", "Museum", 57.6966, 11.9875, "🌍"),
        Place("Göteborgs Botaniska Trädgård", "En av Europas främsta botaniska trädgårdar", "Park", 57.6818, 11.9507, "🌺"),
        Place("Skansen Kronan", "Historiskt försvarstorn med utsikt", "Sevärdhet", 57.6981, 11.9476, "🏰"),
        Place("Feskekörka", "Berömd fiskhall vid Rosenlundskanalen", "Sevärdhet", 57.7007, 11.9577, "🐟"),
        Place("Haga", "Gamla trähus och mysiga caféer", "Sevärdhet", 57.6991, 11.9593, "🏘️"),
        Place("Avenyn", "Göteborgs huvudgata med restauranger och butiker", "Sevärdhet", 57.6956, 11.9808, "🌆"),
        Place("Göteborgs Hamn", "Skandinaviens största hamn", "Sevärdhet", 57.7089, 11.9680, "🚢"),
        Place("Poseidon", "Carl Milles staty vid Götaplatsen", "Sevärdhet", 57.6976, 11.9800, "🏛️"),
        Place("Röda Sten", "Samtida konsthall i historisk industribyggnad", "Museum", 57.6888, 11.9221, "🎭"),
        Place("Slottskogens Naturhistoriska Museum", "Museum med naturhistoriska samlingar", "Museum", 57.6892, 11.9496, "🦕"),
    )

    suspend fun getPlaces(category: String? = null): List<Place> {
        delay(300)
        return if (category == null) allPlaces
        else allPlaces.filter { it.category == category }
    }

    fun getCategories(): List<String> = allPlaces.map { it.category }.distinct()
}
