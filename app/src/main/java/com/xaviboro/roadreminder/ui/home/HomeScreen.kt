package com.xaviboro.roadreminder.ui.home


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.xaviboro.roadreminder.ui.components.TopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onEventClick: (Int) -> Unit,
    onAddEventClick: () -> Unit,
    onVoiceCommandClick: () -> Unit
) {

    val uiState by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = { TopBar() }
    ) { padding ->

        HomeContent(
            uiState,
            modifier = Modifier.padding(padding),
            onEventClick = onEventClick,
            onAddEventClick = onAddEventClick,
            onVoiceCommandClick = onVoiceCommandClick
        )
    }
}

