package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Typography
import com.devgun.shadcn_android.ui.components.TypographyVariant

@Composable
fun TypographySamples(onBack: () -> Unit) {
    SampleScaffold(title = "Typography", onBack = onBack) {
        SampleSection(title = "Headings") {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Typography(text = "Heading 1", variant = TypographyVariant.H1)
                Typography(text = "Heading 2", variant = TypographyVariant.H2)
                Typography(text = "Heading 3", variant = TypographyVariant.H3)
                Typography(text = "Heading 4", variant = TypographyVariant.H4)
            }
        }

        SampleSection(title = "Body") {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Typography(
                    text = "Lead text for introductions and summaries.",
                    variant = TypographyVariant.Lead,
                )
                Typography(
                    text = "Paragraph text for regular content.",
                    variant = TypographyVariant.P,
                )
                Typography(
                    text = "Muted helper text.",
                    variant = TypographyVariant.Muted,
                )
                Typography(text = "inline code", variant = TypographyVariant.InlineCode)
            }
        }
    }
}
