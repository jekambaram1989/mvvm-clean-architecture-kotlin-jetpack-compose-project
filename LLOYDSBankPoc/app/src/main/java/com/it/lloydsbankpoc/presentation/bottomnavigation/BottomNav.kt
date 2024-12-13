package com.it.lloydsbankpoc.presentation.bottomnavigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.it.lloydsbankpoc.core.resources.AppColor.APP_COLOR
import com.it.lloydsbankpoc.core.resources.AppTextStyle.bottomBarSelectedItemTextStyle
import com.it.lloydsbankpoc.core.resources.AppTextStyle.bottomBarUnselectedItemTextStyle
import com.it.lloydsbankpoc.core.resources.Dimens.elevation
import com.it.lloydsbankpoc.presentation.bottomnavigation.BottomNavItems.Companion.navItems

@Composable
fun BottomNav(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route
    BottomNavigation(
        elevation = elevation, backgroundColor = Color(APP_COLOR.toColorInt())
    ) {
        navItems.forEach { items ->
            NavigationBarItem(colors = NavigationBarItemDefaults.colors(
                selectedTextColor = Color.Black,
                selectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                unselectedIconColor = Color.White,
                indicatorColor = Color.Black
            ), label = {
                val textStyle = if (currentDestination == items.route)
                    bottomBarSelectedItemTextStyle()
                else
                    bottomBarUnselectedItemTextStyle()
                Text(
                    text = items.title,
                    style = textStyle
                )
            }, selected = currentDestination == items.route, onClick = {
                navController.navigate(items.route) {
                    navController.graph.startDestinationRoute?.let { screenRoute ->
                        popUpTo(screenRoute)
                        launchSingleTop = true
                    }
                }
            }, icon = {
                Icon(
                    imageVector = items.icon, contentDescription = items.title
                )
            })
        }
    }
}