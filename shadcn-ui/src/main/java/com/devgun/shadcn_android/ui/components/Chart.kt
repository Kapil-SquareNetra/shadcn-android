package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class ChartType {
    Bar,
    Line,
}

data class ChartPoint(
    val label: String,
    val value: Float,
    val color: Color? = null,
)

@Composable
fun Chart(
    points: List<ChartPoint>,
    modifier: Modifier = Modifier,
    type: ChartType = ChartType.Bar,
) {
    val colors = ShadcnTheme.colors
    val palette = listOf(colors.chart1, colors.chart2, colors.chart3, colors.chart4, colors.chart5)
    val maxValue = points.maxOfOrNull { it.value }?.takeIf { it > 0f } ?: 1f

    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
        ) {
            when (type) {
                ChartType.Bar -> {
                    val barWidth = size.width / (points.size * 2f).coerceAtLeast(1f)
                    points.forEachIndexed { index, point ->
                        val color = point.color ?: palette[index % palette.size]
                        val barHeight = (point.value / maxValue) * size.height
                        val x = (index * 2 + 0.5f) * barWidth
                        drawRoundRect(
                            color = color,
                            topLeft = Offset(x, size.height - barHeight),
                            size = Size(barWidth, barHeight),
                            cornerRadius = androidx.compose.ui.geometry.CornerRadius(8f, 8f),
                        )
                    }
                }

                ChartType.Line -> {
                    if (points.size < 2) return@Canvas
                    val path = Path()
                    points.forEachIndexed { index, point ->
                        val x = size.width * index / (points.size - 1)
                        val y = size.height - (point.value / maxValue) * size.height
                        if (index == 0) path.moveTo(x, y) else path.lineTo(x, y)
                    }
                    drawPath(
                        path = path,
                        color = colors.chart1,
                        style = Stroke(width = 6f, cap = StrokeCap.Round),
                    )
                    points.forEachIndexed { index, point ->
                        val x = size.width * index / (points.size - 1)
                        val y = size.height - (point.value / maxValue) * size.height
                        drawCircle(color = point.color ?: colors.chart1, radius = 8f, center = Offset(x, y))
                    }
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            points.forEach { point ->
                Text(
                    text = point.label,
                    style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                    color = colors.mutedForeground,
                )
            }
        }
    }
}

@Composable
fun ChartLegend(
    items: List<ChartPoint>,
    modifier: Modifier = Modifier,
) {
    val colors = ShadcnTheme.colors
    val palette = listOf(colors.chart1, colors.chart2, colors.chart3, colors.chart4, colors.chart5)
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items.forEachIndexed { index, point ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Canvas(modifier = Modifier.size(8.dp)) {
                    drawCircle(point.color ?: palette[index % palette.size])
                }
                Text(
                    text = point.label,
                    style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                    color = colors.foreground,
                    modifier = Modifier.padding(end = 4.dp),
                )
            }
        }
    }
}
