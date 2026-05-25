package com.goteborgaren.app.presentation.ui.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goteborgaren.app.data.model.DayWeather
import com.goteborgaren.app.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class WeatherUiState(
    val forecast: List<DayWeather> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    fun loadForecast() {
        viewModelScope.launch {
            _uiState.value = WeatherUiState(isLoading = true)
            try {
                val forecast = repository.getForecast()
                _uiState.value = WeatherUiState(forecast = forecast)
            } catch (e: Exception) {
                _uiState.value = WeatherUiState(error = e.message)
            }
        }
    }
}
