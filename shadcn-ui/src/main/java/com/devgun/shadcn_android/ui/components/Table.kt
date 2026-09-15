package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun Table(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    val colors = ShadcnTheme.colors
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(ShadcnTheme.radius.mdShape)
            .border(1.dp, colors.border, ShadcnTheme.radius.mdShape),
        content = content,
    )
}

@Composable
fun TableHeader(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(ShadcnTheme.colors.muted)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        content = content,
    )
}

@Composable
fun TableRow(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    onClick: (() -> Unit)? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val colors = ShadcnTheme.colors
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(if (selected) colors.accent else colors.background)
            .then(if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier)
            .padding(horizontal = 12.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        content = content,
    )
}

@Composable
fun RowScope.TableHead(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier.weight(1f),
        style = androidx.compose.material3.MaterialTheme.typography.labelMedium.copy(
            fontWeight = FontWeight.Medium,
            color = ShadcnTheme.colors.mutedForeground,
        ),
    )
}

@Composable
fun RowScope.TableCell(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier.weight(1f),
        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium.copy(
            color = ShadcnTheme.colors.foreground,
        ),
    )
}
