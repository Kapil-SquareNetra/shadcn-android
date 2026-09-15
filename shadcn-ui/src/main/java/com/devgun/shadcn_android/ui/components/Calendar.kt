package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

enum class CalendarMode {
    Single,
    Range,
}

data class CalendarRange(
    val start: LocalDate? = null,
    val end: LocalDate? = null,
)

@Composable
fun Calendar(
    month: YearMonth,
    onMonthChange: (YearMonth) -> Unit,
    modifier: Modifier = Modifier,
    selectedDate: LocalDate? = null,
    onDateSelected: ((LocalDate) -> Unit)? = null,
    mode: CalendarMode = CalendarMode.Single,
    selectedRange: CalendarRange = CalendarRange(),
    onRangeChange: ((CalendarRange) -> Unit)? = null,
) {
    val colors = ShadcnTheme.colors
    val locale = Locale.getDefault()
    val days = calendarDays(month)

    Column(
        modifier = modifier
            .clip(ShadcnTheme.radius.lgShape)
            .border(1.dp, colors.border, ShadcnTheme.radius.lgShape)
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                onClick = { onMonthChange(month.minusMonths(1)) },
                variant = ButtonVariant.Ghost,
                size = ButtonSize.Icon,
            ) {
                Icon(Icons.Default.ChevronLeft, contentDescription = "Previous month")
            }
            Text(
                text = "${month.month.getDisplayName(TextStyle.FULL, locale)} ${month.year}",
                style = androidx.compose.material3.MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Medium,
                    color = colors.foreground,
                ),
            )
            Button(
                onClick = { onMonthChange(month.plusMonths(1)) },
                variant = ButtonVariant.Ghost,
                size = ButtonSize.Icon,
            ) {
                Icon(Icons.Default.ChevronRight, contentDescription = "Next month")
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            (0..6).map { DayOfWeek.SUNDAY.plus(it.toLong()) }.forEach { day ->
                Text(
                    text = day.getDisplayName(TextStyle.SHORT, locale).take(2),
                    modifier = Modifier.weight(1f),
                    style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                    color = colors.mutedForeground,
                    textAlign = TextAlign.Center,
                )
            }
        }

        days.chunked(7).forEach { week ->
            Row(modifier = Modifier.fillMaxWidth()) {
                week.forEach { date ->
                    val inMonth = YearMonth.from(date) == month
                    val selected = when (mode) {
                        CalendarMode.Single -> date == selectedDate
                        CalendarMode.Range -> date == selectedRange.start || date == selectedRange.end
                    }
                    val inRange = mode == CalendarMode.Range &&
                        selectedRange.start != null &&
                        selectedRange.end != null &&
                        !date.isBefore(selectedRange.start) &&
                        !date.isAfter(selectedRange.end)

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .padding(2.dp)
                            .clip(ShadcnTheme.radius.smShape)
                            .background(
                                when {
                                    selected -> colors.primary
                                    inRange -> colors.accent
                                    else -> androidx.compose.ui.graphics.Color.Transparent
                                },
                            )
                            .clickable(role = Role.Button) {
                                when (mode) {
                                    CalendarMode.Single -> onDateSelected?.invoke(date)
                                    CalendarMode.Range -> onRangeChange?.invoke(nextRange(selectedRange, date))
                                }
                            },
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = date.dayOfMonth.toString(),
                            style = androidx.compose.material3.MaterialTheme.typography.bodySmall.copy(
                                color = when {
                                    selected -> colors.primaryForeground
                                    !inMonth -> colors.mutedForeground
                                    else -> colors.foreground
                                },
                            ),
                        )
                    }
                }
            }
        }
    }
}

private fun calendarDays(month: YearMonth): List<LocalDate> {
    val first = month.atDay(1)
    val startOffset = first.dayOfWeek.value % 7
    val gridStart = first.minusDays(startOffset.toLong())
    return (0 until 42).map { gridStart.plusDays(it.toLong()) }
}

private fun nextRange(current: CalendarRange, date: LocalDate): CalendarRange {
    val start = current.start
    val end = current.end
    return when {
        start == null || end != null -> CalendarRange(start = date, end = null)
        date.isBefore(start) -> CalendarRange(start = date, end = start)
        else -> CalendarRange(start = start, end = date)
    }
}
