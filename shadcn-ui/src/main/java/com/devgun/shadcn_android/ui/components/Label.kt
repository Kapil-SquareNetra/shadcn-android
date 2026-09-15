package com.devgun.shadcn_android.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun Label(
    text: String,
    modifier: Modifier = Modifier,
    required: Boolean = false,
) {
    val colors = ShadcnTheme.colors
    val displayText = if (required) "$text *" else text
    Text(
        text = displayText,
        modifier = modifier,
        style = androidx.compose.material3.MaterialTheme.typography.labelMedium.copy(
            fontWeight = FontWeight.Medium,
            color = colors.foreground,
        ),
    )
}
