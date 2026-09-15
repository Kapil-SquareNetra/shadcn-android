package com.devgun.shadcn_android.ui.foundation

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun Modifier.shadcnBorder(
    shape: Shape = RoundedCornerShape(ShadcnTheme.radius.md),
    color: Color = ShadcnTheme.colors.border,
    width: Dp = 1.dp,
): Modifier = border(width = width, color = color, shape = shape)

@Composable
fun Modifier.shadcnFocusRing(
    shape: Shape = RoundedCornerShape(ShadcnTheme.radius.md),
): Modifier = clip(shape)
