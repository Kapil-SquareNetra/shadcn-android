package com.devgun.shadcn_android.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Field
import com.devgun.shadcn_android.ui.components.Input

@Composable
fun FieldSamples(onBack: () -> Unit) {
    var username by rememberSaveable { mutableStateOf("") }

    SampleScaffold(title = "Field", onBack = onBack) {
        SampleSection(title = "With description") {
            Field(
                label = "Username",
                required = true,
                description = "This is your public display name.",
            ) {
                Input(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = "shadcn",
                )
            }
        }

        SampleSection(title = "With error") {
            Field(
                label = "Email",
                required = true,
                error = "Please enter a valid email address.",
            ) {
                Input(
                    value = "invalid",
                    onValueChange = {},
                    isError = true,
                )
            }
        }
    }
}
