package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatBold
import androidx.compose.material.icons.filled.FormatItalic
import androidx.compose.material.icons.filled.FormatUnderlined
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Toggle
import com.devgun.shadcn_android.ui.components.ToggleVariant

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ToggleSamples(onBack: () -> Unit) {
    var bold by rememberSaveable { mutableStateOf(false) }
    var italic by rememberSaveable { mutableStateOf(true) }
    var underline by rememberSaveable { mutableStateOf(false) }

    SampleScaffold(title = "Toggle", onBack = onBack) {
        SampleSection(title = "Default variant") {
            FlowRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Toggle(
                    checked = bold,
                    onCheckedChange = { bold = it },
                    icon = Icons.Default.FormatBold,
                    contentDescription = "Bold",
                )
                Toggle(
                    checked = italic,
                    onCheckedChange = { italic = it },
                    icon = Icons.Default.FormatItalic,
                    contentDescription = "Italic",
                )
            }
        }

        SampleSection(title = "Outline variant") {
            FlowRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Toggle(
                    checked = underline,
                    onCheckedChange = { underline = it },
                    icon = Icons.Default.FormatUnderlined,
                    contentDescription = "Underline",
                    variant = ToggleVariant.Outline,
                )
            }
        }

        SampleSection(title = "Disabled") {
            Toggle(
                checked = true,
                onCheckedChange = {},
                icon = Icons.Default.FormatBold,
                contentDescription = "Bold",
                enabled = false,
            )
        }
    }
}
