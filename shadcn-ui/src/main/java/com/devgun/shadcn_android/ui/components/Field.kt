package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun Field(
    label: String,
    modifier: Modifier = Modifier,
    required: Boolean = false,
    description: String? = null,
    error: String? = null,
    content: @Composable () -> Unit,
) {
    val colors = ShadcnTheme.colors
    Column(modifier = modifier) {
        Label(text = label, required = required)
        if (description != null) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                color = colors.mutedForeground,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        content()
        if (error != null) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = error,
                style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                color = colors.destructive,
            )
        }
    }
}
