package com.devgun.shadcn_android.samples

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Input

@Composable
fun InputSamples(onBack: () -> Unit) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var disabled by rememberSaveable { mutableStateOf("Disabled value") }

    SampleScaffold(title = "Input", onBack = onBack) {
        SampleSection(title = "Default") {
            Input(
                value = email,
                onValueChange = { email = it },
                placeholder = "Email",
                label = "Email",
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
            )
        }

        SampleSection(title = "With trailing icon") {
            Input(
                value = password,
                onValueChange = { password = it },
                placeholder = "Password",
                label = "Password",
                trailingIcon = { Icon(Icons.Default.Visibility, contentDescription = null) },
            )
        }

        SampleSection(title = "Error") {
            Input(
                value = "",
                onValueChange = {},
                placeholder = "Required field",
                label = "Username",
                isError = true,
            )
        }

        SampleSection(title = "Disabled") {
            Input(
                value = disabled,
                onValueChange = { disabled = it },
                label = "Disabled",
                enabled = false,
            )
        }
    }
}
