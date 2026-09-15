package com.devgun.shadcn_android.samples

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Calendar
import com.devgun.shadcn_android.ui.components.CalendarMode
import com.devgun.shadcn_android.ui.components.CalendarRange
import com.devgun.shadcn_android.ui.theme.ShadcnTheme
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun CalendarSamples(onBack: () -> Unit) {
    var year by rememberSaveable { mutableIntStateOf(YearMonth.now().year) }
    var monthValue by rememberSaveable { mutableIntStateOf(YearMonth.now().monthValue) }
    var selectedEpoch by rememberSaveable { mutableStateOf(LocalDate.now().toEpochDay()) }
    var rangeStart by rememberSaveable { mutableStateOf<Long?>(null) }
    var rangeEnd by rememberSaveable { mutableStateOf<Long?>(null) }
    val month = YearMonth.of(year, monthValue)

    SampleScaffold(title = "Calendar", onBack = onBack) {
        SampleSection(title = "Single") {
            Calendar(
                month = month,
                onMonthChange = {
                    year = it.year
                    monthValue = it.monthValue
                },
                selectedDate = LocalDate.ofEpochDay(selectedEpoch),
                onDateSelected = { selectedEpoch = it.toEpochDay() },
            )
            Text(
                text = "Selected ${LocalDate.ofEpochDay(selectedEpoch)}",
                color = ShadcnTheme.colors.mutedForeground,
            )
        }
        SampleSection(title = "Range") {
            Calendar(
                month = month,
                onMonthChange = {
                    year = it.year
                    monthValue = it.monthValue
                },
                mode = CalendarMode.Range,
                selectedRange = CalendarRange(
                    start = rangeStart?.let(LocalDate::ofEpochDay),
                    end = rangeEnd?.let(LocalDate::ofEpochDay),
                ),
                onRangeChange = {
                    rangeStart = it.start?.toEpochDay()
                    rangeEnd = it.end?.toEpochDay()
                },
            )
        }
    }
}
