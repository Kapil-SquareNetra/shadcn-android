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
import com.devgun.shadcn_android.ui.components.Drawer
import com.devgun.shadcn_android.ui.components.DrawerDescription
import com.devgun.shadcn_android.ui.components.DrawerTitle
import com.devgun.shadcn_android.ui.components.Item
import com.devgun.shadcn_android.ui.components.ItemContent
import com.devgun.shadcn_android.ui.components.ItemRow
import com.devgun.shadcn_android.ui.components.ItemTitle
import com.devgun.shadcn_android.ui.components.Separator

@Composable
fun DrawerSamples(onBack: () -> Unit) {
    var open by rememberSaveable { mutableStateOf(false) }
    var gesturesEnabled by rememberSaveable { mutableStateOf(true) }

    Drawer(
        open = open,
        onOpenChange = { open = it },
        gesturesEnabled = gesturesEnabled,
        drawerContent = {
            DrawerTitle("Workspace")
            DrawerDescription("Switch destination or close the drawer.")
            Separator()
            Item(onClick = { open = false }) {
                ItemRow {
                    ItemContent { ItemTitle("Overview") }
                }
            }
            Item(onClick = { open = false }) {
                ItemRow {
                    ItemContent { ItemTitle("Projects") }
                }
            }
            Item(onClick = { open = false }) {
                ItemRow {
                    ItemContent { ItemTitle("Settings") }
                }
            }
        },
    ) {
        SampleScaffold(title = "Drawer", onBack = onBack) {
            SampleSection(title = "Open") {
                Button(onClick = { open = true }) { Text("Open drawer") }
            }
            SampleSection(title = "Gestures disabled") {
                Button(
                    onClick = { gesturesEnabled = !gesturesEnabled },
                    variant = ButtonVariant.Outline,
                ) {
                    Text(if (gesturesEnabled) "Disable edge swipe" else "Enable edge swipe")
                }
            }
        }
    }
}
