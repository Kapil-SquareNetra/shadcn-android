package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.ContextMenu
import com.devgun.shadcn_android.ui.components.ContextMenuSurface
import com.devgun.shadcn_android.ui.components.DropdownMenuItem
import com.devgun.shadcn_android.ui.components.DropdownMenuItemVariant
import com.devgun.shadcn_android.ui.components.DropdownMenuLabel
import com.devgun.shadcn_android.ui.components.DropdownMenuSeparator
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun ContextMenuSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Context Menu", onBack = onBack) {
        SampleSection(title = "Long press") {
            ContextMenu(
                menu = {
                    DropdownMenuLabel("Actions")
                    DropdownMenuItem(text = "Back", onClick = {})
                    DropdownMenuItem(text = "Forward", onClick = {}, enabled = false)
                    DropdownMenuItem(text = "Reload", onClick = {})
                    DropdownMenuSeparator()
                    DropdownMenuItem(
                        text = "Delete",
                        onClick = {},
                        variant = DropdownMenuItemVariant.Destructive,
                    )
                },
            ) {
                ContextMenuSurface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                ) {
                    Text(
                        text = "Long press this area to open the menu.",
                        modifier = Modifier.padding(24.dp),
                        color = ShadcnTheme.colors.foreground,
                    )
                }
            }
        }
    }
}
