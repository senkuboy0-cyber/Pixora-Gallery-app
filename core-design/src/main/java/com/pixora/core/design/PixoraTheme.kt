package com.pixora.core.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class PixoraSpacing(val xs: Dp = 4.dp, val sm: Dp = 8.dp, val md: Dp = 16.dp, val lg: Dp = 24.dp, val xl: Dp = 32.dp, val xxl: Dp = 48.dp)

@Immutable
data class PixoraDepth(val glassAlpha: Float = .18f, val elevatedAlpha: Float = .28f, val blurRadius: Dp = 28.dp)

@Immutable
data class PixoraTypographyState(val selectedFont: PixoraFont = PixoraFont.System)

enum class PixoraFont(val label: String, val family: FontFamily) {
    System("Android System", FontFamily.Default),
    Inter("Inter", FontFamily.SansSerif),
    Poppins("Poppins", FontFamily.SansSerif),
    Manrope("Manrope", FontFamily.SansSerif),
    ProductSansAlt("Product Sans Alternative", FontFamily.SansSerif),
    SfProAlt("SF Pro Alternative", FontFamily.SansSerif),
}

val LocalPixoraSpacing = compositionLocalOf { PixoraSpacing() }
val LocalPixoraDepth = compositionLocalOf { PixoraDepth() }
val LocalPixoraTypography = compositionLocalOf { PixoraTypographyState() }

object PixoraColors {
    val Void = Color(0xFF05060A)
    val Ink = Color(0xFFEFF3FF)
    val Aurora = Color(0xFF2BE7C8)
    val Solar = Color(0xFFFFD66B)
    val Plasma = Color(0xFF6C63FF)
    val Signal = Color(0xFFFF4D8D)
}

private fun scheme(dark: Boolean): ColorScheme = if (dark) {
    darkColorScheme(primary = PixoraColors.Aurora, secondary = PixoraColors.Solar, tertiary = PixoraColors.Plasma, background = PixoraColors.Void, surface = Color(0xFF10131B), onPrimary = Color.Black, onBackground = PixoraColors.Ink, onSurface = PixoraColors.Ink)
} else {
    lightColorScheme(primary = Color(0xFF006B5F), secondary = Color(0xFF7A5600), tertiary = Color(0xFF5148D5), background = Color(0xFFF8FAFF), surface = Color.White, onBackground = Color(0xFF111318), onSurface = Color(0xFF111318))
}

@Composable
fun PixoraTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    typographyState: PixoraTypographyState = PixoraTypographyState(),
    content: @Composable () -> Unit,
) {
    val base = Typography()
    val family = typographyState.selectedFont.family
    val typography = base.copy(displayLarge = base.displayLarge.copy(fontFamily = family), headlineLarge = base.headlineLarge.copy(fontFamily = family), titleLarge = base.titleLarge.copy(fontFamily = family), bodyLarge = base.bodyLarge.copy(fontFamily = family), labelLarge = base.labelLarge.copy(fontFamily = family))
    CompositionLocalProvider(LocalPixoraSpacing provides PixoraSpacing(), LocalPixoraDepth provides PixoraDepth(), LocalPixoraTypography provides typographyState) {
        MaterialTheme(colorScheme = scheme(darkTheme), typography = typography, content = content)
    }
}
