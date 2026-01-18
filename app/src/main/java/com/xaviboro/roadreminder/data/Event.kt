package com.xaviboro.roadreminder.data


import androidx.compose.ui.graphics.vector.ImageVector



data class Event(
    val id: Int,
    val title: String,
    val time: String,
    val isCompleted: Boolean,
    val icon: ImageVector
)

