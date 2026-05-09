package com.pixora.feature.video

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pixora.core.ui.GlassSurface
import com.pixora.core.ui.SectionTitle

@Composable
fun VideoTimelinePanel() {
    GlassSurface(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            SectionTitle("Video Timeline")
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                repeat(6) { index -> Box(Modifier.weight(1f).height(54.dp).background(Brush.verticalGradient(listOf(Color(0xFF253046), Color(0xFF111827), Color(0xFF1DFFB2).copy(alpha = .22f + index * .03f))))) }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("Trim", "Merge", "LUT", "Captions", "Audio", "Export").forEach { AssistChip(onClick = {}, label = { Text(it) }) }
            }
        }
    }
}
