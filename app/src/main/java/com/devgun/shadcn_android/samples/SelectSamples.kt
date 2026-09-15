package com.devgun.shadcn_android.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Select
import com.devgun.shadcn_android.ui.components.SelectOption

@Composable
fun SelectSamples(onBack: () -> Unit) {
    var fruit by rememberSaveable { mutableStateOf<String?>(null) }

    val options = listOf(
        SelectOption("apple", "Apple"),
        SelectOption("banana", "Banana"),
        SelectOption("orange", "Orange"),
    )

    SampleScaffold(title = "Select", onBack = onBack) {
        SampleSection(title = "Default") {
            Select(
                options = options,
                selectedValue = fruit,
                onValueChange = { fruit = it },
                label = "Fruit",
                placeholder = "Select a fruit",
            )
        }

        SampleSection(title = "Disabled") {
            Select(
                options = options,
                selectedValue = "apple",
                onValueChange = {},
                label = "Fruit",
                enabled = false,
            )
        }
    }
}
