package com.xaviboro.roadreminder.ui

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.xaviboro.roadreminder.data.FakeEventRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(eventId: Int) {
    val event = FakeEventRepository.getTodayEvents().find { it.id == eventId }
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = {
            Text(
                text = "DETALLES",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            ) }) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text(
                text = "${event?.title} a las ${event?.time}",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center

            )
        }
    }
}