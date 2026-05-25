package com.goteborgaren.app.presentation.ui.discover

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goteborgaren.app.data.model.Place
import com.goteborgaren.app.data.repository.PlaceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DiscoverUiState(
    val places: List<Place> = emptyList(),
    val categories: List<String> = emptyList(),
    val selectedCategory: String? = null,
    val isLoading: Boolean = false
)

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val repository: PlaceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DiscoverUiState())
    val uiState: StateFlow<DiscoverUiState> = _uiState.asStateFlow()

    init {
        loadPlaces()
    }

    fun loadPlaces(category: String? = null) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, selectedCategory = category)
            val places = repository.getPlaces(category)
            val categories = repository.getCategories()
            _uiState.value = DiscoverUiState(
                places = places,
                categories = categories,
                selectedCategory = category
            )
        }
    }

    fun filterByCategory(category: String?) {
        loadPlaces(category)
    }
}
