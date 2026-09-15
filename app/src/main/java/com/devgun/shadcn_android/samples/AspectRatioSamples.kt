package com.devgun.shadcn_android.samples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.AspectRatio
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun AspectRatioSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Aspect Ratio", onBack = onBack) {
        SampleSection(title = "16:9") {
            AspectRatio(
                ratio = 16f / 9f,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(ShadcnTheme.colors.muted),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("16:9", color = ShadcnTheme.colors.mutedForeground)
                }
            }
        }

        SampleSection(title = "1:1") {
            AspectRatio(
                ratio = 1f,
                modifier = Modifier.fillMaxWidth(0.5f),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(ShadcnTheme.colors.accent),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("1:1", color = ShadcnTheme.colors.accentForeground)
                }
            }
        }
    }
}
