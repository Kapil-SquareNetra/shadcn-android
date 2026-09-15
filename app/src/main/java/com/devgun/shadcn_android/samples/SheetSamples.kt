package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Button
import com.devgun.shadcn_android.ui.components.ButtonVariant
import com.devgun.shadcn_android.ui.components.Sheet
import com.devgun.shadcn_android.ui.components.SheetDescription
import com.devgun.shadcn_android.ui.components.SheetFooter
import com.devgun.shadcn_android.ui.components.SheetHeader
import com.devgun.shadcn_android.ui.components.SheetSide
import com.devgun.shadcn_android.ui.components.SheetTitle

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SheetSamples(onBack: () -> Unit) {
    var side by rememberSaveable { mutableStateOf<SheetSide?>(null) }

    SampleScaffold(title = "Sheet", onBack = onBack) {
        SampleSection(title = "Side") {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(onClick = { side = SheetSide.Bottom }) { Text("Bottom") }
                Button(
                    onClick = { side = SheetSide.Start },
                    variant = ButtonVariant.Outline,
                ) { Text("Start") }
                Button(
                    onClick = { side = SheetSide.End },
                    variant = ButtonVariant.Outline,
                ) { Text("End") }
            }
        }

        Sheet(
            open = side != null,
            onDismissRequest = { side = null },
            side = side ?: SheetSide.Bottom,
        ) {
            SheetHeader {
                SheetTitle("Edit profile")
                SheetDescription("Changes apply to this workspace only.")
            }
            Text("Name, role, and notification preferences.")
            SheetFooter {
                Button(onClick = { side = null }, variant = ButtonVariant.Outline) {
                    Text("Cancel")
                }
                Button(onClick = { side = null }) { Text("Save") }
            }
        }
    }
}
