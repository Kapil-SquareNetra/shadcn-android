package com.devgun.shadcn_android.samples

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Avatar
import com.devgun.shadcn_android.ui.components.Button
import com.devgun.shadcn_android.ui.components.ButtonSize
import com.devgun.shadcn_android.ui.components.ButtonVariant
import com.devgun.shadcn_android.ui.components.Item
import com.devgun.shadcn_android.ui.components.ItemActions
import com.devgun.shadcn_android.ui.components.ItemContent
import com.devgun.shadcn_android.ui.components.ItemDescription
import com.devgun.shadcn_android.ui.components.ItemGroup
import com.devgun.shadcn_android.ui.components.ItemHeader
import com.devgun.shadcn_android.ui.components.ItemMedia
import com.devgun.shadcn_android.ui.components.ItemMediaVariant
import com.devgun.shadcn_android.ui.components.ItemRow
import com.devgun.shadcn_android.ui.components.ItemSeparator
import com.devgun.shadcn_android.ui.components.ItemSize
import com.devgun.shadcn_android.ui.components.ItemTitle
import com.devgun.shadcn_android.ui.components.ItemVariant
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun ItemSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Item", onBack = onBack) {
        SampleSection(title = "Variants") {
            ItemGroup {
                Item {
                    ItemRow {
                        ItemContent {
                            ItemTitle("Default")
                            ItemDescription("Transparent background with no border.")
                        }
                    }
                }
                Item(variant = ItemVariant.Outline) {
                    ItemRow {
                        ItemContent {
                            ItemTitle("Outline")
                            ItemDescription("Outlined style with a visible border.")
                        }
                    }
                }
                Item(variant = ItemVariant.Muted) {
                    ItemRow {
                        ItemContent {
                            ItemTitle("Muted")
                            ItemDescription("Muted background for secondary content.")
                        }
                    }
                }
            }
        }

        SampleSection(title = "Sizes") {
            ItemGroup {
                Item(variant = ItemVariant.Outline, size = ItemSize.Default) {
                    ItemRow {
                        ItemContent {
                            ItemTitle("Default size")
                            ItemDescription("The standard size for most use cases.")
                        }
                    }
                }
                Item(variant = ItemVariant.Outline, size = ItemSize.Sm) {
                    ItemRow {
                        ItemContent {
                            ItemTitle("Small size")
                            ItemDescription("A compact size for dense layouts.")
                        }
                    }
                }
                Item(variant = ItemVariant.Outline, size = ItemSize.Xs) {
                    ItemRow {
                        ItemContent {
                            ItemTitle("Extra small")
                            ItemDescription("The most compact size available.")
                        }
                    }
                }
            }
        }

        SampleSection(title = "With media and actions") {
            Item(variant = ItemVariant.Outline, onClick = {}) {
                ItemRow {
                    ItemMedia(variant = ItemMediaVariant.Icon) {
                        Icon(
                            imageVector = Icons.Default.Inbox,
                            contentDescription = null,
                            tint = ShadcnTheme.colors.foreground,
                        )
                    }
                    ItemContent {
                        ItemTitle("Inbox")
                        ItemDescription("New login detected from an unknown device.")
                    }
                    ItemActions {
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "Open",
                            tint = ShadcnTheme.colors.mutedForeground,
                        )
                    }
                }
            }
        }

        SampleSection(title = "Avatar") {
            Item(variant = ItemVariant.Outline) {
                ItemRow {
                    ItemMedia(variant = ItemMediaVariant.Default) {
                        Avatar(fallback = "ER")
                    }
                    ItemContent {
                        ItemTitle("Evil Rabbit")
                        ItemDescription("Last seen 5 months ago")
                    }
                    ItemActions {
                        Button(
                            onClick = {},
                            variant = ButtonVariant.Outline,
                            size = ButtonSize.Sm,
                        ) {
                            Text("Invite")
                        }
                    }
                }
            }
        }

        SampleSection(title = "Group with header") {
            ItemGroup {
                Item(variant = ItemVariant.Outline) {
                    ItemHeader {
                        ItemTitle("v0-2.0-mini")
                    }
                    ItemRow {
                        ItemContent {
                            ItemDescription("Open source model for everyday tasks.")
                        }
                    }
                }
                ItemSeparator()
                Item(variant = ItemVariant.Outline, enabled = false) {
                    ItemRow {
                        ItemContent {
                            ItemTitle("Disabled item")
                            ItemDescription("This row is not interactive.")
                        }
                    }
                }
            }
        }
    }
}
