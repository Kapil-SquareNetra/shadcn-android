package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.NavDestination
import com.devgun.shadcn_android.ui.components.NavigationRail
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun NavigationRailSamples(onBack: () -> Unit) {
    var selected by rememberSaveable { mutableStateOf("home") }
    val items = listOf(
        NavDestination("home", "Home", Icons.Default.Home),
        NavDestination("search", "Search", Icons.Default.Search),
        NavDestination("profile", "Profile", Icons.Default.Person),
    )

    SampleScaffold(title = "Navigation Rail", onBack = onBack) {
        SampleSection(title = "Tablet chrome") {
            Row(verticalAlignment = Alignment.Top) {
                NavigationRail(
                    items = items,
                    selectedId = selected,
                    onSelectedChange = { selected = it },
                    modifier = Modifier.height(280.dp),
                )
                Text(
                    text = "Selected: $selected",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    color = ShadcnTheme.colors.mutedForeground,
                )
            }
        }
    }
}
