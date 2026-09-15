package com.devgun.shadcn_android.samples

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Button
import com.devgun.shadcn_android.ui.components.ButtonGroup
import com.devgun.shadcn_android.ui.components.ButtonGroupOrientation
import com.devgun.shadcn_android.ui.components.ButtonVariant

@Composable
fun ButtonGroupSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Button Group", onBack = onBack) {
        SampleSection(title = "Horizontal") {
            ButtonGroup {
                Button(onClick = {}) { Text("Save") }
                Button(onClick = {}, variant = ButtonVariant.Outline) { Text("Cancel") }
            }
        }

        SampleSection(title = "Vertical") {
            ButtonGroup(orientation = ButtonGroupOrientation.Vertical) {
                Button(onClick = {}) { Text("Primary Action") }
                Button(onClick = {}, variant = ButtonVariant.Secondary) { Text("Secondary") }
                Button(onClick = {}, variant = ButtonVariant.Ghost) { Text("Ghost") }
            }
        }
    }
}
