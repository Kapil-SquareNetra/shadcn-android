package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class SeparatorOrientation {
    Horizontal,
    Vertical,
}

@Composable
fun Separator(
    modifier: Modifier = Modifier,
    orientation: SeparatorOrientation = SeparatorOrientation.Horizontal,
    thickness: Dp = 1.dp,
) {
    val color = ShadcnTheme.colors.border
    when (orientation) {
        SeparatorOrientation.Horizontal -> {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(thickness)
                    .background(color),
            )
        }

        SeparatorOrientation.Vertical -> {
            Box(
                modifier = modifier
                    .fillMaxHeight()
                    .width(thickness)
                    .background(color),
            )
        }
    }
}
