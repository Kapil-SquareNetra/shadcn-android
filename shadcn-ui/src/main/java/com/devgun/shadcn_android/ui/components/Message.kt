package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class MessageRole {
    User,
    Assistant,
    System,
}

@Composable
fun Message(
    text: String,
    modifier: Modifier = Modifier,
    role: MessageRole = MessageRole.Assistant,
    name: String? = null,
    timestamp: String? = null,
    avatar: @Composable (() -> Unit)? = null,
    extra: @Composable (() -> Unit)? = null,
) {
    val colors = ShadcnTheme.colors
    val isUser = role == MessageRole.User
    val bubbleColor = when (role) {
        MessageRole.User -> colors.primary
        MessageRole.System -> colors.muted
        MessageRole.Assistant -> colors.secondary
    }
    val textColor = when (role) {
        MessageRole.User -> colors.primaryForeground
        else -> colors.foreground
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start,
        verticalAlignment = Alignment.Top,
    ) {
        if (!isUser && avatar != null) {
            avatar()
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .widthIn(max = 320.dp),
            horizontalAlignment = if (isUser) Alignment.End else Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            if (name != null || timestamp != null) {
                Text(
                    text = listOfNotNull(name, timestamp).joinToString(" · "),
                    style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                    color = colors.mutedForeground,
                )
            }
            Column(
                modifier = Modifier
                    .clip(ShadcnTheme.radius.lgShape)
                    .background(bubbleColor)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = text,
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    color = textColor,
                )
                extra?.invoke()
            }
        }
        if (isUser && avatar != null) {
            avatar()
        }
    }
}
