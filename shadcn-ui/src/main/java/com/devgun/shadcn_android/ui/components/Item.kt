package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnColors
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class ItemVariant {
    Default,
    Outline,
    Muted,
}

enum class ItemSize {
    Default,
    Sm,
    Xs,
}

enum class ItemMediaVariant {
    Default,
    Icon,
    Image,
}

@Composable
fun ItemGroup(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        content = content,
    )
}

@Composable
fun ItemSeparator(modifier: Modifier = Modifier) {
    Separator(modifier = modifier.padding(vertical = 4.dp))
}

@Composable
fun Item(
    modifier: Modifier = Modifier,
    variant: ItemVariant = ItemVariant.Default,
    size: ItemSize = ItemSize.Default,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    val colors = ShadcnTheme.colors
    val shape = ShadcnTheme.radius.mdShape
    val background = itemBackground(variant, colors)
    val clickableModifier = if (onClick != null && enabled) {
        Modifier.clickable(onClick = onClick)
    } else {
        Modifier
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .then(
                if (variant == ItemVariant.Outline) {
                    Modifier.border(1.dp, colors.border, shape)
                } else {
                    Modifier
                },
            )
            .background(background, shape)
            .then(clickableModifier)
            .padding(itemPadding(size)),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = content,
    )
}

@Composable
fun ItemRow(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        content = content,
    )
}

@Composable
fun ItemHeader(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        content = content,
    )
}

@Composable
fun ItemMedia(
    modifier: Modifier = Modifier,
    variant: ItemMediaVariant = ItemMediaVariant.Default,
    content: @Composable () -> Unit,
) {
    val colors = ShadcnTheme.colors
    val shape = ShadcnTheme.radius.smShape
    val mediaModifier = when (variant) {
        ItemMediaVariant.Icon -> modifier
            .size(32.dp)
            .clip(shape)
            .background(colors.muted, shape)
            .border(1.dp, colors.border, shape)
        ItemMediaVariant.Image -> modifier.size(40.dp).clip(shape)
        ItemMediaVariant.Default -> modifier
    }

    Box(
        modifier = mediaModifier,
        contentAlignment = Alignment.Center,
        content = { content() },
    )
}

@Composable
fun RowScope.ItemContent(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier.weight(1f),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        content = content,
    )
}

@Composable
fun ItemTitle(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium.copy(
            fontWeight = FontWeight.Medium,
            color = ShadcnTheme.colors.foreground,
        ),
    )
}

@Composable
fun ItemDescription(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = androidx.compose.material3.MaterialTheme.typography.bodySmall.copy(
            color = ShadcnTheme.colors.mutedForeground,
        ),
    )
}

@Composable
fun ItemActions(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        content = content,
    )
}

@Composable
fun ItemFooter(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        content = content,
    )
}

private fun itemPadding(size: ItemSize): PaddingValues = when (size) {
    ItemSize.Default -> PaddingValues(horizontal = 16.dp, vertical = 12.dp)
    ItemSize.Sm -> PaddingValues(horizontal = 12.dp, vertical = 8.dp)
    ItemSize.Xs -> PaddingValues(horizontal = 10.dp, vertical = 6.dp)
}

private fun itemBackground(variant: ItemVariant, colors: ShadcnColors): Color {
    return when (variant) {
        ItemVariant.Default, ItemVariant.Outline -> Color.Transparent
        ItemVariant.Muted -> colors.muted
    }
}
