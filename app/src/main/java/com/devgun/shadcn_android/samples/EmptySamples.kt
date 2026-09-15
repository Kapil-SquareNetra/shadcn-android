package com.devgun.shadcn_android.samples

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Button
import com.devgun.shadcn_android.ui.components.Empty
import com.devgun.shadcn_android.ui.components.EmptyContent
import com.devgun.shadcn_android.ui.components.EmptyDescription
import com.devgun.shadcn_android.ui.components.EmptyHeader
import com.devgun.shadcn_android.ui.components.EmptyMedia
import com.devgun.shadcn_android.ui.components.EmptyMediaVariant
import com.devgun.shadcn_android.ui.components.EmptyTitle
import com.devgun.shadcn_android.ui.components.EmptyVariant
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun EmptySamples(onBack: () -> Unit) {
    SampleScaffold(title = "Empty", onBack = onBack) {
        SampleSection(title = "Default") {
            Empty {
                EmptyHeader {
                    EmptyMedia(variant = EmptyMediaVariant.Icon) {
                        Icon(
                            imageVector = Icons.Default.Folder,
                            contentDescription = null,
                            tint = ShadcnTheme.colors.foreground,
                        )
                    }
                    EmptyTitle("No projects yet")
                    EmptyDescription("Create your first project to get started.")
                }
                EmptyContent {
                    Button(onClick = {}) { Text("Create project") }
                }
            }
        }

        SampleSection(title = "Outline") {
            Empty(variant = EmptyVariant.Outline) {
                EmptyHeader {
                    EmptyMedia(variant = EmptyMediaVariant.Icon) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = null,
                            tint = ShadcnTheme.colors.foreground,
                        )
                    }
                    EmptyTitle("No notifications")
                    EmptyDescription("You're all caught up. New alerts will show up here.")
                }
            }
        }
    }
}
