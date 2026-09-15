package com.devgun.shadcn_android.samples

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.BottomNavigation
import com.devgun.shadcn_android.ui.components.NavDestination
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun BottomNavigationSamples(onBack: () -> Unit) {
    var selected by rememberSaveable { mutableStateOf("home") }
    val items = listOf(
        NavDestination("home", "Home", Icons.Default.Home),
        NavDestination("search", "Search", Icons.Default.Search),
        NavDestination("profile", "Profile", Icons.Default.Person),
        NavDestination("settings", "Settings", Icons.Default.Settings, enabled = false),
    )

    SampleScaffold(title = "Bottom Navigation", onBack = onBack) {
        SampleSection(title = "Default") {
            BottomNavigation(
                items = items,
                selectedId = selected,
                onSelectedChange = { selected = it },
            )
            Text("Selected: $selected", color = ShadcnTheme.colors.mutedForeground)
        }
    }
}
