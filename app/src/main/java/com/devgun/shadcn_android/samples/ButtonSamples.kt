package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Button
import com.devgun.shadcn_android.ui.components.ButtonSize
import com.devgun.shadcn_android.ui.components.ButtonVariant

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ButtonSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Button", onBack = onBack) {
        SampleSection(title = "Variants") {
            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                ButtonVariant.entries.forEach { variant ->
                    Button(onClick = {}, variant = variant) {
                        Text(variant.name)
                    }
                }
            }
        }

        SampleSection(title = "Sizes") {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(onClick = {}, size = ButtonSize.Sm) { Text("Small") }
                Button(onClick = {}) { Text("Default") }
                Button(onClick = {}, size = ButtonSize.Lg) { Text("Large") }
                Button(onClick = {}, size = ButtonSize.Icon) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        }

        SampleSection(title = "Disabled") {
            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = {}, enabled = false) { Text("Disabled") }
                Button(onClick = {}, variant = ButtonVariant.Outline, enabled = false) {
                    Text("Disabled Outline")
                }
            }
        }

        SampleSection(title = "With Icon") {
            Button(onClick = {}) {
                Icon(Icons.Default.Add, contentDescription = null)
                Text("Add Item")
            }
        }
    }
}
