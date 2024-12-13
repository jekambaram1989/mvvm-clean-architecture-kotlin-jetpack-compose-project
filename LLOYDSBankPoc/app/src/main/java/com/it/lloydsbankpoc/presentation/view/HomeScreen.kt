package com.it.lloydsbankpoc.presentation.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.it.lloydsbankpoc.navigation.AppNavigation
import com.it.lloydsbankpoc.presentation.bottomnavigation.BottomNav

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            BottomNav(navController = navController)
        }
    ) { innerPadding ->
        AppNavigation(navController = navController, innerPadding = innerPadding)
    }
}