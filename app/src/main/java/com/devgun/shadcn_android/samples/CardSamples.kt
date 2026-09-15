package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Button
import com.devgun.shadcn_android.ui.components.ButtonVariant
import com.devgun.shadcn_android.ui.components.Card
import com.devgun.shadcn_android.ui.components.CardContent
import com.devgun.shadcn_android.ui.components.CardDescription
import com.devgun.shadcn_android.ui.components.CardFooter
import com.devgun.shadcn_android.ui.components.CardHeader
import com.devgun.shadcn_android.ui.components.CardSize
import com.devgun.shadcn_android.ui.components.CardTitle

@Composable
fun CardSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Card", onBack = onBack) {
        SampleSection(title = "Default") {
            Card(modifier = Modifier.fillMaxWidth()) {
                CardHeader {
                    CardTitle("Create project")
                    CardDescription("Deploy your new project in one click.")
                }
                CardContent {
                    Text("Add a name, choose a region, and start building.")
                }
                CardFooter {
                    Button(onClick = {}) { Text("Deploy") }
                    Button(onClick = {}, variant = ButtonVariant.Outline) { Text("Cancel") }
                }
            }
        }

        SampleSection(title = "Small size") {
            Card(modifier = Modifier.fillMaxWidth(), size = CardSize.Sm) {
                CardHeader(
                    action = {
                        Button(onClick = {}, variant = ButtonVariant.Ghost) { Text("Edit") }
                    },
                ) {
                    CardTitle("Scheduled reports")
                    CardDescription("Weekly snapshots. No more manual exports.")
                }
                CardContent {
                    Text("Choose a schedule, then send charts and key metrics to your team.")
                }
            }
        }

        SampleSection(title = "With header action") {
            Card(modifier = Modifier.fillMaxWidth()) {
                CardHeader(
                    action = {
                        Button(onClick = {}, variant = ButtonVariant.Outline) { Text("Share") }
                    },
                ) {
                    CardTitle("Team access")
                    CardDescription("Invite people to this workspace.")
                }
                CardContent {
                    Text("Members can view projects and comment on reviews.")
                }
            }
        }
    }
}
