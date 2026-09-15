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
import com.devgun.shadcn_android.ui.components.ButtonVariant
import com.devgun.shadcn_android.ui.components.Dialog
import com.devgun.shadcn_android.ui.components.DialogDescription
import com.devgun.shadcn_android.ui.components.DialogFooter
import com.devgun.shadcn_android.ui.components.DialogHeader
import com.devgun.shadcn_android.ui.components.DialogTitle
import com.devgun.shadcn_android.ui.components.Input
import com.devgun.shadcn_android.ui.components.Label

@Composable
fun DialogSamples(onBack: () -> Unit) {
    var basicOpen by rememberSaveable { mutableStateOf(false) }
    var formOpen by rememberSaveable { mutableStateOf(false) }
    var noCloseOpen by rememberSaveable { mutableStateOf(false) }
    var name by rememberSaveable { mutableStateOf("") }

    SampleScaffold(title = "Dialog", onBack = onBack) {
        SampleSection(title = "Default") {
            Button(onClick = { basicOpen = true }) { Text("Open dialog") }
            Dialog(open = basicOpen, onDismissRequest = { basicOpen = false }) {
                DialogHeader {
                    DialogTitle("Edit profile")
                    DialogDescription("Make changes to your profile. Click save when you are done.")
                }
                DialogFooter {
                    Button(onClick = { basicOpen = false }, variant = ButtonVariant.Outline) {
                        Text("Cancel")
                    }
                    Button(onClick = { basicOpen = false }) { Text("Save") }
                }
            }
        }

        SampleSection(title = "With form") {
            Button(onClick = { formOpen = true }, variant = ButtonVariant.Outline) {
                Text("Open form dialog")
            }
            Dialog(open = formOpen, onDismissRequest = { formOpen = false }) {
                DialogHeader {
                    DialogTitle("Share project")
                    DialogDescription("Anyone with the link can view this project.")
                }
                Label("Name")
                Input(value = name, onValueChange = { name = it }, placeholder = "Acme Inc")
                DialogFooter {
                    Button(onClick = { formOpen = false }) { Text("Copy link") }
                }
            }
        }

        SampleSection(title = "Without close button") {
            Button(onClick = { noCloseOpen = true }, variant = ButtonVariant.Secondary) {
                Text("Open")
            }
            Dialog(
                open = noCloseOpen,
                onDismissRequest = { noCloseOpen = false },
                showCloseButton = false,
            ) {
                DialogHeader {
                    DialogTitle("Continue setup")
                    DialogDescription("Finish onboarding to start using the workspace.")
                }
                DialogFooter {
                    Button(onClick = { noCloseOpen = false }) { Text("Continue") }
                }
            }
        }
    }
}
