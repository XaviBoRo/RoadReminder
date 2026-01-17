package com.xaviboro.roadreminder.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.SportsGymnastics

object FakeEventRepository {

    fun getTodayEvents(): List<Event> {
        return listOf(
            Event(1, "Llamar a cliente", "09:00h", false, Icons.Default.Call),
            Event(2, "Reunion en Barcelona", "12:30h", false, Icons.Default.Map),
            Event(3, "Gimnasio", "18:00h", false, Icons.Default.SportsGymnastics)

        )
    }

}