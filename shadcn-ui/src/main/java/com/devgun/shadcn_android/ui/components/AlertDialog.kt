package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
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

enum class AlertDialogSize {
    Default,
    Sm,
}

@Composable
fun AlertDialog(
    open: Boolean,
    onDismissRequest: () -> Unit,
    title: String,
    description: String,
    confirmLabel: String,
    onConfirm: () -> Unit,
    modifier: Modifier = Modifier,
    dismissLabel: String? = "Cancel",
    confirmVariant: ButtonVariant = ButtonVariant.Default,
    size: AlertDialogSize = AlertDialogSize.Default,
    icon: @Composable (() -> Unit)? = null,
) {
    AlertDialog(
        open = open,
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        size = size,
    ) {
        AlertDialogHeader(icon = icon) {
            AlertDialogTitle(title)
            AlertDialogDescription(description)
        }
        AlertDialogFooter {
            if (dismissLabel != null) {
                Button(onClick = onDismissRequest, variant = ButtonVariant.Outline) {
                    Text(dismissLabel)
                }
            }
            Button(onClick = onConfirm, variant = confirmVariant) {
                Text(confirmLabel)
            }
        }
    }
}

@Composable
fun AlertDialog(
    open: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    size: AlertDialogSize = AlertDialogSize.Default,
    content: @Composable ColumnScope.() -> Unit,
) {
    if (!open) return

    val colors = ShadcnTheme.colors
    val padding = if (size == AlertDialogSize.Sm) 16.dp else 24.dp
    val maxWidth = if (size == AlertDialogSize.Sm) 320.dp else 420.dp

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Surface(
            modifier = modifier.widthIn(max = maxWidth),
            shape = ShadcnTheme.radius.lgShape,
            color = colors.background,
            contentColor = colors.foreground,
            border = BorderStroke(1.dp, colors.border),
            tonalElevation = 0.dp,
            shadowElevation = 0.dp,
        ) {
            Column(
                modifier = Modifier.padding(padding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                content = content,
            )
        }
    }
}

@Composable
fun AlertDialogHeader(
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = if (icon != null) Alignment.CenterHorizontally else Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        icon?.invoke()
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalAlignment = if (icon != null) Alignment.CenterHorizontally else Alignment.Start,
            content = content,
        )
    }
}

@Composable
fun AlertDialogTitle(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = androidx.compose.material3.MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.SemiBold,
            color = ShadcnTheme.colors.foreground,
        ),
    )
}

@Composable
fun AlertDialogDescription(
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
fun AlertDialogFooter(
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
