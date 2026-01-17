package com.xaviboro.roadreminder.ui.home


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.xaviboro.roadreminder.data.Event
import com.xaviboro.roadreminder.data.FakeEventRepository
import com.xaviboro.roadreminder.ui.components.EventRow
import com.xaviboro.roadreminder.ui.components.NextEventCard
import com.xaviboro.roadreminder.ui.components.TopBar
import com.xaviboro.roadreminder.ui.components.VoiceCommandButton
import com.xaviboro.roadreminder.ui.theme.blueIcon


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    events: List<Event> = FakeEventRepository.getTodayEvents(),
    onEventClick: (Int) -> Unit,
    onAddEventClick: () -> Unit,
    onVoiceCommandClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar()
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                if (events.isNotEmpty()) {
                    item {
                        NextEventCard()
                    }
                    item {

                        Spacer(modifier = Modifier.height(24.dp))
                        Text(
                            text = "RESTO DEL DÍA",
                            color = Color.Gray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    items(events) { event ->
                        EventRow(event = event) { onEventClick(event.id) }
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                } else {
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "No hay eventos para hoy", color = Color.Gray)
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
                containerColor = blueIcon, shape = CircleShape
            ) {
                Icon(
                    Icons.Default.Add,
                    tint = Color.White,
                    contentDescription = "Añadir evento"
                )
            }
            VoiceCommandButton(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(40.dp),
                onClick = onVoiceCommandClick
            )
        }
    }
}


