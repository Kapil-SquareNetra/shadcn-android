package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class ButtonGroupOrientation {
    Horizontal,
    Vertical,
}

@Composable
fun ButtonGroup(
    modifier: Modifier = Modifier,
    orientation: ButtonGroupOrientation = ButtonGroupOrientation.Horizontal,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(8.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(8.dp),
    content: @Composable () -> Unit,
) {
    when (orientation) {
        ButtonGroupOrientation.Horizontal -> {
            Row(
                modifier = modifier,
                horizontalArrangement = horizontalArrangement,
                verticalAlignment = Alignment.CenterVertically,
                content = { content() },
            )
        }

        ButtonGroupOrientation.Vertical -> {
            androidx.compose.foundation.layout.Column(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = verticalArrangement,
                horizontalAlignment = Alignment.Start,
                content = { content() },
            )
        }
    }
}
