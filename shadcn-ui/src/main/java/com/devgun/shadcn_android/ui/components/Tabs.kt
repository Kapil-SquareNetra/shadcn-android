package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class TabsVariant {
    Default,
    Line,
}

private data class TabsController(
    val selectedValue: String,
    val onValueChange: (String) -> Unit,
    val variant: TabsVariant,
)

private val LocalTabs = compositionLocalOf<TabsController?> { null }

@Composable
fun Tabs(
    selectedValue: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    variant: TabsVariant = TabsVariant.Default,
    content: @Composable ColumnScope.() -> Unit,
) {
    CompositionLocalProvider(
        LocalTabs provides TabsController(selectedValue, onValueChange, variant),
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            content = content,
        )
    }
}

@Composable
fun TabsList(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    val tabs = requireTabs()
    val colors = ShadcnTheme.colors
    val listModifier = if (tabs.variant == TabsVariant.Default) {
        modifier
            .clip(ShadcnTheme.radius.mdShape)
            .background(colors.muted)
            .padding(4.dp)
    } else {
        modifier.fillMaxWidth()
    }

    Row(
        modifier = listModifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        content = content,
    )
}

@Composable
fun TabsTrigger(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: ImageVector? = null,
) {
    val tabs = requireTabs()
    val colors = ShadcnTheme.colors
    val selected = tabs.selectedValue == value
    val shape = ShadcnTheme.radius.smShape
    val background = when {
        tabs.variant == TabsVariant.Default && selected -> colors.background
        else -> androidx.compose.ui.graphics.Color.Transparent
    }
    val foreground = when {
        !enabled -> colors.mutedForeground
        selected -> colors.foreground
        else -> colors.mutedForeground
    }

    Row(
        modifier = modifier
            .clip(shape)
            .background(background, shape)
            .clickable(enabled = enabled, role = Role.Tab) { tabs.onValueChange(value) }
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .then(
                if (tabs.variant == TabsVariant.Line && selected) {
                    Modifier.padding(bottom = 2.dp)
                } else {
                    Modifier
                },
            ),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (icon != null) {
            Icon(imageVector = icon, contentDescription = null, tint = foreground)
        }
        Text(
            text = label,
            style = androidx.compose.material3.MaterialTheme.typography.labelLarge.copy(
                fontWeight = if (selected) FontWeight.Medium else FontWeight.Normal,
                color = foreground,
            ),
        )
    }
}

@Composable
fun TabsContent(
    value: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val tabs = requireTabs()
    if (tabs.selectedValue == value) {
        Box(modifier = modifier.fillMaxWidth()) { content() }
    }
}

@Composable
private fun requireTabs(): TabsController {
    return checkNotNull(LocalTabs.current) {
        "TabsList, TabsTrigger, and TabsContent must be used inside Tabs."
    }
}
