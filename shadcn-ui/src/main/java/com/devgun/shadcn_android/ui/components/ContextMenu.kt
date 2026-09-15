package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpOffset
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun ContextMenu(
    modifier: Modifier = Modifier,
    menu: @Composable ColumnScope.() -> Unit,
    content: @Composable () -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    var offset by remember { mutableStateOf(DpOffset.Zero) }
    val density = LocalDensity.current

    Box(
        modifier = modifier.pointerInput(Unit) {
            detectTapGestures(
                onLongPress = { position ->
                    offset = with(density) {
                        DpOffset(position.x.toDp(), position.y.toDp())
                    }
                    expanded = true
                },
            )
        },
    ) {
        content()
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = offset,
            content = menu,
        )
    }
}

@Composable
fun ContextMenuSurface(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val colors = ShadcnTheme.colors
    Box(
        modifier = modifier.background(colors.muted, ShadcnTheme.radius.mdShape),
        content = { content() },
    )
}
