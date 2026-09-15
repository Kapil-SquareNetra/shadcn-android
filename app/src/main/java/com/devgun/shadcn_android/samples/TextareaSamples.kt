package com.devgun.shadcn_android.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Textarea

@Composable
fun TextareaSamples(onBack: () -> Unit) {
    var message by rememberSaveable { mutableStateOf("") }
    var disabled by rememberSaveable { mutableStateOf("Read-only content") }

    SampleScaffold(title = "Textarea", onBack = onBack) {
        SampleSection(title = "Default") {
            Textarea(
                value = message,
                onValueChange = { message = it },
                label = "Message",
                placeholder = "Type your message here...",
            )
        }

        SampleSection(title = "Disabled") {
            Textarea(
                value = disabled,
                onValueChange = { disabled = it },
                label = "Notes",
                enabled = false,
            )
        }
    }
}
