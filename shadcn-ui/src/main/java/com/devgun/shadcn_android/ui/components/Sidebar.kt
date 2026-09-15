package com.devgun.shadcn_android.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

private val LocalSidebarExpanded = compositionLocalOf { true }

@Composable
fun SidebarLayout(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    sidebar: @Composable ColumnScope.() -> Unit,
    content: @Composable () -> Unit,
) {
    Row(modifier = modifier) {
        Sidebar(expanded = expanded, onExpandedChange = onExpandedChange, content = sidebar)
        Box(modifier = Modifier.weight(1f)) { content() }
    }
}

@Composable
fun Sidebar(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    val colors = ShadcnTheme.colors
    val width by animateDpAsState(if (expanded) 260.dp else 72.dp, label = "sidebarWidth")

    CompositionLocalProvider(LocalSidebarExpanded provides expanded) {
        Column(
            modifier = modifier
                .width(width)
                .fillMaxHeight()
                .background(colors.sidebar)
                .border(width = 1.dp, color = colors.sidebarBorder)
                .padding(12.dp),
        ) {
            SidebarTrigger(expanded = expanded, onClick = { onExpandedChange(!expanded) })
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                content = content,
            )
        }
    }
}

@Composable
fun SidebarTrigger(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        variant = ButtonVariant.Ghost,
        size = ButtonSize.Icon,
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = if (expanded) "Collapse sidebar" else "Expand sidebar",
        )
    }
}

@Composable
fun SidebarGroupLabel(
    text: String,
    modifier: Modifier = Modifier,
) {
    val expanded = LocalSidebarExpanded.current
    if (expanded) {
        Text(
            text = text,
            modifier = modifier.padding(horizontal = 8.dp, vertical = 8.dp),
            style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
            color = ShadcnTheme.colors.mutedForeground,
        )
    }
}

@Composable
fun SidebarMenuButton(
    selected: Boolean,
    onClick: () -> Unit,
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val colors = ShadcnTheme.colors
    val expanded = LocalSidebarExpanded.current
    val shape = ShadcnTheme.radius.mdShape
    val background = if (selected) colors.sidebarAccent else androidx.compose.ui.graphics.Color.Transparent
    val foreground = when {
        !enabled -> colors.mutedForeground
        selected -> colors.sidebarAccentForeground
        else -> colors.sidebarForeground
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(background, shape)
            .clickable(enabled = enabled, role = Role.Button, onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(imageVector = icon, contentDescription = if (expanded) null else label, tint = foreground)
        if (expanded) {
            Text(
                text = label,
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = if (selected) FontWeight.Medium else FontWeight.Normal,
                    color = foreground,
                ),
            )
        }
    }
}
