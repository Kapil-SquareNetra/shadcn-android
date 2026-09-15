package com.devgun.shadcn_android.samples

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Slider
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun SliderSamples(onBack: () -> Unit) {
    var volume by rememberSaveable { mutableFloatStateOf(0.5f) }

    SampleScaffold(title = "Slider", onBack = onBack) {
        SampleSection(title = "Default") {
            Slider(
                value = volume,
                onValueChange = { volume = it },
            )
            Text(
                text = "Volume: ${(volume * 100).toInt()}%",
                color = ShadcnTheme.colors.mutedForeground,
            )
        }

        SampleSection(title = "Disabled") {
            Slider(
                value = 0.3f,
                onValueChange = {},
                enabled = false,
            )
        }
    }
}
