package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Collapsible
import com.devgun.shadcn_android.ui.components.CollapsibleContent
import com.devgun.shadcn_android.ui.components.CollapsibleTrigger
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun CollapsibleSamples(onBack: () -> Unit) {
    var productOpen by rememberSaveable { mutableStateOf(false) }
    var settingsOpen by rememberSaveable { mutableStateOf(true) }

    SampleScaffold(title = "Collapsible", onBack = onBack) {
        SampleSection(title = "Basic") {
            Collapsible(
                expanded = productOpen,
                onExpandedChange = { productOpen = it },
            ) {
                CollapsibleTrigger {
                    Text(
                        text = "Product details",
                        style = androidx.compose.material3.MaterialTheme.typography.titleSmall,
                        color = ShadcnTheme.colors.foreground,
                    )
                }
                CollapsibleContent {
                    Column(
                        modifier = Modifier.padding(top = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        Text("Free shipping on orders over $50.", color = ShadcnTheme.colors.mutedForeground)
                        Text("In stock and ready to ship.", color = ShadcnTheme.colors.mutedForeground)
                    }
                }
            }
        }

        SampleSection(title = "Expanded by default") {
            Collapsible(
                expanded = settingsOpen,
                onExpandedChange = { settingsOpen = it },
            ) {
                CollapsibleTrigger {
                    Text(
                        text = "Advanced settings",
                        style = androidx.compose.material3.MaterialTheme.typography.titleSmall,
                        color = ShadcnTheme.colors.foreground,
                    )
                }
                CollapsibleContent {
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = "Radius, spacing, and density controls live here.",
                        color = ShadcnTheme.colors.mutedForeground,
                    )
                }
            }
        }

        SampleSection(title = "Disabled") {
            Collapsible(
                expanded = false,
                onExpandedChange = {},
                enabled = false,
            ) {
                CollapsibleTrigger {
                    Text("Disabled panel", color = ShadcnTheme.colors.mutedForeground)
                }
                CollapsibleContent {
                    Text("This content stays collapsed.")
                }
            }
        }
    }
}
