package com.example.binlist.presentation.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import com.example.binlist.domain.model.BottomNavItem

fun getNavigationItems(): List<BottomNavItem> {
    return listOf(
        BottomNavItem(
            title = "Главная",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = Routes.Home
        ),
        BottomNavItem(
            title = "История",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
            route = Routes.History
        )
    )
}