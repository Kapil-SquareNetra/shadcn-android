package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

data class DataTableColumn(
    val id: String,
    val header: String,
    val sortable: Boolean = false,
)

enum class SortDirection {
    Asc,
    Desc,
}

@Composable
fun DataTable(
    columns: List<DataTableColumn>,
    rows: List<Map<String, String>>,
    modifier: Modifier = Modifier,
    selectedKeys: Set<String> = emptySet(),
    rowKey: (Map<String, String>, Int) -> String = { _, index -> index.toString() },
    onSelectionChange: ((Set<String>) -> Unit)? = null,
    sortColumnId: String? = null,
    sortDirection: SortDirection = SortDirection.Asc,
    onSortChange: ((String) -> Unit)? = null,
) {
    val selectable = onSelectionChange != null
    val allKeys = rows.mapIndexed { index, row -> rowKey(row, index) }.toSet()
    val allSelected = allKeys.isNotEmpty() && selectedKeys.containsAll(allKeys)

    Table(modifier = modifier) {
        TableHeader {
            if (selectable) {
                Checkbox(
                    checked = allSelected,
                    onCheckedChange = { checked ->
                        onSelectionChange.invoke(if (checked) allKeys else emptySet())
                    },
                )
            }
            columns.forEach { column ->
                SortableHead(
                    column = column,
                    sortColumnId = sortColumnId,
                    sortDirection = sortDirection,
                    onSortChange = onSortChange,
                )
            }
        }
        rows.forEachIndexed { index, row ->
            val key = rowKey(row, index)
            TableRow(
                selected = key in selectedKeys,
                onClick = if (selectable) {
                    {
                        val next = if (key in selectedKeys) selectedKeys - key else selectedKeys + key
                        onSelectionChange.invoke(next)
                    }
                } else {
                    null
                },
            ) {
                if (selectable) {
                    Checkbox(
                        checked = key in selectedKeys,
                        onCheckedChange = { checked ->
                            val next = if (checked) selectedKeys + key else selectedKeys - key
                            onSelectionChange.invoke(next)
                        },
                    )
                }
                columns.forEach { column ->
                    TableCell(text = row[column.id].orEmpty())
                }
            }
        }
    }
}

@Composable
private fun RowScope.SortableHead(
    column: DataTableColumn,
    sortColumnId: String?,
    sortDirection: SortDirection,
    onSortChange: ((String) -> Unit)?,
) {
    if (column.sortable && onSortChange != null) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.CenterStart,
        ) {
            Button(
                onClick = { onSortChange(column.id) },
                variant = ButtonVariant.Ghost,
                size = ButtonSize.Sm,
            ) {
                androidx.compose.material3.Text(column.header)
                if (sortColumnId == column.id) {
                    Icon(
                        imageVector = if (sortDirection == SortDirection.Asc) {
                            Icons.Default.ArrowUpward
                        } else {
                            Icons.Default.ArrowDownward
                        },
                        contentDescription = null,
                        modifier = Modifier.size(14.dp),
                        tint = ShadcnTheme.colors.mutedForeground,
                    )
                }
            }
        }
    } else {
        TableHead(text = column.header)
    }
}
