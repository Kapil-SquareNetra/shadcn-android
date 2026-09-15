package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Separator
import com.devgun.shadcn_android.ui.components.SeparatorOrientation
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun SeparatorSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Separator", onBack = onBack) {
        SampleSection(title = "Horizontal") {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Section above", color = ShadcnTheme.colors.foreground)
                Separator()
                Text("Section below", color = ShadcnTheme.colors.foreground)
            }
        }

        SampleSection(title = "Vertical") {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("Left", color = ShadcnTheme.colors.foreground)
                Separator(orientation = SeparatorOrientation.Vertical)
                Text("Right", color = ShadcnTheme.colors.foreground)
            }
        }
    }
}
