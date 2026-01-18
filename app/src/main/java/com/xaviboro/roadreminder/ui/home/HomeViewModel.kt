package com.xaviboro.roadreminder.ui.home


import androidx.lifecycle.ViewModel
import com.xaviboro.roadreminder.data.datasource.FakeEventDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class HomeViewModel : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    fun setState(reducer: HomeState.() -> HomeState) {
        _state.value = _state.value.reducer()
    }

    init {
        loadEvents()
    }

    private fun loadEvents() {
        val events = FakeEventDataSource.getTodayEvents()
        _state.update { currentState ->
            currentState.copy(events = events)
        }
        setState { updateIsLoading(false) }
    }
}


