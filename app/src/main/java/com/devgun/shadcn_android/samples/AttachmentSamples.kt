package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Attachment

@Composable
fun AttachmentSamples(onBack: () -> Unit) {
    var showImage by rememberSaveable { mutableStateOf(true) }

    SampleScaffold(title = "Attachment", onBack = onBack) {
        SampleSection(title = "Files") {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Attachment(filename = "brief.pdf", meta = "240 KB", onClick = {})
                if (showImage) {
                    Attachment(
                        filename = "moodboard.png",
                        meta = "1.2 MB",
                        onRemove = { showImage = false },
                    )
                }
                Attachment(filename = "locked.zip", meta = "Unavailable", enabled = false)
            }
        }
    }
}
