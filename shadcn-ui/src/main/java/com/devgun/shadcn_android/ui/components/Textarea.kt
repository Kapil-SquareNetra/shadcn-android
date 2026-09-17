package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.foundation.shadcnTextFieldTextStyle
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun Textarea(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    placeholder: String? = null,
    label: String? = null,
    isError: Boolean = false,
    minLines: Int = 3,
    maxLines: Int = 6,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource? = null,
) {
    val colors = ShadcnTheme.colors
    val radius = ShadcnTheme.radius
    val fallbackInteractionSource = remember { MutableInteractionSource() }
    val resolvedInteractionSource = interactionSource ?: fallbackInteractionSource
    val focused by resolvedInteractionSource.collectIsFocusedAsState()
    val textStyle = shadcnTextFieldTextStyle.copy(
        color = if (enabled) colors.foreground else colors.mutedForeground,
    )
    val borderColor = when {
        !enabled -> colors.muted
        isError -> colors.destructive
        focused -> colors.ring
        else -> colors.input
    }

    Column(modifier = modifier) {
        if (label != null) {
            Label(text = label)
            Spacer(modifier = Modifier.height(8.dp))
        }
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, borderColor, radius.mdShape)
                .padding(horizontal = 12.dp, vertical = 8.dp),
            enabled = enabled,
            readOnly = readOnly,
            textStyle = textStyle,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = false,
            minLines = minLines,
            maxLines = maxLines,
            interactionSource = resolvedInteractionSource,
            cursorBrush = SolidColor(if (isError) colors.destructive else colors.primary),
            decorationBox = { innerTextField ->
                Box {
                    if (value.isEmpty() && placeholder != null) {
                        Text(
                            text = placeholder,
                            style = textStyle.copy(color = colors.mutedForeground),
                        )
                    }
                    innerTextField()
                }
            },
        )
    }
}
