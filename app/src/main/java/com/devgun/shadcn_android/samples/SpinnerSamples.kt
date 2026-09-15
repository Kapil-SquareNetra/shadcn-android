package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Spinner
import com.devgun.shadcn_android.ui.components.SpinnerSize

@Composable
fun SpinnerSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Spinner", onBack = onBack) {
        SampleSection(title = "Sizes") {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spinner(size = SpinnerSize.Sm)
                Spinner()
                Spinner(size = SpinnerSize.Lg)
            }
        }
    }
}
