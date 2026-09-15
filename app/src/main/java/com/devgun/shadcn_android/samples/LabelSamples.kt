package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Label

@Composable
fun LabelSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Label", onBack = onBack) {
        SampleSection(title = "Default") {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Label(text = "Email")
                Label(text = "Password", required = true)
            }
        }
    }
}
