package com.devgun.shadcn_android.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Switch

@Composable
fun SwitchSamples(onBack: () -> Unit) {
    var notifications by rememberSaveable { mutableStateOf(true) }
    var darkMode by rememberSaveable { mutableStateOf(false) }

    SampleScaffold(title = "Switch", onBack = onBack) {
        SampleSection(title = "Default") {
            Switch(
                checked = notifications,
                onCheckedChange = { notifications = it },
                label = "Enable notifications",
            )
        }

        SampleSection(title = "Off") {
            Switch(
                checked = darkMode,
                onCheckedChange = { darkMode = it },
                label = "Dark mode",
            )
        }

        SampleSection(title = "Disabled") {
            Switch(
                checked = true,
                onCheckedChange = {},
                label = "Disabled",
                enabled = false,
            )
        }
    }
}
