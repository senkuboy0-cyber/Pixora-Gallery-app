package com.pixora.core.branding

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.pixora.core.design.PixoraColors

@Composable
fun PixoraLogo(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "pixora-logo")
    val pulse by transition.animateFloat(initialValue = .7f, targetValue = 1f, animationSpec = infiniteRepeatable(tween(1800), RepeatMode.Reverse), label = "pulse")
    Canvas(modifier = modifier) {
        val stroke = size.minDimension * .09f
        val glow = Brush.radialGradient(listOf(PixoraColors.Aurora.copy(alpha = .55f * pulse), Color.Transparent), center = center, radius = size.minDimension * .7f)
        drawCircle(glow, radius = size.minDimension * .5f)
        drawArc(brush = Brush.sweepGradient(listOf(PixoraColors.Aurora, PixoraColors.Solar, PixoraColors.Plasma, PixoraColors.Aurora)), startAngle = -36f, sweepAngle = 296f, useCenter = false, topLeft = Offset(stroke, stroke), size = Size(size.width - stroke * 2, size.height - stroke * 2), style = Stroke(width = stroke, cap = StrokeCap.Round))
        drawCircle(color = PixoraColors.Ink, radius = size.minDimension * .16f)
        drawCircle(color = PixoraColors.Aurora, radius = size.minDimension * .06f, center = Offset(center.x + size.minDimension * .18f, center.y - size.minDimension * .12f))
    }
}
