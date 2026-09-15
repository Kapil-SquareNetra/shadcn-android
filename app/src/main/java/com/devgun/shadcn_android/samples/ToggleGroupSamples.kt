package com.devgun.shadcn_android.samples

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlignHorizontalCenter
import androidx.compose.material.icons.filled.FormatAlignLeft
import androidx.compose.material.icons.filled.FormatAlignRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.ToggleGroup
import com.devgun.shadcn_android.ui.components.ToggleGroupItem

@Composable
fun ToggleGroupSamples(onBack: () -> Unit) {
    var left by rememberSaveable { mutableStateOf(true) }
    var center by rememberSaveable { mutableStateOf(false) }
    var right by rememberSaveable { mutableStateOf(false) }

    SampleScaffold(title = "Toggle Group", onBack = onBack) {
        SampleSection(title = "Text alignment") {
            ToggleGroup {
                ToggleGroupItem(
                    checked = left,
                    onCheckedChange = {
                        left = it
                        if (it) {
                            center = false
                            right = false
                        }
                    },
                    icon = Icons.Default.FormatAlignLeft,
                    contentDescription = "Align left",
                )
                ToggleGroupItem(
                    checked = center,
                    onCheckedChange = {
                        center = it
                        if (it) {
                            left = false
                            right = false
                        }
                    },
                    icon = Icons.Default.AlignHorizontalCenter,
                    contentDescription = "Align center",
                )
                ToggleGroupItem(
                    checked = right,
                    onCheckedChange = {
                        right = it
                        if (it) {
                            left = false
                            center = false
                        }
                    },
                    icon = Icons.Default.FormatAlignRight,
                    contentDescription = "Align right",
                )
            }
        }
    }
}
