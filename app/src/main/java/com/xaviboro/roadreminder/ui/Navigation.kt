package com.xaviboro.roadreminder.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.xaviboro.roadreminder.ui.home.HomeScreen

object Routes {
    const val HOME = "home"
    const val EVENT_DETAIL = "event_detail/{eventId}"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME) {

        //Home Screen
        composable(Routes.HOME) {
            HomeScreen(
                onAddEventClick = { /* acción al añadir evento */ },
                onVoiceCommandClick = { /* acción comando de voz */ },
                onEventClick = { eventId: Int ->
                    navController.navigate("event_detail/$eventId")
                }
            )
        }
        //EventDetailScreen
        composable(
            Routes.EVENT_DETAIL,
            arguments = listOf(navArgument("eventId") { type = NavType.IntType })
        ) { backStackEntry ->
            val eventId = backStackEntry.arguments?.getInt("eventId") ?: 0
            EventDetailScreen(
                eventId = eventId,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}