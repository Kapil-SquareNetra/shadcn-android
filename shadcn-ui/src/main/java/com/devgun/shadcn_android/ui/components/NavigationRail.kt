package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun NavigationRail(
    items: List<NavDestination>,
    selectedId: String,
    onSelectedChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    header: @Composable (ColumnScope.() -> Unit)? = null,
) {
    val colors = ShadcnTheme.colors
    NavigationRail(
        modifier = modifier,
        containerColor = colors.sidebar,
        contentColor = colors.sidebarForeground,
        header = header,
    ) {
        items.forEach { item ->
            NavigationRailItem(
                selected = item.id == selectedId,
                onClick = { if (item.enabled) onSelectedChange(item.id) },
                icon = { Icon(item.icon, contentDescription = item.label) },
                enabled = item.enabled,
                label = { Text(item.label) },
                colors = NavigationRailItemDefaults.colors(
                    selectedIconColor = colors.sidebarAccentForeground,
                    selectedTextColor = colors.sidebarAccentForeground,
                    indicatorColor = colors.sidebarAccent,
                    unselectedIconColor = colors.sidebarForeground,
                    unselectedTextColor = colors.sidebarForeground,
                    disabledIconColor = colors.mutedForeground,
                    disabledTextColor = colors.mutedForeground,
                ),
            )
        }
    }
}
