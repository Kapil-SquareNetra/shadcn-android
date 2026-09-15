package com.devgun.shadcn_android.samples

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.AlertDialog
import com.devgun.shadcn_android.ui.components.AlertDialogSize
import com.devgun.shadcn_android.ui.components.Button
import com.devgun.shadcn_android.ui.components.ButtonVariant
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun AlertDialogSamples(onBack: () -> Unit) {
    var basicOpen by rememberSaveable { mutableStateOf(false) }
    var smallOpen by rememberSaveable { mutableStateOf(false) }
    var destructiveOpen by rememberSaveable { mutableStateOf(false) }

    SampleScaffold(title = "Alert Dialog", onBack = onBack) {
        SampleSection(title = "Default") {
            Button(onClick = { basicOpen = true }, variant = ButtonVariant.Outline) {
                Text("Show dialog")
            }
            AlertDialog(
                open = basicOpen,
                onDismissRequest = { basicOpen = false },
                title = "Are you absolutely sure?",
                description = "This action cannot be undone. This will permanently delete your account.",
                confirmLabel = "Continue",
                onConfirm = { basicOpen = false },
            )
        }

        SampleSection(title = "Small") {
            Button(onClick = { smallOpen = true }, variant = ButtonVariant.Outline) {
                Text("Show small")
            }
            AlertDialog(
                open = smallOpen,
                onDismissRequest = { smallOpen = false },
                title = "Enable notifications",
                description = "Stay up to date with account activity.",
                confirmLabel = "Enable",
                onConfirm = { smallOpen = false },
                size = AlertDialogSize.Sm,
            )
        }

        SampleSection(title = "Destructive") {
            Button(onClick = { destructiveOpen = true }, variant = ButtonVariant.Destructive) {
                Text("Delete project")
            }
            AlertDialog(
                open = destructiveOpen,
                onDismissRequest = { destructiveOpen = false },
                title = "Delete project",
                description = "This will permanently remove the project and its files.",
                confirmLabel = "Delete",
                onConfirm = { destructiveOpen = false },
                confirmVariant = ButtonVariant.Destructive,
                icon = {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = ShadcnTheme.colors.destructive,
                    )
                },
            )
        }
    }
}
