package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.foundation.shadcnRadioColors
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

data class RadioOption(
    val value: String,
    val label: String,
)

@Composable
fun RadioGroup(
    options: List<RadioOption>,
    selectedValue: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val colors = ShadcnTheme.colors
    Column(modifier = modifier.selectableGroup()) {
        options.forEach { option ->
            Row(
                modifier = Modifier
                    .selectable(
                        selected = selectedValue == option.value,
                        enabled = enabled,
                        role = Role.RadioButton,
                        onClick = { onValueChange(option.value) },
                    ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RadioButton(
                    selected = selectedValue == option.value,
                    onClick = null,
                    enabled = enabled,
                    colors = shadcnRadioColors(),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = option.label,
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    color = if (enabled) colors.foreground else colors.mutedForeground,
                )
            }
        }
    }
}
