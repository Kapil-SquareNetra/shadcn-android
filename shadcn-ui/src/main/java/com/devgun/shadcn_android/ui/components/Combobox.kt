package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.devgun.shadcn_android.ui.foundation.shadcnTextFieldColors
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Combobox(
    options: List<SelectOption>,
    selectedValue: String?,
    onValueChange: (String?) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholder: String = "Search...",
    emptyText: String = "No results",
) {
    val colors = ShadcnTheme.colors
    val radius = ShadcnTheme.radius
    var expanded by remember { mutableStateOf(false) }
    var query by remember(selectedValue) {
        mutableStateOf(options.find { it.value == selectedValue }?.label.orEmpty())
    }
    val filtered = options.filter { it.label.contains(query, ignoreCase = true) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { if (enabled) expanded = it },
        modifier = modifier,
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = {
                query = it
                expanded = true
                if (it.isEmpty()) onValueChange(null)
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(MenuAnchorType.PrimaryEditable),
            enabled = enabled,
            placeholder = { Text(placeholder) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            shape = radius.mdShape,
            colors = shadcnTextFieldColors(),
            singleLine = true,
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            containerColor = colors.popover,
        ) {
            if (filtered.isEmpty()) {
                DropdownMenuItem(
                    text = { Text(emptyText, color = colors.mutedForeground) },
                    onClick = {},
                    enabled = false,
                )
            } else {
                filtered.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option.label, color = colors.popoverForeground) },
                        onClick = {
                            onValueChange(option.value)
                            query = option.label
                            expanded = false
                        },
                    )
                }
            }
        }
    }
}
