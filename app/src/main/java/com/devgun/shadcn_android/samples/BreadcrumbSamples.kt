package com.devgun.shadcn_android.samples

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Breadcrumb
import com.devgun.shadcn_android.ui.components.BreadcrumbEntry
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun BreadcrumbSamples(onBack: () -> Unit) {
    var current by rememberSaveable { mutableStateOf("breadcrumb") }
    val items = listOf(
        BreadcrumbEntry("home", "Home"),
        BreadcrumbEntry("components", "Components"),
        BreadcrumbEntry("breadcrumb", "Breadcrumb"),
    )

    SampleScaffold(title = "Breadcrumb", onBack = onBack) {
        SampleSection(title = "Interactive") {
            Breadcrumb(items = items, currentId = current, onItemClick = { current = it })
            Text("Current: $current", color = ShadcnTheme.colors.mutedForeground)
        }
    }
}
