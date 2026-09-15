package com.devgun.shadcn_android.samples

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Alert
import com.devgun.shadcn_android.ui.components.AlertVariant
import com.devgun.shadcn_android.ui.components.Button
import com.devgun.shadcn_android.ui.components.ButtonSize
import com.devgun.shadcn_android.ui.components.ButtonVariant

@Composable
fun AlertSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Alert", onBack = onBack) {
        SampleSection(title = "Default") {
            Alert(
                title = "Account updated",
                description = "Your profile information has been saved.",
                icon = Icons.Default.CheckCircle,
            )
        }

        SampleSection(title = "Destructive") {
            Alert(
                title = "Payment failed",
                description = "Check your payment method and try again.",
                variant = AlertVariant.Destructive,
                icon = Icons.Default.Error,
            )
        }

        SampleSection(title = "With action") {
            Alert(
                title = "New feature available",
                description = "Dark mode can be enabled in settings.",
                icon = Icons.Default.Info,
                action = {
                    Button(
                        onClick = {},
                        variant = ButtonVariant.Outline,
                        size = ButtonSize.Sm,
                    ) {
                        Text("Enable")
                    }
                },
            )
        }
    }
}
