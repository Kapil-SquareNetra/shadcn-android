package com.devgun.shadcn_android.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Checkbox

@Composable
fun CheckboxSamples(onBack: () -> Unit) {
    var terms by rememberSaveable { mutableStateOf(false) }
    var newsletter by rememberSaveable { mutableStateOf(true) }

    SampleScaffold(title = "Checkbox", onBack = onBack) {
        SampleSection(title = "Default") {
            Checkbox(
                checked = terms,
                onCheckedChange = { terms = it },
                label = "Accept terms and conditions",
            )
        }

        SampleSection(title = "Checked") {
            Checkbox(
                checked = newsletter,
                onCheckedChange = { newsletter = it },
                label = "Subscribe to newsletter",
            )
        }

        SampleSection(title = "Disabled") {
            Checkbox(
                checked = true,
                onCheckedChange = {},
                label = "Disabled checked",
                enabled = false,
            )
        }
    }
}
