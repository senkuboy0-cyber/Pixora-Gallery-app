package com.pixora.feature.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pixora.core.design.PixoraFont
import com.pixora.core.ui.GlassSurface
import com.pixora.core.ui.SectionTitle

@Composable
fun SettingsConsole() {
    val settings = listOf("Animation", "Typography", "Blur", "AI Providers", "Decoder", "Subtitles", "Cache", "Privacy", "Developer", "Experimental", "Accessibility")
    GlassSurface(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            SectionTitle("Control Deck")
            FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) { settings.forEach { FilterChip(selected = it == "Typography", onClick = {}, label = { Text(it) }) } }
            Text("Live font engine: ${PixoraFont.entries.joinToString { it.label }}")
        }
    }
}
