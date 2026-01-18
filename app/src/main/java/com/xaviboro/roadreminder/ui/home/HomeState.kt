package com.xaviboro.roadreminder.ui.home

import com.xaviboro.roadreminder.data.Event

data class HomeState(
    val events: List<Event> = emptyList(),
    val isLoading: Boolean = false
) {
    fun updateIsLoading(isLoading: Boolean): HomeState{
        return copy(isLoading = isLoading)
    }
    fun setEvents(events: List<Event>): HomeState{
        return copy(events = events)
    }

}
