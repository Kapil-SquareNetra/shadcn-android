package com.devgun.shadcn_android.samples

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Tabs
import com.devgun.shadcn_android.ui.components.TabsContent
import com.devgun.shadcn_android.ui.components.TabsList
import com.devgun.shadcn_android.ui.components.TabsTrigger
import com.devgun.shadcn_android.ui.components.TabsVariant
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun TabsSamples(onBack: () -> Unit) {
    var defaultTab by rememberSaveable { mutableStateOf("account") }
    var lineTab by rememberSaveable { mutableStateOf("overview") }

    SampleScaffold(title = "Tabs", onBack = onBack) {
        SampleSection(title = "Default") {
            Tabs(selectedValue = defaultTab, onValueChange = { defaultTab = it }) {
                TabsList {
                    TabsTrigger(value = "account", label = "Account")
                    TabsTrigger(value = "password", label = "Password")
                    TabsTrigger(value = "disabled", label = "Disabled", enabled = false)
                }
                TabsContent("account") {
                    Text("Make changes to your account here.", color = ShadcnTheme.colors.mutedForeground)
                }
                TabsContent("password") {
                    Text("Change your password here.", color = ShadcnTheme.colors.mutedForeground)
                }
            }
        }

        SampleSection(title = "Line with icons") {
            Tabs(
                selectedValue = lineTab,
                onValueChange = { lineTab = it },
                variant = TabsVariant.Line,
            ) {
                TabsList {
                    TabsTrigger(value = "overview", label = "Overview", icon = Icons.Default.Home)
                    TabsTrigger(value = "analytics", label = "Analytics", icon = Icons.Default.BarChart)
                }
                TabsContent("overview") {
                    Text("12 active projects.", color = ShadcnTheme.colors.foreground)
                }
                TabsContent("analytics") {
                    Text("Traffic is up 18% this week.", color = ShadcnTheme.colors.foreground)
                }
            }
        }
    }
}
