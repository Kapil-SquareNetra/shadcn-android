package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class ScrollAreaOrientation {
    Vertical,
    Horizontal,
    Both,
}

@Composable
fun ScrollArea(
    modifier: Modifier = Modifier,
    orientation: ScrollAreaOrientation = ScrollAreaOrientation.Vertical,
    content: @Composable ColumnScope.() -> Unit,
) {
    val vertical = rememberScrollState()
    val horizontal = rememberScrollState()
    val scrollModifier = when (orientation) {
        ScrollAreaOrientation.Vertical -> Modifier.verticalScroll(vertical)
        ScrollAreaOrientation.Horizontal -> Modifier.horizontalScroll(horizontal)
        ScrollAreaOrientation.Both -> Modifier
            .verticalScroll(vertical)
            .horizontalScroll(horizontal)
    }

    Box(modifier = modifier.clip(ShadcnTheme.radius.mdShape)) {
        Column(modifier = scrollModifier, content = content)
    }
}
