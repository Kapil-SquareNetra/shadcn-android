package com.devgun.shadcn_android.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class ShadcnRadius(
    val base: Dp,
    val sm: Dp,
    val md: Dp,
    val lg: Dp,
    val xl: Dp,
    val xl2: Dp,
    val xl3: Dp,
    val xl4: Dp,
) {
    val smShape = RoundedCornerShape(sm)
    val mdShape = RoundedCornerShape(md)
    val lgShape = RoundedCornerShape(lg)
    val xlShape = RoundedCornerShape(xl)
    val fullShape = RoundedCornerShape(999.dp)
}

val LocalShadcnRadius = staticCompositionLocalOf { defaultShadcnRadius }

val defaultShadcnRadius = ShadcnRadius(
    base = 10.dp,
    sm = 6.dp,
    md = 8.dp,
    lg = 10.dp,
    xl = 14.dp,
    xl2 = 18.dp,
    xl3 = 22.dp,
    xl4 = 26.dp,
)
