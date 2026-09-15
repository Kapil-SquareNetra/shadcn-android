package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun Attachment(
    filename: String,
    modifier: Modifier = Modifier,
    meta: String? = null,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null,
    onRemove: (() -> Unit)? = null,
) {
    val colors = ShadcnTheme.colors
    val shape = ShadcnTheme.radius.mdShape

    Row(
        modifier = modifier
            .clip(shape)
            .border(1.dp, colors.border, shape)
            .background(colors.background, shape)
            .then(
                if (onClick != null && enabled) Modifier.clickable(onClick = onClick) else Modifier,
            )
            .padding(start = 12.dp, end = 4.dp, top = 8.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Default.AttachFile,
            contentDescription = null,
            tint = if (enabled) colors.foreground else colors.mutedForeground,
        )
        Text(
            text = if (meta != null) "$filename · $meta" else filename,
            style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
            color = if (enabled) colors.foreground else colors.mutedForeground,
        )
        if (onRemove != null) {
            IconButton(onClick = onRemove, enabled = enabled) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Remove attachment",
                    tint = colors.mutedForeground,
                )
            }
        }
    }
}
