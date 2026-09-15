package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Avatar
import com.devgun.shadcn_android.ui.components.AvatarSize

@Composable
fun AvatarSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Avatar", onBack = onBack) {
        SampleSection(title = "Sizes") {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Avatar(size = AvatarSize.Sm, fallback = "SM")
                Avatar(fallback = "JD")
                Avatar(size = AvatarSize.Lg, fallback = "LG")
            }
        }

        SampleSection(title = "Fallback Initials") {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Avatar(fallback = "AB")
                Avatar(fallback = "XY")
                Avatar(fallback = "K")
            }
        }
    }
}
