package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
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
import com.devgun.shadcn_android.ui.components.DropdownMenu
import com.devgun.shadcn_android.ui.components.DropdownMenuCheckboxItem
import com.devgun.shadcn_android.ui.components.DropdownMenuItem
import com.devgun.shadcn_android.ui.components.DropdownMenuItemVariant
import com.devgun.shadcn_android.ui.components.DropdownMenuLabel
import com.devgun.shadcn_android.ui.components.DropdownMenuSeparator

@Composable
fun DropdownMenuSamples(onBack: () -> Unit) {
    var basicOpen by rememberSaveable { mutableStateOf(false) }
    var checkboxOpen by rememberSaveable { mutableStateOf(false) }
    var statusBar by rememberSaveable { mutableStateOf(true) }
    var panel by rememberSaveable { mutableStateOf(false) }

    SampleScaffold(title = "Dropdown Menu", onBack = onBack) {
        SampleSection(title = "Basic") {
            Box {
                Button(onClick = { basicOpen = true }, variant = ButtonVariant.Outline) {
                    Text("Open")
                }
                DropdownMenu(expanded = basicOpen, onDismissRequest = { basicOpen = false }) {
                    DropdownMenuLabel("My Account")
                    DropdownMenuItem(
                        text = "Profile",
                        onClick = { basicOpen = false },
                        leadingIcon = {
                            Icon(Icons.Default.Person, contentDescription = null)
                        },
                    )
                    DropdownMenuItem(text = "Billing", onClick = { basicOpen = false })
                    DropdownMenuSeparator()
                    DropdownMenuItem(
                        text = "Log out",
                        onClick = { basicOpen = false },
                        trailingText = "⇧⌘Q",
                    )
                    DropdownMenuItem(
                        text = "Delete",
                        onClick = { basicOpen = false },
                        variant = DropdownMenuItemVariant.Destructive,
                    )
                    DropdownMenuItem(
                        text = "Disabled",
                        onClick = {},
                        enabled = false,
                    )
                }
            }
        }

        SampleSection(title = "Checkboxes") {
            Box {
                Button(onClick = { checkboxOpen = true }) { Text("View") }
                DropdownMenu(
                    expanded = checkboxOpen,
                    onDismissRequest = { checkboxOpen = false },
                ) {
                    DropdownMenuLabel("Appearance")
                    DropdownMenuCheckboxItem(
                        text = "Status Bar",
                        checked = statusBar,
                        onCheckedChange = { statusBar = it },
                    )
                    DropdownMenuCheckboxItem(
                        text = "Panel",
                        checked = panel,
                        onCheckedChange = { panel = it },
                    )
                }
            }
        }
    }
}
