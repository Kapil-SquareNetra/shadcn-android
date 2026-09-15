package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class AvatarSize {
    Sm,
    Default,
    Lg,
}

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    size: AvatarSize = AvatarSize.Default,
    painter: Painter? = null,
    fallback: String? = null,
    contentDescription: String? = null,
    borderColor: Color? = null,
) {
    val colors = ShadcnTheme.colors
    val dimension = avatarSize(size)
    val shape = CircleShape
    val borderModifier = if (borderColor != null) {
        Modifier.border(1.dp, borderColor, shape)
    } else {
        Modifier.border(1.dp, colors.border, shape)
    }

    Box(
        modifier = modifier
            .size(dimension)
            .clip(shape)
            .then(borderModifier)
            .background(colors.muted, shape),
        contentAlignment = Alignment.Center,
    ) {
        if (painter != null) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop,
            )
        } else if (!fallback.isNullOrBlank()) {
            Text(
                text = fallback.take(2).uppercase(),
                style = androidx.compose.material3.MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.Medium,
                    color = colors.mutedForeground,
                ),
            )
        }
    }
}

private fun avatarSize(size: AvatarSize): Dp = when (size) {
    AvatarSize.Sm -> 32.dp
    AvatarSize.Default -> 40.dp
    AvatarSize.Lg -> 48.dp
}
