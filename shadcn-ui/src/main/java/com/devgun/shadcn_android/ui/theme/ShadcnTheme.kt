package com.devgun.shadcn_android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object ShadcnTheme {
    val colors: ShadcnColors
        @Composable
        @ReadOnlyComposable
        get() = LocalShadcnColors.current

    val radius: ShadcnRadius
        @Composable
        @ReadOnlyComposable
        get() = LocalShadcnRadius.current
}

@Composable
fun ShadcnTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: ShadcnColors = if (darkTheme) darkShadcnColors else lightShadcnColors,
    radius: ShadcnRadius = defaultShadcnRadius,
    typography: Typography = ShadcnTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalShadcnColors provides colors,
        LocalShadcnRadius provides radius,
    ) {
        MaterialTheme(
            colorScheme = colors.toColorScheme(darkTheme),
            typography = typography,
            content = content,
        )
    }
}
