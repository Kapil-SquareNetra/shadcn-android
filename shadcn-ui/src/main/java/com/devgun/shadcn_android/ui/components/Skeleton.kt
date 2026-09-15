package com.devgun.shadcn_android.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun Skeleton(
    modifier: Modifier = Modifier,
    shape: Shape = ShadcnTheme.radius.mdShape,
) {
    val colors = ShadcnTheme.colors
    val transition = rememberInfiniteTransition(label = "skeleton")
    val alpha by transition.animateFloat(
        initialValue = 0.4f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "skeletonAlpha",
    )

    val brush = Brush.linearGradient(
        colors = listOf(
            colors.muted.copy(alpha = alpha),
            colors.accent.copy(alpha = alpha * 0.8f),
            colors.muted.copy(alpha = alpha),
        ),
        start = Offset.Zero,
        end = Offset(300f, 300f),
    )

    Box(
        modifier = modifier
            .clip(shape)
            .background(brush),
    )
}
