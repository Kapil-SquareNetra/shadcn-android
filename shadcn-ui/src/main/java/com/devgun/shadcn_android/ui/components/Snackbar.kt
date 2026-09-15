package com.devgun.shadcn_android.ui.components

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost as MaterialSnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun SnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    val colors = ShadcnTheme.colors
    MaterialSnackbarHost(
        hostState = hostState,
        modifier = modifier,
            ) { data ->
        Snackbar(
            snackbarData = data,
            shape = ShadcnTheme.radius.mdShape,
            containerColor = colors.foreground,
            contentColor = colors.background,
            actionContentColor = colors.background,
            dismissActionContentColor = colors.background,
        )
    }
}
