package com.devgun.shadcn_android.samples

import androidx.compose.runtime.Composable
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Chart
import com.devgun.shadcn_android.ui.components.ChartLegend
import com.devgun.shadcn_android.ui.components.ChartPoint
import com.devgun.shadcn_android.ui.components.ChartType

@Composable
fun ChartSamples(onBack: () -> Unit) {
    val points = listOf(
        ChartPoint("Jan", 186f),
        ChartPoint("Feb", 305f),
        ChartPoint("Mar", 237f),
        ChartPoint("Apr", 73f),
        ChartPoint("May", 209f),
        ChartPoint("Jun", 214f),
    )

    SampleScaffold(title = "Chart", onBack = onBack) {
        SampleSection(title = "Bar") {
            Chart(points = points, type = ChartType.Bar)
            ChartLegend(items = points.take(3))
        }
        SampleSection(title = "Line") {
            Chart(points = points, type = ChartType.Line)
        }
    }
}
