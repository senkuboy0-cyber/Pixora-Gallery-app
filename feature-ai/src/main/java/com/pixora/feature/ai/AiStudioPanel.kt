package com.pixora.feature.ai

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
import com.pixora.core.ai.AiProviderId
import com.pixora.core.ui.GlassSurface
import com.pixora.core.ui.SectionTitle

@Composable
fun AiStudioPanel() {
    GlassSurface(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            SectionTitle("AI Studio")
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf(AiProviderId.Gemini, AiProviderId.OpenAi, AiProviderId.Claude, AiProviderId.OpenRouter).forEach { AssistChip(onClick = {}, label = { Text(it.name) }) }
            }
            Text("Prompt-driven edits produce real non-destructive operations for the GPU edit graph.")
        }
    }
}
