package com.devgun.shadcn_android.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Input
import com.devgun.shadcn_android.ui.components.InputGroup
import com.devgun.shadcn_android.ui.components.InputGroupAddonPosition

@Composable
fun InputGroupSamples(onBack: () -> Unit) {
    var amount by rememberSaveable { mutableStateOf("") }
    var website by rememberSaveable { mutableStateOf("") }

    SampleScaffold(title = "Input Group", onBack = onBack) {
        SampleSection(title = "Start addon") {
            InputGroup(addon = "$", addonPosition = InputGroupAddonPosition.Start) {
                Input(
                    value = amount,
                    onValueChange = { amount = it },
                    placeholder = "0.00",
                    showBorder = false,
                )
            }
        }

        SampleSection(title = "End addon") {
            InputGroup(addon = ".com", addonPosition = InputGroupAddonPosition.End) {
                Input(
                    value = website,
                    onValueChange = { website = it },
                    placeholder = "example",
                    showBorder = false,
                )
            }
        }
    }
}
