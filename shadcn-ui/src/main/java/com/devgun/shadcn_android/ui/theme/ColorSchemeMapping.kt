package com.devgun.shadcn_android.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

internal fun ShadcnColors.toColorScheme(isDark: Boolean): ColorScheme {
    return if (isDark) {
        darkColorScheme(
            primary = primary,
            onPrimary = primaryForeground,
            primaryContainer = primary,
            onPrimaryContainer = primaryForeground,
            secondary = secondary,
            onSecondary = secondaryForeground,
            secondaryContainer = secondary,
            onSecondaryContainer = secondaryForeground,
            tertiary = accent,
            onTertiary = accentForeground,
            tertiaryContainer = accent,
            onTertiaryContainer = accentForeground,
            background = background,
            onBackground = foreground,
            surface = background,
            onSurface = foreground,
            surfaceVariant = muted,
            onSurfaceVariant = mutedForeground,
            surfaceContainerHighest = card,
            error = destructive,
            onError = destructiveForeground,
            outline = border,
            outlineVariant = input,
            inverseSurface = foreground,
            inverseOnSurface = background,
            inversePrimary = primary,
        )
    } else {
        lightColorScheme(
            primary = primary,
            onPrimary = primaryForeground,
            primaryContainer = primary,
            onPrimaryContainer = primaryForeground,
            secondary = secondary,
            onSecondary = secondaryForeground,
            secondaryContainer = secondary,
            onSecondaryContainer = secondaryForeground,
            tertiary = accent,
            onTertiary = accentForeground,
            tertiaryContainer = accent,
            onTertiaryContainer = accentForeground,
            background = background,
            onBackground = foreground,
            surface = background,
            onSurface = foreground,
            surfaceVariant = muted,
            onSurfaceVariant = mutedForeground,
            surfaceContainerHighest = card,
            error = destructive,
            onError = destructiveForeground,
            outline = border,
            outlineVariant = input,
            inverseSurface = foreground,
            inverseOnSurface = background,
            inversePrimary = primary,
        )
    }
}
