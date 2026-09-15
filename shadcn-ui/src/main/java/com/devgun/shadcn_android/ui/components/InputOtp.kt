package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun InputOtp(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    length: Int = 6,
    enabled: Boolean = true,
) {
    val colors = ShadcnTheme.colors
    val radius = ShadcnTheme.radius
    val digits = value.filter { it.isDigit() }.take(length)

    BasicTextField(
        value = digits,
        onValueChange = { newValue ->
            onValueChange(newValue.filter { it.isDigit() }.take(length))
        },
        modifier = modifier,
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                repeat(length) { index ->
                    val char = digits.getOrNull(index)?.toString() ?: ""
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .border(1.dp, colors.input, radius.mdShape),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = char,
                            style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                            color = colors.foreground,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        },
    )
}
