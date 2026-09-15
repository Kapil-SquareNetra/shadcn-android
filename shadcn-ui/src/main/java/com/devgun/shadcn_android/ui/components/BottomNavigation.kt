package com.devgun.shadcn_android.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun BottomNavigation(
    items: List<NavDestination>,
    selectedId: String,
    onSelectedChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = ShadcnTheme.colors
    NavigationBar(
        modifier = modifier,
        containerColor = colors.background,
        contentColor = colors.foreground,
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = item.id == selectedId,
                onClick = { if (item.enabled) onSelectedChange(item.id) },
                icon = { Icon(item.icon, contentDescription = item.label) },
                enabled = item.enabled,
                label = { Text(item.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colors.foreground,
                    selectedTextColor = colors.foreground,
                    indicatorColor = colors.muted,
                    unselectedIconColor = colors.mutedForeground,
                    unselectedTextColor = colors.mutedForeground,
                    disabledIconColor = colors.mutedForeground.copy(alpha = 0.5f),
                    disabledTextColor = colors.mutedForeground.copy(alpha = 0.5f),
                ),
            )
        }
    }
}
