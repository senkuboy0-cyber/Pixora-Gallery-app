package com.pixora.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pixora.core.design.LocalPixoraDepth
import com.pixora.core.design.PixoraColors

@Composable
fun AmbientStage(modifier: Modifier = Modifier, content: @Composable BoxScope.() -> Unit) {
    Box(modifier.fillMaxSize().background(Brush.linearGradient(listOf(PixoraColors.Void, Color(0xFF111827), Color(0xFF071F22))))) { content() }
}

@Composable
fun GlassSurface(modifier: Modifier = Modifier, content: @Composable BoxScope.() -> Unit) {
    val depth = LocalPixoraDepth.current
    Box(modifier.clip(RoundedCornerShape(8.dp)).background(MaterialTheme.colorScheme.surface.copy(alpha = depth.glassAlpha)).border(1.dp, Color.White.copy(alpha = .14f), RoundedCornerShape(8.dp)), content = content)
}

@Composable
fun SectionTitle(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = modifier, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onBackground)
}
