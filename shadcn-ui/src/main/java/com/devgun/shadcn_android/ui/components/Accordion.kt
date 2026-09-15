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
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

private data class AccordionController(
    val expandedValues: Set<String>,
    val onToggle: (String) -> Unit,
)

private data class AccordionItemController(
    val value: String,
    val expanded: Boolean,
    val enabled: Boolean,
    val onToggle: () -> Unit,
)

private val LocalAccordion = compositionLocalOf<AccordionController?> { null }
private val LocalAccordionItem = compositionLocalOf<AccordionItemController?> { null }

@Composable
fun Accordion(
    expandedValues: Set<String>,
    onExpandedChange: (Set<String>) -> Unit,
    modifier: Modifier = Modifier,
    multiple: Boolean = false,
    content: @Composable ColumnScope.() -> Unit,
) {
    val controller = AccordionController(
        expandedValues = expandedValues,
        onToggle = { value ->
            val isExpanded = value in expandedValues
            val next = when {
                multiple && isExpanded -> expandedValues - value
                multiple -> expandedValues + value
                isExpanded -> emptySet()
                else -> setOf(value)
            }
            onExpandedChange(next)
        },
    )

    CompositionLocalProvider(LocalAccordion provides controller) {
        Column(modifier = modifier.fillMaxWidth(), content = content)
    }
}

@Composable
fun AccordionItem(
    value: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable ColumnScope.() -> Unit,
) {
    val accordion = requireAccordion()
    val expanded = value in accordion.expandedValues
    val itemController = AccordionItemController(
        value = value,
        expanded = expanded,
        enabled = enabled,
        onToggle = { if (enabled) accordion.onToggle(value) },
    )

    CompositionLocalProvider(LocalAccordionItem provides itemController) {
        Column(modifier = modifier.fillMaxWidth()) {
            content()
            Separator()
        }
    }
}

@Composable
fun AccordionTrigger(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    val item = requireAccordionItem()
    val colors = ShadcnTheme.colors
    val rotation by animateFloatAsState(
        targetValue = if (item.expanded) 180f else 0f,
        label = "accordionChevron",
    )
    val contentColor = if (item.enabled) colors.foreground else colors.mutedForeground

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                enabled = item.enabled,
                role = Role.Button,
                onClick = item.onToggle,
            )
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            content = content,
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = if (item.expanded) "Collapse" else "Expand",
            modifier = Modifier.rotate(rotation),
            tint = contentColor,
        )
    }
}

@Composable
fun AccordionTrigger(
    text: String,
    modifier: Modifier = Modifier,
) {
    val item = requireAccordionItem()
    AccordionTrigger(modifier = modifier) {
        Text(
            text = text,
            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium,
                color = if (item.enabled) {
                    ShadcnTheme.colors.foreground
                } else {
                    ShadcnTheme.colors.mutedForeground
                },
            ),
        )
    }
}

@Composable
fun AccordionContent(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    val item = requireAccordionItem()
    AnimatedVisibility(
        visible = item.expanded,
        enter = fadeIn() + expandVertically(),
        exit = fadeOut() + shrinkVertically(),
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            content = content,
        )
    }
}

@Composable
private fun requireAccordion(): AccordionController {
    return checkNotNull(LocalAccordion.current) {
        "AccordionItem must be used inside Accordion."
    }
}

@Composable
private fun requireAccordionItem(): AccordionItemController {
    return checkNotNull(LocalAccordionItem.current) {
        "AccordionTrigger and AccordionContent must be used inside AccordionItem."
    }
}
