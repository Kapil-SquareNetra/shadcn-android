package com.devgun.shadcn_android.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.InputOtp

@Composable
fun InputOtpSamples(onBack: () -> Unit) {
    var otp by rememberSaveable { mutableStateOf("") }

    SampleScaffold(title = "Input OTP", onBack = onBack) {
        SampleSection(title = "6-digit code") {
            InputOtp(
                value = otp,
                onValueChange = { otp = it },
                length = 6,
            )
        }

        SampleSection(title = "Disabled") {
            InputOtp(
                value = "123456",
                onValueChange = {},
                length = 6,
                enabled = false,
            )
        }
    }
}
