package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class BadgeVariant {
    Default,
    Secondary,
    Destructive,
    Outline,
}

@Composable
fun Badge(
    modifier: Modifier = Modifier,
    variant: BadgeVariant = BadgeVariant.Default,
    content: @Composable () -> Unit,
) {
    val colors = ShadcnTheme.colors
    val radius = ShadcnTheme.radius
    val (backgroundColor, foregroundColor, borderColor) = badgeColors(variant, colors)

    Box(
        modifier = modifier
            .background(backgroundColor, radius.fullShape)
            .then(
                if (borderColor != null) {
                    Modifier.border(1.dp, borderColor, radius.fullShape)
                } else {
                    Modifier
                },
            )
            .padding(horizontal = 10.dp, vertical = 2.dp),
        contentAlignment = Alignment.Center,
    ) {
        CompositionLocalProvider(
            LocalTextStyle provides androidx.compose.material3.MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.SemiBold,
                color = foregroundColor,
            ),
        ) {
            content()
        }
    }
}

@Composable
fun Badge(
    text: String,
    modifier: Modifier = Modifier,
    variant: BadgeVariant = BadgeVariant.Default,
) {
    Badge(modifier = modifier, variant = variant) {
        Text(text = text)
    }
}

private data class BadgeColorSet(
    val background: Color,
    val foreground: Color,
    val border: Color?,
)

private fun badgeColors(
    variant: BadgeVariant,
    colors: com.devgun.shadcn_android.ui.theme.ShadcnColors,
): BadgeColorSet {
    return when (variant) {
        BadgeVariant.Default -> BadgeColorSet(
            background = colors.primary,
            foreground = colors.primaryForeground,
            border = null,
        )
        BadgeVariant.Secondary -> BadgeColorSet(
            background = colors.secondary,
            foreground = colors.secondaryForeground,
            border = null,
        )
        BadgeVariant.Destructive -> BadgeColorSet(
            background = colors.destructive,
            foreground = colors.destructiveForeground,
            border = null,
        )
        BadgeVariant.Outline -> BadgeColorSet(
            background = colors.background,
            foreground = colors.foreground,
            border = colors.border,
        )
    }
}
