package com.pixora.feature.editor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pixora.core.ui.GlassSurface
import com.pixora.core.ui.SectionTitle

@Composable
fun EditorConsole() {
    val tools = listOf("Curves", "HSL", "LUT", "AI Erase", "Relight", "Heal", "Sharpen", "Perspective", "Timeline", "Captions")
    GlassSurface(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            SectionTitle("Pro Editor")
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) { tools.take(5).forEach { AssistChip(onClick = {}, label = { Text(it) }) } }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) { tools.drop(5).forEach { AssistChip(onClick = {}, label = { Text(it) }) } }
        }
    }
}
