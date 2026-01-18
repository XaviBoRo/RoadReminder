package com.xaviboro.roadreminder.domain.usecase

import com.xaviboro.roadreminder.data.Event
import com.xaviboro.roadreminder.data.repository.EventRepository

class GetEventUseCase (
   private val eventRepository: EventRepository
) {
    operator fun invoke(): List<Event>{
        return eventRepository.getEvent()
    }
}