package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Attachment
import com.devgun.shadcn_android.ui.components.Avatar
import com.devgun.shadcn_android.ui.components.AvatarSize
import com.devgun.shadcn_android.ui.components.Message
import com.devgun.shadcn_android.ui.components.MessageRole

@Composable
fun MessageSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Message", onBack = onBack) {
        SampleSection(title = "Thread") {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Message(
                    text = "Can you summarize the latest invoice?",
                    role = MessageRole.User,
                    name = "You",
                    timestamp = "9:41 AM",
                    avatar = { Avatar(size = AvatarSize.Sm, fallback = "YO") },
                )
                Message(
                    text = "INV-002 is pending for $150.00. Want me to attach the PDF?",
                    role = MessageRole.Assistant,
                    name = "Assistant",
                    timestamp = "9:41 AM",
                    avatar = { Avatar(size = AvatarSize.Sm, fallback = "AI") },
                    extra = {
                        Attachment(filename = "invoice.pdf", meta = "128 KB")
                    },
                )
                Message(
                    text = "System: message delivery delayed.",
                    role = MessageRole.System,
                )
            }
        }
    }
}
