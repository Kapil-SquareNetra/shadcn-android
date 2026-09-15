package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Pagination(
    page: Int,
    pageCount: Int,
    onPageChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(
            onClick = { onPageChange(page - 1) },
            variant = ButtonVariant.Outline,
            size = ButtonSize.Icon,
            enabled = enabled && page > 1,
        ) {
            Icon(Icons.Default.ChevronLeft, contentDescription = "Previous")
        }

        visiblePages(page, pageCount).forEach { item ->
            if (item == null) {
                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = "More pages",
                    tint = com.devgun.shadcn_android.ui.theme.ShadcnTheme.colors.mutedForeground,
                )
            } else {
                val selected = item == page
                Button(
                    onClick = { onPageChange(item) },
                    variant = if (selected) ButtonVariant.Default else ButtonVariant.Outline,
                    size = ButtonSize.Icon,
                    enabled = enabled,
                ) {
                    Text(item.toString())
                }
            }
        }

        Button(
            onClick = { onPageChange(page + 1) },
            variant = ButtonVariant.Outline,
            size = ButtonSize.Icon,
            enabled = enabled && page < pageCount,
        ) {
            Icon(Icons.Default.ChevronRight, contentDescription = "Next")
        }
    }
}

internal fun visiblePages(page: Int, pageCount: Int): List<Int?> {
    if (pageCount <= 7) return (1..pageCount).toList()
    val pages = linkedSetOf(1, pageCount, page, (page - 1).coerceAtLeast(1), (page + 1).coerceAtMost(pageCount))
    val sorted = pages.sorted()
    val result = mutableListOf<Int?>()
    sorted.forEachIndexed { index, value ->
        if (index > 0 && value - sorted[index - 1] > 1) result.add(null)
        result.add(value)
    }
    return result
}
