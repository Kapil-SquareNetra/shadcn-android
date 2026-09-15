package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.ScrollArea
import com.devgun.shadcn_android.ui.components.ScrollAreaOrientation
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun ScrollAreaSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Scroll Area", onBack = onBack) {
        SampleSection(title = "Vertical") {
            ScrollArea(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
            ) {
                repeat(20) { index ->
                    Text(
                        text = "Row ${index + 1}",
                        modifier = Modifier.padding(8.dp),
                        color = ShadcnTheme.colors.foreground,
                    )
                }
            }
        }
        SampleSection(title = "Horizontal") {
            ScrollArea(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                orientation = ScrollAreaOrientation.Horizontal,
            ) {
                Text(
                    text = "A long strip of content that overflows the viewport on smaller phones. ".repeat(3),
                    modifier = Modifier
                        .width(720.dp)
                        .padding(8.dp),
                    color = ShadcnTheme.colors.foreground,
                    maxLines = 1,
                )
            }
        }
    }
}
