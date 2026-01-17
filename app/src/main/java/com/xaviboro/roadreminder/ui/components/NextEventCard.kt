package com.xaviboro.roadreminder.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xaviboro.roadreminder.ui.theme.blueIcon
import com.xaviboro.roadreminder.ui.theme.lightBlue


@Preview
@Composable
fun NextEventCard(
    headerTitle: String = "SIGUIENTE PARADA",
    showHeader: Boolean = true
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        if (showHeader) {
            Text(
                text = headerTitle,
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 6.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF111418),
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(
                            color = lightBlue,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.CalendarMonth,
                        contentDescription = "Calendario",
                        tint = blueIcon,
                        modifier = Modifier.size(40.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = "Reunión con el equipo",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Black
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(36.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Schedule,
                                contentDescription = "Reloj",
                                tint = blueIcon,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Text(
                            text = "10:30",
                            color = blueIcon,
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Black
                        )
                    }
                }
            }

        }
    }
}
