package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import com.devgun.shadcn_android.ui.foundation.ShadcnTextFieldPlaceholder
import com.devgun.shadcn_android.ui.foundation.shadcnTextFieldColors
import com.devgun.shadcn_android.ui.foundation.shadcnTextFieldTextStyle
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    placeholder: String? = null,
    label: String? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    showBorder: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    val radius = ShadcnTheme.radius
    val fieldColors = shadcnTextFieldColors(isError = isError)

    if (showBorder) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = shadcnTextFieldTextStyle,
            label = if (label != null) { { Text(label) } } else null,
            placeholder = if (placeholder != null) { { ShadcnTextFieldPlaceholder(placeholder) } } else null,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            interactionSource = interactionSource,
            shape = radius.mdShape,
            colors = fieldColors,
        )
    } else {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = shadcnTextFieldTextStyle,
            label = if (label != null) { { Text(label) } } else null,
            placeholder = if (placeholder != null) { { ShadcnTextFieldPlaceholder(placeholder) } } else null,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            interactionSource = interactionSource,
            shape = radius.mdShape,
            colors = fieldColors,
        )
    }
}
