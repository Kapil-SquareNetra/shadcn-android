package com.devgun.shadcn_android.ui.components

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.devgun.shadcn_android.ui.theme.ShadcnTheme
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePicker(
    open: Boolean,
    onDismissRequest: () -> Unit,
    selectedDate: LocalDate?,
    onDateChange: (LocalDate) -> Unit,
    modifier: Modifier = Modifier,
    confirmLabel: String = "OK",
    dismissLabel: String = "Cancel",
) {
    if (!open) return

    val colors = ShadcnTheme.colors
    val state = rememberDatePickerState(
        initialSelectedDateMillis = selectedDate?.toEpochMillisUtc(),
    )

    DatePickerDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            Button(
                onClick = {
                    state.selectedDateMillis?.let { millis ->
                        onDateChange(millis.toLocalDateUtc())
                    }
                    onDismissRequest()
                },
            ) { Text(confirmLabel) }
        },
        modifier = modifier,
        dismissButton = {
            Button(onClick = onDismissRequest, variant = ButtonVariant.Outline) {
                Text(dismissLabel)
            }
        },
        colors = DatePickerDefaults.colors(
            containerColor = colors.background,
            titleContentColor = colors.foreground,
            headlineContentColor = colors.foreground,
            weekdayContentColor = colors.mutedForeground,
            subheadContentColor = colors.mutedForeground,
            yearContentColor = colors.foreground,
            currentYearContentColor = colors.primary,
            selectedYearContentColor = colors.primaryForeground,
            selectedYearContainerColor = colors.primary,
            dayContentColor = colors.foreground,
            selectedDayContentColor = colors.primaryForeground,
            selectedDayContainerColor = colors.primary,
            todayContentColor = colors.primary,
            todayDateBorderColor = colors.primary,
        ),
    ) {
        DatePicker(state = state)
    }
}

internal fun LocalDate.toEpochMillisUtc(): Long {
    return atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()
}

internal fun Long.toLocalDateUtc(): LocalDate {
    return Instant.ofEpochMilli(this).atZone(ZoneOffset.UTC).toLocalDate()
}
