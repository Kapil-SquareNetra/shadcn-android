package com.devgun.shadcn_android.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.semantics.Role
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

private data class CollapsibleController(
    val expanded: Boolean,
    val enabled: Boolean,
    val onExpandedChange: (Boolean) -> Unit,
)

private val LocalCollapsible = compositionLocalOf<CollapsibleController?> { null }

@Composable
fun Collapsible(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable ColumnScope.() -> Unit,
) {
    CompositionLocalProvider(
        LocalCollapsible provides CollapsibleController(
            expanded = expanded,
            enabled = enabled,
            onExpandedChange = onExpandedChange,
        ),
    ) {
        Column(modifier = modifier.fillMaxWidth(), content = content)
    }
}

@Composable
fun CollapsibleTrigger(
    modifier: Modifier = Modifier,
    showChevron: Boolean = true,
    content: @Composable RowScope.() -> Unit,
) {
    val controller = requireCollapsible()
    val rotation by animateFloatAsState(
        targetValue = if (controller.expanded) 180f else 0f,
        label = "collapsibleChevron",
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                enabled = controller.enabled,
                role = Role.Button,
                onClick = { controller.onExpandedChange(!controller.expanded) },
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            content = content,
        )
        if (showChevron) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = if (controller.expanded) "Collapse" else "Expand",
                modifier = Modifier.rotate(rotation),
                tint = if (controller.enabled) {
                    ShadcnTheme.colors.mutedForeground
                } else {
                    ShadcnTheme.colors.mutedForeground.copy(alpha = 0.5f)
                },
            )
        }
    }
}

@Composable
fun CollapsibleContent(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    val controller = requireCollapsible()
    AnimatedVisibility(
        visible = controller.expanded,
        enter = fadeIn() + expandVertically(),
        exit = fadeOut() + shrinkVertically(),
    ) {
        Column(modifier = modifier.fillMaxWidth(), content = content)
    }
}

@Composable
private fun requireCollapsible(): CollapsibleController {
    return checkNotNull(LocalCollapsible.current) {
        "CollapsibleTrigger and CollapsibleContent must be used inside Collapsible."
    }
}
