package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun Dialog(
    open: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    showCloseButton: Boolean = true,
    content: @Composable ColumnScope.() -> Unit,
) {
    if (!open) return

    val colors = ShadcnTheme.colors
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = true),
    ) {
        Surface(
            modifier = modifier,
            shape = ShadcnTheme.radius.lgShape,
            color = colors.background,
            contentColor = colors.foreground,
            border = BorderStroke(1.dp, colors.border),
            tonalElevation = 0.dp,
            shadowElevation = 0.dp,
        ) {
            Box {
                Column(
                    modifier = Modifier.padding(
                        start = 24.dp,
                        top = 24.dp,
                        end = if (showCloseButton) 48.dp else 24.dp,
                        bottom = 24.dp,
                    ),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    content = content,
                )
                if (showCloseButton) {
                    IconButton(
                        onClick = onDismissRequest,
                        modifier = Modifier.align(Alignment.TopEnd),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = colors.mutedForeground,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DialogHeader(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        content = content,
    )
}

@Composable
fun DialogTitle(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = androidx.compose.material3.MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.SemiBold,
            color = ShadcnTheme.colors.foreground,
        ),
    )
}

@Composable
fun DialogDescription(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = androidx.compose.material3.MaterialTheme.typography.bodySmall.copy(
            color = ShadcnTheme.colors.mutedForeground,
        ),
    )
}

@Composable
fun DialogFooter(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End),
        verticalAlignment = Alignment.CenterVertically,
        content = content,
    )
}
