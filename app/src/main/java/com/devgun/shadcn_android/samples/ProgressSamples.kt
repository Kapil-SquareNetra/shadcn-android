package com.devgun.shadcn_android.samples

import androidx.compose.runtime.Composable
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Progress
import com.devgun.shadcn_android.ui.components.ProgressVariant

@Composable
fun ProgressSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Progress", onBack = onBack) {
        SampleSection(title = "Linear (determinate)") {
            Progress(variant = ProgressVariant.Linear, progress = 0.6f)
        }

        SampleSection(title = "Linear (indeterminate)") {
            Progress(variant = ProgressVariant.Linear)
        }

        SampleSection(title = "Circular (determinate)") {
            Progress(variant = ProgressVariant.Circular, progress = 0.75f)
        }

        SampleSection(title = "Circular (indeterminate)") {
            Progress(variant = ProgressVariant.Circular)
        }
    }
}
