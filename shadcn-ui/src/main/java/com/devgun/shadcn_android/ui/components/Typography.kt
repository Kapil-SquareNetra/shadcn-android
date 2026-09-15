package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class TypographyVariant {
    H1,
    H2,
    H3,
    H4,
    P,
    Lead,
    Large,
    Small,
    Muted,
    Blockquote,
    InlineCode,
}

@Composable
fun Typography(
    text: String,
    modifier: Modifier = Modifier,
    variant: TypographyVariant = TypographyVariant.P,
) {
    val colors = ShadcnTheme.colors
    val typography = androidx.compose.material3.MaterialTheme.typography

    val style: TextStyle = when (variant) {
        TypographyVariant.H1 -> typography.displayLarge.copy(
            fontWeight = FontWeight.Bold,
            color = colors.foreground,
        )
        TypographyVariant.H2 -> typography.displayMedium.copy(
            fontWeight = FontWeight.SemiBold,
            color = colors.foreground,
        )
        TypographyVariant.H3 -> typography.headlineMedium.copy(
            fontWeight = FontWeight.SemiBold,
            color = colors.foreground,
        )
        TypographyVariant.H4 -> typography.headlineSmall.copy(
            fontWeight = FontWeight.SemiBold,
            color = colors.foreground,
        )
        TypographyVariant.P -> typography.bodyMedium.copy(color = colors.foreground)
        TypographyVariant.Lead -> typography.bodyLarge.copy(color = colors.mutedForeground)
        TypographyVariant.Large -> typography.titleLarge.copy(
            fontWeight = FontWeight.SemiBold,
            color = colors.foreground,
        )
        TypographyVariant.Small -> typography.bodySmall.copy(color = colors.foreground)
        TypographyVariant.Muted -> typography.bodySmall.copy(color = colors.mutedForeground)
        TypographyVariant.Blockquote -> typography.bodyLarge.copy(
            color = colors.foreground,
            fontStyle = FontStyle.Italic,
        )
        TypographyVariant.InlineCode -> typography.bodySmall.copy(
            fontFamily = FontFamily.Monospace,
            color = colors.foreground,
        )
    }

    val textModifier = if (variant == TypographyVariant.InlineCode) {
        modifier
            .background(colors.muted, ShadcnTheme.radius.smShape)
            .padding(horizontal = 4.dp, vertical = 2.dp)
    } else {
        modifier
    }

    Text(
        text = text,
        modifier = textModifier,
        style = style,
    )
}
