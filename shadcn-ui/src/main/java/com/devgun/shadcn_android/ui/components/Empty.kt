package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class EmptyVariant {
    Default,
    Outline,
}

enum class EmptyMediaVariant {
    Default,
    Icon,
}

@Composable
fun Empty(
    modifier: Modifier = Modifier,
    variant: EmptyVariant = EmptyVariant.Default,
    content: @Composable ColumnScope.() -> Unit,
) {
    val colors = ShadcnTheme.colors
    val shape = ShadcnTheme.radius.lgShape
    val outline = variant == EmptyVariant.Outline

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .then(
                if (outline) {
                    Modifier.border(1.dp, colors.border, shape)
                } else {
                    Modifier
                },
            )
            .padding(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        content = content,
    )
}

@Composable
fun EmptyHeader(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = content,
    )
}

@Composable
fun EmptyMedia(
    modifier: Modifier = Modifier,
    variant: EmptyMediaVariant = EmptyMediaVariant.Default,
    content: @Composable () -> Unit,
) {
    val colors = ShadcnTheme.colors
    val shape = ShadcnTheme.radius.mdShape
    val mediaModifier = when (variant) {
        EmptyMediaVariant.Icon -> modifier
            .size(40.dp)
            .clip(shape)
            .background(colors.muted, shape)
            .border(1.dp, colors.border, shape)
        EmptyMediaVariant.Default -> modifier
    }

    Box(
        modifier = mediaModifier,
        contentAlignment = Alignment.Center,
        content = { content() },
    )
}

@Composable
fun EmptyTitle(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = androidx.compose.material3.MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Medium,
            color = ShadcnTheme.colors.foreground,
        ),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun EmptyDescription(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = androidx.compose.material3.MaterialTheme.typography.bodySmall.copy(
            color = ShadcnTheme.colors.mutedForeground,
        ),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun EmptyContent(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = content,
    )
}
