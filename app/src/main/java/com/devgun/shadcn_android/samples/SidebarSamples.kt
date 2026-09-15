package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.SidebarGroupLabel
import com.devgun.shadcn_android.ui.components.SidebarLayout
import com.devgun.shadcn_android.ui.components.SidebarMenuButton
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun SidebarSamples(onBack: () -> Unit) {
    var expanded by rememberSaveable { mutableStateOf(true) }
    var selected by rememberSaveable { mutableStateOf("home") }

    SampleScaffold(title = "Sidebar", onBack = onBack) {
        SampleSection(title = "Tablet / foldable") {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp),
            ) {
                SidebarLayout(
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    sidebar = {
                        SidebarGroupLabel("Workspace")
                        SidebarMenuButton(
                            selected = selected == "home",
                            onClick = { selected = "home" },
                            icon = Icons.Default.Home,
                            label = "Home",
                        )
                        SidebarMenuButton(
                            selected = selected == "projects",
                            onClick = { selected = "projects" },
                            icon = Icons.Default.Folder,
                            label = "Projects",
                        )
                        SidebarMenuButton(
                            selected = selected == "settings",
                            onClick = { selected = "settings" },
                            icon = Icons.Default.Settings,
                            label = "Settings",
                            enabled = false,
                        )
                    },
                ) {
                    Text(
                        text = "Selected: $selected",
                        modifier = Modifier.padding(16.dp),
                        color = ShadcnTheme.colors.mutedForeground,
                    )
                }
            }
        }
    }
}
