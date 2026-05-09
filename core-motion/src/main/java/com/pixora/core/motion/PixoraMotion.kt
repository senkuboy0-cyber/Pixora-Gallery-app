package com.pixora.core.motion

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween

object PixoraMotion {
    val CinematicEase = CubicBezierEasing(.16f, 1f, .3f, 1f)
    fun <T> flagshipSpring() = spring<T>(dampingRatio = .78f, stiffness = Spring.StiffnessMediumLow)
    fun atmosphericTween(durationMillis: Int = 620) = tween<Float>(durationMillis = durationMillis, easing = CinematicEase)
}
