package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

data class BreadcrumbEntry(
    val id: String,
    val label: String,
)

@Composable
fun Breadcrumb(
    items: List<BreadcrumbEntry>,
    currentId: String,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = ShadcnTheme.colors
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items.forEachIndexed { index, item ->
            val isCurrent = item.id == currentId
            Text(
                text = item.label,
                modifier = if (isCurrent) {
                    Modifier
                } else {
                    Modifier.clickable(role = Role.Button) { onItemClick(item.id) }
                },
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = if (isCurrent) FontWeight.Medium else FontWeight.Normal,
                    color = if (isCurrent) colors.foreground else colors.mutedForeground,
                ),
            )
            if (index < items.lastIndex) {
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = null,
                    tint = colors.mutedForeground,
                )
            }
        }
    }
}
