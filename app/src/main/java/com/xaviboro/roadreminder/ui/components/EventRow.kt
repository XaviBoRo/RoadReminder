package com.xaviboro.roadreminder.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xaviboro.roadreminder.data.Event
import com.xaviboro.roadreminder.ui.theme.orangeIcon


@Composable
fun EventRow(
    event: Event,
    onClick: () -> Unit = {}
) {
    var checked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF111418), shape = RoundedCornerShape(20.dp)
            )
            .clickable { onClick() }
            .padding(25.dp), verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(
                    color = orangeIcon.copy(alpha = 0.12f), shape = RoundedCornerShape(8.dp)
                ), contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = event.icon,
                contentDescription = "Icono",
                tint = orangeIcon,
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = event.title,
                color = Color.White,
                fontWeight = FontWeight.Black,
                fontSize = 18.sp
            )
            Text(
                text = event.time,
                color = Color.Gray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = if (checked) Color.Green else Color.Gray.copy(alpha = 0.5f),
                    shape = CircleShape,
                )
                .background(
                    color = if (checked) Color.Green else Color.Transparent,
                    shape = CircleShape,
                )
                .clickable {
                    checked = !checked
                }, contentAlignment = Alignment.Center
        ) {
            if (checked) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Seleccionado",
                    tint = Color.Black,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

