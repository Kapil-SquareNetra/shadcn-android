package com.devgun.shadcn_android.samples

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Carousel
import com.devgun.shadcn_android.ui.components.CarouselItem
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun CarouselSamples(onBack: () -> Unit) {
    val slides = listOf("Design systems", "Accessible chrome", "Token-driven charts")

    SampleScaffold(title = "Carousel", onBack = onBack) {
        SampleSection(title = "Paged") {
            Carousel(pageCount = slides.size) { page ->
                CarouselItem {
                    Text(slides[page], color = ShadcnTheme.colors.foreground)
                }
            }
        }
    }
}
