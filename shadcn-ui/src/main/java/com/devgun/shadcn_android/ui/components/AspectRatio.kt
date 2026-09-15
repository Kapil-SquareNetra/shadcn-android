package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AspectRatio(
    ratio: Float,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier.aspectRatio(ratio),
        content = { content() },
    )
}
