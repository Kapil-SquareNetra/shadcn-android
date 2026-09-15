package com.devgun.shadcn_android.samples

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Button
import com.devgun.shadcn_android.ui.components.DatePicker
import com.devgun.shadcn_android.ui.theme.ShadcnTheme
import java.time.LocalDate

@Composable
fun DatePickerSamples(onBack: () -> Unit) {
    var open by rememberSaveable { mutableStateOf(false) }
    var epoch by rememberSaveable { mutableStateOf<Long?>(null) }
    val selected = epoch?.let(LocalDate::ofEpochDay)

    SampleScaffold(title = "Date Picker", onBack = onBack) {
        SampleSection(title = "Dialog") {
            Button(onClick = { open = true }) {
                Text(selected?.toString() ?: "Pick a date")
            }
            DatePicker(
                open = open,
                onDismissRequest = { open = false },
                selectedDate = selected,
                onDateChange = { epoch = it.toEpochDay() },
            )
            Text(
                text = selected?.toString() ?: "No date selected",
                color = ShadcnTheme.colors.mutedForeground,
            )
        }
    }
}
