package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class SpinnerSize {
    Sm,
    Default,
    Lg,
}

@Composable
fun Spinner(
    modifier: Modifier = Modifier,
    size: SpinnerSize = SpinnerSize.Default,
    strokeWidth: Dp? = null,
) {
    val colors = ShadcnTheme.colors
    val indicatorSize = when (size) {
        SpinnerSize.Sm -> 16.dp
        SpinnerSize.Default -> 24.dp
        SpinnerSize.Lg -> 32.dp
    }
    val stroke = strokeWidth ?: when (size) {
        SpinnerSize.Sm -> 2.dp
        SpinnerSize.Default -> 2.5.dp
        SpinnerSize.Lg -> 3.dp
    }

    CircularProgressIndicator(
        modifier = modifier.size(indicatorSize),
        color = colors.primary,
        strokeWidth = stroke,
        trackColor = colors.muted,
        strokeCap = StrokeCap.Round,
    )
}
