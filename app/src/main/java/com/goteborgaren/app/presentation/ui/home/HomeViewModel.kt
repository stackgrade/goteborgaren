package com.goteborgaren.app.presentation.ui.home

import androidx.lifecycle.ViewModel
import com.goteborgaren.app.data.repository.DepartureRepository
import com.goteborgaren.app.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val departureRepo: DepartureRepository,
    private val weatherRepo: WeatherRepository
) : ViewModel() {

    // Förenklad state-lös presentation utan StateFlow
    // för att hålla appen enkel (inget API-anrop vid start)
    val welcomeMessage = "Välkommen till Göteborg!"
    val cityFacts = listOf(
        "2:a största staden i Sverige",
        "Grundades 1621 av Gustav II Adolf",
        "Hamnstaden vid Göta älvs mynning",
        "Hem till Chalmers & Göteborgs Universitet",
        "Volvos huvudstad",
        "Stena Line-färjor till Danmark & Tyskland",
        "Liseberg — bästa nöjesparken i Norden",
        "Född ur försvarsbehov mot Danmark"
    )
}
