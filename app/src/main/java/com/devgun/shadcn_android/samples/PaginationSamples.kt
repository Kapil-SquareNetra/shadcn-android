package com.devgun.shadcn_android.samples

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Pagination
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun PaginationSamples(onBack: () -> Unit) {
    var page by rememberSaveable { mutableIntStateOf(5) }

    SampleScaffold(title = "Pagination", onBack = onBack) {
        SampleSection(title = "Many pages") {
            Pagination(page = page, pageCount = 12, onPageChange = { page = it })
            Text("Page $page of 12", color = ShadcnTheme.colors.mutedForeground)
        }
        SampleSection(title = "Few pages") {
            var small by rememberSaveable { mutableIntStateOf(1) }
            Pagination(page = small, pageCount = 4, onPageChange = { small = it })
        }
        SampleSection(title = "Disabled") {
            Pagination(page = 2, pageCount = 8, onPageChange = {}, enabled = false)
        }
    }
}
