package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Skeleton
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun SkeletonSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Skeleton", onBack = onBack) {
        SampleSection(title = "Loading Placeholder") {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Skeleton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp),
                    shape = ShadcnTheme.radius.smShape,
                )
                Skeleton(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(16.dp),
                    shape = ShadcnTheme.radius.smShape,
                )
                Skeleton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    shape = ShadcnTheme.radius.lgShape,
                )
            }
        }
    }
}
