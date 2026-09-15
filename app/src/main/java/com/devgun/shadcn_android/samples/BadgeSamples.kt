package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Badge
import com.devgun.shadcn_android.ui.components.BadgeVariant

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BadgeSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Badge", onBack = onBack) {
        SampleSection(title = "Variants") {
            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                BadgeVariant.entries.forEach { variant ->
                    Badge(text = variant.name, variant = variant)
                }
            }
        }

        SampleSection(title = "Typical Usage") {
            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Badge(text = "New")
                Badge(text = "Beta", variant = BadgeVariant.Secondary)
                Badge(text = "Error", variant = BadgeVariant.Destructive)
                Badge(text = "Draft", variant = BadgeVariant.Outline)
            }
        }
    }
}
