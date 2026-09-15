package com.devgun.shadcn_android.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.RadioGroup
import com.devgun.shadcn_android.ui.components.RadioOption

@Composable
fun RadioGroupSamples(onBack: () -> Unit) {
    var plan by rememberSaveable { mutableStateOf("free") }

    val options = listOf(
        RadioOption("free", "Free"),
        RadioOption("pro", "Pro"),
        RadioOption("enterprise", "Enterprise"),
    )

    SampleScaffold(title = "Radio Group", onBack = onBack) {
        SampleSection(title = "Plan selection") {
            RadioGroup(
                options = options,
                selectedValue = plan,
                onValueChange = { plan = it },
            )
        }

        SampleSection(title = "Disabled") {
            RadioGroup(
                options = options,
                selectedValue = "pro",
                onValueChange = {},
                enabled = false,
            )
        }
    }
}
