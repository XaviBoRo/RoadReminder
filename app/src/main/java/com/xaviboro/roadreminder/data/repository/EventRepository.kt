package com.xaviboro.roadreminder.data.repository

import com.xaviboro.roadreminder.data.Event
import com.xaviboro.roadreminder.data.datasource.FakeEventDataSource

class EventRepository (
    private val FakeEventDS : FakeEventDataSource
) {
    fun getEvent(): List<Event>{
        return FakeEventDS.getTodayEvents()
    }
}