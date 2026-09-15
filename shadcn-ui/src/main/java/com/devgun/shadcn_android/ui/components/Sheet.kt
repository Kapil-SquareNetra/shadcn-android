package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class SheetSide {
    Bottom,
    Start,
    End,
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sheet(
    open: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    side: SheetSide = SheetSide.Bottom,
    content: @Composable ColumnScope.() -> Unit,
) {
    if (!open) return

    val colors = ShadcnTheme.colors
    when (side) {
        SheetSide.Bottom -> {
            val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
            ModalBottomSheet(
                onDismissRequest = onDismissRequest,
                modifier = modifier,
                sheetState = sheetState,
                shape = RoundedCornerShape(
                    topStart = ShadcnTheme.radius.xl,
                    topEnd = ShadcnTheme.radius.xl,
                ),
                containerColor = colors.background,
                contentColor = colors.foreground,
                tonalElevation = 0.dp,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(bottom = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    content = content,
                )
            }
        }

        SheetSide.Start, SheetSide.End -> {
            SideSheet(
                onDismissRequest = onDismissRequest,
                side = side,
                modifier = modifier,
                content = content,
            )
        }
    }
}

@Composable
private fun SideSheet(
    onDismissRequest: () -> Unit,
    side: SheetSide,
    modifier: Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    val colors = ShadcnTheme.colors
    val alignment = if (side == SheetSide.Start) Alignment.CenterStart else Alignment.CenterEnd
    val shape = if (side == SheetSide.Start) {
        RoundedCornerShape(topEnd = ShadcnTheme.radius.xl, bottomEnd = ShadcnTheme.radius.xl)
    } else {
        RoundedCornerShape(topStart = ShadcnTheme.radius.xl, bottomStart = ShadcnTheme.radius.xl)
    }

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colors.foreground.copy(alpha = 0.4f))
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = onDismissRequest,
                    ),
            )
            Column(
                modifier = modifier
                    .align(alignment)
                    .fillMaxHeight()
                    .width(320.dp)
                    .clip(shape)
                    .background(colors.background)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {},
                    )
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                content = content,
            )
        }
    }
}

@Composable
fun SheetHeader(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        content = content,
    )
}

@Composable
fun SheetTitle(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = androidx.compose.material3.MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.SemiBold,
            color = ShadcnTheme.colors.foreground,
        ),
    )
}

@Composable
fun SheetDescription(
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
fun SheetFooter(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End),
        verticalAlignment = Alignment.CenterVertically,
        content = content,
    )
}
