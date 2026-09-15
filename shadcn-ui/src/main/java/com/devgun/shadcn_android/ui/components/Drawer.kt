package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun Drawer(
    open: Boolean,
    onOpenChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    gesturesEnabled: Boolean = true,
    drawerContent: @Composable ColumnScope.() -> Unit,
    content: @Composable () -> Unit,
) {
    val colors = ShadcnTheme.colors
    val drawerState = rememberDrawerState(
        initialValue = if (open) DrawerValue.Open else DrawerValue.Closed,
    )

    LaunchedEffect(open) {
        if (open && drawerState.isClosed) drawerState.open()
        if (!open && drawerState.isOpen) drawerState.close()
    }

    LaunchedEffect(drawerState.currentValue) {
        val isOpen = drawerState.currentValue == DrawerValue.Open
        if (isOpen != open) onOpenChange(isOpen)
    }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                modifier = modifier,
                drawerShape = ShadcnTheme.radius.lgShape,
                drawerContainerColor = colors.sidebar,
                drawerContentColor = colors.sidebarForeground,
                drawerTonalElevation = 0.dp,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    content = drawerContent,
                )
            }
        },
        modifier = Modifier,
        drawerState = drawerState,
        gesturesEnabled = gesturesEnabled,
        scrimColor = colors.foreground.copy(alpha = 0.4f),
        content = content,
    )
}

@Composable
fun DrawerTitle(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        style = androidx.compose.material3.MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.SemiBold,
            color = ShadcnTheme.colors.sidebarForeground,
        ),
    )
}

@Composable
fun DrawerDescription(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier.padding(horizontal = 8.dp),
        style = androidx.compose.material3.MaterialTheme.typography.bodySmall.copy(
            color = ShadcnTheme.colors.mutedForeground,
        ),
    )
}
