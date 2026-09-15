package com.devgun.shadcn_android.ui.components

import androidx.compose.ui.graphics.vector.ImageVector

data class NavDestination(
    val id: String,
    val label: String,
    val icon: ImageVector,
    val enabled: Boolean = true,
)
