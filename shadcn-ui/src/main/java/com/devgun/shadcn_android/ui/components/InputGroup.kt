package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class InputGroupAddonPosition {
    Start,
    End,
}

@Composable
fun InputGroup(
    modifier: Modifier = Modifier,
    addon: String? = null,
    addonPosition: InputGroupAddonPosition = InputGroupAddonPosition.Start,
    content: @Composable () -> Unit,
) {
    val colors = ShadcnTheme.colors
    val radius = ShadcnTheme.radius
    val shape = radius.mdShape

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .border(1.dp, colors.input, shape),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (addon != null && addonPosition == InputGroupAddonPosition.Start) {
            InputGroupAddon(text = addon)
        }
        Box(modifier = Modifier.weight(1f)) {
            content()
        }
        if (addon != null && addonPosition == InputGroupAddonPosition.End) {
            InputGroupAddon(text = addon)
        }
    }
}

@Composable
private fun InputGroupAddon(text: String) {
    val colors = ShadcnTheme.colors
    Box(
        modifier = Modifier
            .background(colors.muted)
            .padding(horizontal = 12.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
            color = colors.mutedForeground,
        )
    }
}
