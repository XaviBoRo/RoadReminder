package com.xaviboro.roadreminder.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.xaviboro.roadreminder.ui.components.EventRow
import com.xaviboro.roadreminder.ui.components.NextEventCard
import com.xaviboro.roadreminder.ui.components.VoiceCommandButton
import com.xaviboro.roadreminder.ui.theme.blueIcon

@Composable
fun HomeContent(
    state: HomeState,
    modifier: Modifier = Modifier,
    onEventClick: (Int) -> Unit,
    onAddEventClick: () -> Unit,
    onVoiceCommandClick: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            if (state.events.isNotEmpty()) {
                item {
                    NextEventCard()
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "RESTO DEL DÍA",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                items(state.events.size) { event ->
                    EventRow(event = state.events.get(event)) { onEventClick(state.events.get(event).id) }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            } else {
                item {
                    Box(
                        modifier = Modifier.fillParentMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "No hay eventos para hoy", color = Color.Gray)
                    }
                }
            }
        }
        FloatingActionButton(
            onClick = onAddEventClick,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 20.dp, bottom = 140.dp)
                .size(58.dp)
                .zIndex(1f),
            containerColor = blueIcon,
            shape = CircleShape
        ) {
            Icon(Icons.Default.Add, tint = Color.White, contentDescription = "Añadir")
        }

        VoiceCommandButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp),
            onClick = onVoiceCommandClick
        )
    }
}