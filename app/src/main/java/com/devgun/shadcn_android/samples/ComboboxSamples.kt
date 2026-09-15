package com.devgun.shadcn_android.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Combobox
import com.devgun.shadcn_android.ui.components.SelectOption

@Composable
fun ComboboxSamples(onBack: () -> Unit) {
    var framework by rememberSaveable { mutableStateOf<String?>(null) }
    val options = listOf(
        SelectOption("compose", "Jetpack Compose"),
        SelectOption("swiftui", "SwiftUI"),
        SelectOption("flutter", "Flutter"),
        SelectOption("react", "React Native"),
    )

    SampleScaffold(title = "Combobox", onBack = onBack) {
        SampleSection(title = "Searchable") {
            Combobox(
                options = options,
                selectedValue = framework,
                onValueChange = { framework = it },
                placeholder = "Search framework...",
            )
        }
        SampleSection(title = "Disabled") {
            Combobox(
                options = options,
                selectedValue = "compose",
                onValueChange = {},
                enabled = false,
            )
        }
    }
}
