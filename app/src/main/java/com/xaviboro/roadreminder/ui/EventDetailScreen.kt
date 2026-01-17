package com.xaviboro.roadreminder.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Event
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xaviboro.roadreminder.data.FakeEventRepository
import com.xaviboro.roadreminder.ui.theme.blueIcon
import com.xaviboro.roadreminder.ui.theme.orangeIcon


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(
    eventId: Int,
    onBackClick: () -> Unit,
    width: Dp = 200.dp
) {
    val event = FakeEventRepository.getTodayEvents().find { it.id == eventId }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy((-8).dp)
                    ) {
                        Text(
                            text = "RoadReminder Details",
                            color = Color.Gray,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "Detalles",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,

                            )
                    }
                },
            )
        },

        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 70.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = onBackClick,
                    modifier = Modifier
                        .widthIn(width)
                        .height(70.dp),
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = blueIcon)
                ) {
                    Box(
                        modifier = Modifier
                            .size(18.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {

                        Text(
                            text = "VOLVER",
                            fontWeight = FontWeight.Black,
                            fontSize = 18.sp
                        )

                    }
                }
            }
        }

    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFF111418))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(orangeIcon.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = event?.icon ?: Icons.Default.Event,
                        contentDescription = event?.title,
                        tint = orangeIcon,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Text(
                    text = "${event?.title}",
                    modifier = Modifier.padding(top = 16.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold

                )
                Text(
                    text = "${event?.time}",
                    modifier = Modifier.padding(top = 8.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

    }

}

