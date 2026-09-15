package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu as MaterialDropdownMenu
import androidx.compose.material3.DropdownMenuItem as MaterialDropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class DropdownMenuItemVariant {
    Default,
    Destructive,
}

@Composable
fun DropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    offset: DpOffset = DpOffset.Zero,
    content: @Composable androidx.compose.foundation.layout.ColumnScope.() -> Unit,
) {
    val colors = ShadcnTheme.colors
    MaterialDropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        offset = offset,
        shape = ShadcnTheme.radius.mdShape,
        containerColor = colors.popover,
        tonalElevation = 0.dp,
        shadowElevation = 4.dp,
        border = BorderStroke(1.dp, colors.border),
        content = content,
    )
}

@Composable
fun DropdownMenuItem(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    variant: DropdownMenuItemVariant = DropdownMenuItemVariant.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingText: String? = null,
) {
    val colors = ShadcnTheme.colors
    val contentColor = when {
        !enabled -> colors.mutedForeground
        variant == DropdownMenuItemVariant.Destructive -> colors.destructive
        else -> colors.popoverForeground
    }

    MaterialDropdownMenuItem(
        text = {
            Text(
                text = text,
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                color = contentColor,
            )
        },
        onClick = onClick,
        modifier = modifier,
        leadingIcon = leadingIcon,
        trailingIcon = trailingText?.let {
            {
                Text(
                    text = it,
                    style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                    color = colors.mutedForeground,
                )
            }
        },
        enabled = enabled,
        colors = MenuDefaults.itemColors(
            textColor = contentColor,
            leadingIconColor = contentColor,
            trailingIconColor = colors.mutedForeground,
            disabledTextColor = colors.mutedForeground,
            disabledLeadingIconColor = colors.mutedForeground,
            disabledTrailingIconColor = colors.mutedForeground,
        ),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
    )
}

@Composable
fun DropdownMenuCheckboxItem(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    DropdownMenuItem(
        text = text,
        onClick = { onCheckedChange(!checked) },
        modifier = modifier,
        enabled = enabled,
        leadingIcon = if (checked) {
            {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = ShadcnTheme.colors.popoverForeground,
                )
            }
        } else {
            null
        },
    )
}

@Composable
fun DropdownMenuLabel(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier.padding(horizontal = 12.dp, vertical = 8.dp),
        style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
        color = ShadcnTheme.colors.mutedForeground,
    )
}

@Composable
fun DropdownMenuSeparator(modifier: Modifier = Modifier) {
    HorizontalDivider(
        modifier = modifier,
        color = ShadcnTheme.colors.border,
        thickness = 1.dp,
    )
}
