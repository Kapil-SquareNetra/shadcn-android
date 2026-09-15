package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.foundation.shadcnProgressColor
import com.devgun.shadcn_android.ui.foundation.shadcnProgressTrackColor

enum class ProgressVariant {
    Linear,
    Circular,
}

@Composable
fun Progress(
    modifier: Modifier = Modifier,
    variant: ProgressVariant = ProgressVariant.Linear,
    progress: Float? = null,
    size: Dp = 32.dp,
) {
    val color = shadcnProgressColor()
    val trackColor = shadcnProgressTrackColor()

    when (variant) {
        ProgressVariant.Linear -> {
            if (progress != null) {
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = modifier.fillMaxWidth(),
                    color = color,
                    trackColor = trackColor,
                    strokeCap = StrokeCap.Round,
                )
            } else {
                LinearProgressIndicator(
                    modifier = modifier.fillMaxWidth(),
                    color = color,
                    trackColor = trackColor,
                    strokeCap = StrokeCap.Round,
                )
            }
        }

        ProgressVariant.Circular -> {
            if (progress != null) {
                CircularProgressIndicator(
                    progress = { progress },
                    modifier = modifier.size(size),
                    color = color,
                    trackColor = trackColor,
                    strokeCap = StrokeCap.Round,
                )
            } else {
                CircularProgressIndicator(
                    modifier = modifier.size(size),
                    color = color,
                    trackColor = trackColor,
                    strokeCap = StrokeCap.Round,
                )
            }
        }
    }
}
