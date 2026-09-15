package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class AlertVariant {
    Default,
    Destructive,
}

@Composable
fun Alert(
    modifier: Modifier = Modifier,
    variant: AlertVariant = AlertVariant.Default,
    icon: @Composable (() -> Unit)? = null,
    action: @Composable (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    val colors = ShadcnTheme.colors
    val shape = ShadcnTheme.radius.lgShape
    val borderColor = if (variant == AlertVariant.Destructive) {
        colors.destructive.copy(alpha = 0.4f)
    } else {
        colors.border
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .border(1.dp, borderColor, shape)
            .padding(16.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.Top,
        ) {
            if (icon != null) {
                Box(modifier = Modifier.size(16.dp), contentAlignment = Alignment.Center) {
                    icon()
                }
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                content = content,
            )
            action?.invoke()
        }
    }
}

@Composable
fun Alert(
    title: String,
    modifier: Modifier = Modifier,
    variant: AlertVariant = AlertVariant.Default,
    description: String? = null,
    icon: ImageVector? = null,
    action: @Composable (() -> Unit)? = null,
) {
    val iconColor = alertForeground(variant)
    Alert(
        modifier = modifier,
        variant = variant,
        icon = icon?.let {
            {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    tint = iconColor,
                )
            }
        },
        action = action,
    ) {
        AlertTitle(text = title, variant = variant)
        if (description != null) {
            AlertDescription(text = description, variant = variant)
        }
    }
}

@Composable
fun AlertTitle(
    text: String,
    modifier: Modifier = Modifier,
    variant: AlertVariant = AlertVariant.Default,
) {
    Text(
        text = text,
        modifier = modifier,
        style = androidx.compose.material3.MaterialTheme.typography.titleSmall.copy(
            fontWeight = FontWeight.Medium,
            color = alertForeground(variant),
        ),
    )
}

@Composable
fun AlertDescription(
    text: String,
    modifier: Modifier = Modifier,
    variant: AlertVariant = AlertVariant.Default,
) {
    Text(
        text = text,
        modifier = modifier,
        style = androidx.compose.material3.MaterialTheme.typography.bodySmall.copy(
            color = if (variant == AlertVariant.Destructive) {
                ShadcnTheme.colors.destructive.copy(alpha = 0.8f)
            } else {
                ShadcnTheme.colors.mutedForeground
            },
        ),
    )
}

@Composable
private fun alertForeground(variant: AlertVariant): Color {
    val colors = ShadcnTheme.colors
    return if (variant == AlertVariant.Destructive) colors.destructive else colors.foreground
}
