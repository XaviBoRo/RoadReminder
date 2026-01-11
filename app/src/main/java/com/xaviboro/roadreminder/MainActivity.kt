package com.xaviboro.roadreminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.xaviboro.roadreminder.theme.RoadReminderTheme
import com.xaviboro.roadreminder.ui.AppNavigation
import com.xaviboro.roadreminder.ui.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoadReminderTheme {
                AppNavigation()
            }
        }
    }

}