package com.devgun.shadcn_android.ui.foundation

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

internal val shadcnTextFieldTextStyle: TextStyle
    @Composable
    get() = MaterialTheme.typography.bodyMedium.copy(
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.Both,
        ),
    )

@Composable
internal fun ShadcnTextFieldPlaceholder(text: String) {
    Text(
        text = text,
        modifier = Modifier.wrapContentHeight(align = Alignment.Top),
        style = shadcnTextFieldTextStyle,
        color = Color.Unspecified,
    )
}

@Composable
fun shadcnTextFieldColors(
    isError: Boolean = false,
): TextFieldColors {
    val colors = ShadcnTheme.colors
    return OutlinedTextFieldDefaults.colors(
        focusedTextColor = colors.foreground,
        unfocusedTextColor = colors.foreground,
        disabledTextColor = colors.mutedForeground,
        errorTextColor = colors.foreground,
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
        errorContainerColor = Color.Transparent,
        cursorColor = colors.primary,
        errorCursorColor = colors.destructive,
        selectionColors = TextSelectionColors(
            handleColor = colors.primary,
            backgroundColor = colors.primary.copy(alpha = 0.2f),
        ),
        focusedBorderColor = if (isError) colors.destructive else colors.ring,
        unfocusedBorderColor = if (isError) colors.destructive else colors.input,
        disabledBorderColor = colors.muted,
        errorBorderColor = colors.destructive,
        focusedLabelColor = colors.foreground,
        unfocusedLabelColor = colors.mutedForeground,
        disabledLabelColor = colors.mutedForeground,
        errorLabelColor = colors.destructive,
        focusedPlaceholderColor = colors.mutedForeground,
        unfocusedPlaceholderColor = colors.mutedForeground,
        disabledPlaceholderColor = colors.mutedForeground,
        errorPlaceholderColor = colors.mutedForeground,
    )
}

@Composable
fun shadcnCheckboxColors() = androidx.compose.material3.CheckboxDefaults.colors(
    checkedColor = colors.primary,
    uncheckedColor = colors.input,
    checkmarkColor = colors.primaryForeground,
    disabledCheckedColor = colors.muted,
    disabledUncheckedColor = colors.muted,
    disabledIndeterminateColor = colors.muted,
)

@Composable
fun shadcnSwitchColors() = androidx.compose.material3.SwitchDefaults.colors(
    checkedThumbColor = colors.background,
    checkedTrackColor = colors.primary,
    uncheckedThumbColor = colors.background,
    uncheckedTrackColor = colors.input,
    disabledCheckedThumbColor = colors.muted,
    disabledCheckedTrackColor = colors.muted,
    disabledUncheckedThumbColor = colors.muted,
    disabledUncheckedTrackColor = colors.muted,
)

@Composable
fun shadcnRadioColors() = androidx.compose.material3.RadioButtonDefaults.colors(
    selectedColor = colors.primary,
    unselectedColor = colors.input,
    disabledSelectedColor = colors.muted,
    disabledUnselectedColor = colors.muted,
)

@Composable
fun shadcnSliderColors() = androidx.compose.material3.SliderDefaults.colors(
    thumbColor = colors.background,
    activeTrackColor = colors.primary,
    inactiveTrackColor = colors.muted,
    disabledThumbColor = colors.muted,
    disabledActiveTrackColor = colors.muted,
    disabledInactiveTrackColor = colors.muted,
)

@Composable
fun shadcnProgressColor(): Color = ShadcnTheme.colors.primary

@Composable
fun shadcnProgressTrackColor(): Color = ShadcnTheme.colors.muted

private val colors
    @Composable get() = ShadcnTheme.colors
