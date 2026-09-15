package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class ButtonVariant {
    Default,
    Secondary,
    Destructive,
    Outline,
    Ghost,
    Link,
}

enum class ButtonSize {
    Default,
    Sm,
    Lg,
    Icon,
}

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.Default,
    size: ButtonSize = ButtonSize.Default,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val colors = ShadcnTheme.colors
    val radius = ShadcnTheme.radius
    val shape = radius.mdShape
    val contentPadding = buttonContentPadding(size)
    val textStyle = buttonTextStyle(size)
    val minHeight = buttonMinHeight(size)

    val wrappedContent: @Composable RowScope.() -> Unit = {
        CompositionLocalProvider(
            LocalContentColor provides buttonContentColor(variant, enabled),
        ) {
            ProvideButtonTextStyle(textStyle, content)
        }
    }

    when (variant) {
        ButtonVariant.Default -> {
            Button(
                onClick = onClick,
                modifier = modifier.defaultMinSize(minHeight = minHeight),
                enabled = enabled,
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.primary,
                    contentColor = colors.primaryForeground,
                    disabledContainerColor = colors.muted,
                    disabledContentColor = colors.mutedForeground,
                ),
                contentPadding = contentPadding,
                interactionSource = interactionSource,
                content = wrappedContent,
            )
        }

        ButtonVariant.Secondary -> {
            Button(
                onClick = onClick,
                modifier = modifier.defaultMinSize(minHeight = minHeight),
                enabled = enabled,
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.secondary,
                    contentColor = colors.secondaryForeground,
                    disabledContainerColor = colors.muted,
                    disabledContentColor = colors.mutedForeground,
                ),
                contentPadding = contentPadding,
                interactionSource = interactionSource,
                content = wrappedContent,
            )
        }

        ButtonVariant.Destructive -> {
            Button(
                onClick = onClick,
                modifier = modifier.defaultMinSize(minHeight = minHeight),
                enabled = enabled,
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.destructive,
                    contentColor = colors.destructiveForeground,
                    disabledContainerColor = colors.muted,
                    disabledContentColor = colors.mutedForeground,
                ),
                contentPadding = contentPadding,
                interactionSource = interactionSource,
                content = wrappedContent,
            )
        }

        ButtonVariant.Outline -> {
            OutlinedButton(
                onClick = onClick,
                modifier = modifier.defaultMinSize(minHeight = minHeight),
                enabled = enabled,
                shape = shape,
                border = BorderStroke(1.dp, if (enabled) colors.input else colors.muted),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = colors.background,
                    contentColor = colors.foreground,
                    disabledContainerColor = colors.background,
                    disabledContentColor = colors.mutedForeground,
                ),
                contentPadding = contentPadding,
                interactionSource = interactionSource,
                content = wrappedContent,
            )
        }

        ButtonVariant.Ghost -> {
            TextButton(
                onClick = onClick,
                modifier = modifier.defaultMinSize(minHeight = minHeight),
                enabled = enabled,
                shape = shape,
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = colors.foreground,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = colors.mutedForeground,
                ),
                contentPadding = contentPadding,
                interactionSource = interactionSource,
                content = wrappedContent,
            )
        }

        ButtonVariant.Link -> {
            TextButton(
                onClick = onClick,
                modifier = modifier.defaultMinSize(minHeight = minHeight),
                enabled = enabled,
                shape = shape,
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = colors.primary,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = colors.mutedForeground,
                ),
                contentPadding = contentPadding,
                interactionSource = interactionSource,
                content = wrappedContent,
            )
        }
    }
}

@Composable
private fun buttonContentColor(variant: ButtonVariant, enabled: Boolean): Color {
    val colors = ShadcnTheme.colors
    if (!enabled) return colors.mutedForeground
    return when (variant) {
        ButtonVariant.Default -> colors.primaryForeground
        ButtonVariant.Secondary -> colors.secondaryForeground
        ButtonVariant.Destructive -> colors.destructiveForeground
        ButtonVariant.Outline, ButtonVariant.Ghost -> colors.foreground
        ButtonVariant.Link -> colors.primary
    }
}

@Composable
private fun buttonContentPadding(size: ButtonSize): PaddingValues {
    return when (size) {
        ButtonSize.Default -> PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ButtonSize.Sm -> PaddingValues(horizontal = 12.dp, vertical = 6.dp)
        ButtonSize.Lg -> PaddingValues(horizontal = 24.dp, vertical = 10.dp)
        ButtonSize.Icon -> PaddingValues(horizontal = 10.dp, vertical = 10.dp)
    }
}

@Composable
private fun buttonMinHeight(size: ButtonSize) = when (size) {
    ButtonSize.Default -> 36.dp
    ButtonSize.Sm -> 32.dp
    ButtonSize.Lg -> 40.dp
    ButtonSize.Icon -> 36.dp
}

@Composable
private fun buttonTextStyle(size: ButtonSize): TextStyle {
    val typography = androidx.compose.material3.MaterialTheme.typography
    return when (size) {
        ButtonSize.Default, ButtonSize.Lg, ButtonSize.Icon -> typography.labelLarge
        ButtonSize.Sm -> typography.labelMedium
    }
}

@Composable
private fun RowScope.ProvideButtonTextStyle(
    textStyle: TextStyle,
    content: @Composable RowScope.() -> Unit,
) {
    content()
}
