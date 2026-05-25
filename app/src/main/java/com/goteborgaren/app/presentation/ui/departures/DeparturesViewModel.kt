package com.goteborgaren.app.presentation.ui.departures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goteborgaren.app.data.model.DepartureDisplay
import com.goteborgaren.app.data.repository.DepartureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DepartureUiState(
    val departures: List<DepartureDisplay> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class DeparturesViewModel @Inject constructor(
    private val repository: DepartureRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DepartureUiState())
    val uiState: StateFlow<DepartureUiState> = _uiState.asStateFlow()

    fun loadDepartures() {
        viewModelScope.launch {
            _uiState.value = DepartureUiState(isLoading = true)
            try {
                val deps = repository.getDepartures()
                _uiState.value = DepartureUiState(departures = deps)
            } catch (e: Exception) {
                _uiState.value = DepartureUiState(error = e.message)
            }
        }
    }

    fun refreshPeriodically() {
        loadDepartures()
        viewModelScope.launch {
            while (true) {
                delay(30_000) // Refresh var 30:e sekund
                loadDepartures()
            }
        }
    }
}
