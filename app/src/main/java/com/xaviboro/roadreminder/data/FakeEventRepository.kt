package com.xaviboro.roadreminder.data

object FakeEventRepository {

    fun getTodayEvents(): List<Event> {
        return listOf(
            Event(1, "Reunión con el equipo", "09:00", false),
            Event(2, "Llamar a cliente", "12:30", false),
            Event(3, "Gimnasio", "18:00", false)
        )
    }

}