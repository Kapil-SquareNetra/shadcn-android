package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class ToggleVariant {
    Default,
    Outline,
}

enum class ToggleSize {
    Default,
    Sm,
    Lg,
}

@Composable
fun Toggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    icon: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    variant: ToggleVariant = ToggleVariant.Default,
    size: ToggleSize = ToggleSize.Default,
    interactionSource: MutableInteractionSource? = null,
) {
    val colors = ShadcnTheme.colors
    val toggleColors = when (variant) {
        ToggleVariant.Default -> IconToggleButtonColors(
            containerColor = Color.Transparent,
            contentColor = colors.foreground,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = colors.mutedForeground,
            checkedContainerColor = colors.accent,
            checkedContentColor = colors.accentForeground,
        )
        ToggleVariant.Outline -> IconToggleButtonColors(
            containerColor = Color.Transparent,
            contentColor = colors.foreground,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = colors.mutedForeground,
            checkedContainerColor = colors.background,
            checkedContentColor = colors.foreground,
        )
    }

    IconToggleButton(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        colors = toggleColors,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
        )
    }
}
