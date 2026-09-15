package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

enum class ToggleGroupType {
    Single,
    Multiple,
}

@Composable
fun ToggleGroup(
    modifier: Modifier = Modifier,
    type: ToggleGroupType = ToggleGroupType.Single,
    content: @Composable () -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        content = { content() },
    )
}

@Composable
fun ToggleGroupItem(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    icon: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    variant: ToggleVariant = ToggleVariant.Default,
    size: ToggleSize = ToggleSize.Default,
) {
    Toggle(
        checked = checked,
        onCheckedChange = onCheckedChange,
        icon = icon,
        contentDescription = contentDescription,
        modifier = modifier,
        enabled = enabled,
        variant = variant,
        size = size,
    )
}
