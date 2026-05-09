package com.pixora.feature.player

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pixora.core.ui.GlassSurface
import com.pixora.core.ui.SectionTitle

@Composable
fun CinematicPlayerPanel() {
    val speed = remember { mutableFloatStateOf(1f) }
    GlassSurface(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            SectionTitle("Cinematic Player")
            Box(Modifier.fillMaxWidth().aspectRatio(16f / 9f).background(Brush.radialGradient(listOf(Color(0xFF1DFFB2), Color(0xFF05060A)))))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Button(onClick = {}) { Text("Play") }
                Button(onClick = {}) { Text("PiP") }
                Button(onClick = {}) { Text("Decoder") }
            }
            Text("Speed ${"%.2f".format(speed.floatValue)}x", color = MaterialTheme.colorScheme.onSurface)
            Slider(value = speed.floatValue, onValueChange = { speed.floatValue = it }, valueRange = .25f..2f)
        }
    }
}
