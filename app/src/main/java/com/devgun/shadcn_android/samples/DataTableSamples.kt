package com.devgun.shadcn_android.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.DataTable
import com.devgun.shadcn_android.ui.components.DataTableColumn
import com.devgun.shadcn_android.ui.components.SortDirection

@Composable
fun DataTableSamples(onBack: () -> Unit) {
    var selected by remember { mutableStateOf(setOf<String>()) }
    var sort by rememberSaveable { mutableStateOf("name") }
    var direction by rememberSaveable { mutableStateOf(SortDirection.Asc) }

    val columns = listOf(
        DataTableColumn("name", "Name", sortable = true),
        DataTableColumn("role", "Role"),
        DataTableColumn("email", "Email", sortable = true),
    )
    val rows = listOf(
        mapOf("name" to "Ada", "role" to "Admin", "email" to "ada@example.com"),
        mapOf("name" to "Lin", "role" to "Editor", "email" to "lin@example.com"),
        mapOf("name" to "Sam", "role" to "Viewer", "email" to "sam@example.com"),
    ).let { data ->
        val sorted = if (direction == SortDirection.Asc) {
            data.sortedBy { it[sort] }
        } else {
            data.sortedByDescending { it[sort] }
        }
        sorted
    }

    SampleScaffold(title = "Data Table", onBack = onBack) {
        SampleSection(title = "Sort and select") {
            DataTable(
                columns = columns,
                rows = rows,
                selectedKeys = selected,
                rowKey = { row, _ -> row.getValue("email") },
                onSelectionChange = { selected = it },
                sortColumnId = sort,
                sortDirection = direction,
                onSortChange = { columnId ->
                    if (sort == columnId) {
                        direction = if (direction == SortDirection.Asc) SortDirection.Desc else SortDirection.Asc
                    } else {
                        sort = columnId
                        direction = SortDirection.Asc
                    }
                },
            )
        }
    }
}
