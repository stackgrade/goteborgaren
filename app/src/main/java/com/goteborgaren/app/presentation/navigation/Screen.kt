package com.goteborgaren.app.presentation.navigation

sealed class Screen(val route: String, val title: String, val icon: String) {
    data object Home : Screen("home", "Hem", "🏠")
    data object Departures : Screen("departures", "Avgångar", "🚋")
    data object Weather : Screen("weather", "Väder", "🌤️")
    data object Discover : Screen("discover", "Upptäck", "📍")
    data object About : Screen("about", "Om mig", "👨‍💻")
}
