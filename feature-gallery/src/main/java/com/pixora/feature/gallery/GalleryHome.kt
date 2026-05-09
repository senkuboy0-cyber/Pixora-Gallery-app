package com.pixora.feature.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pixora.core.design.PixoraColors
import com.pixora.core.ui.GlassSurface
import com.pixora.core.ui.SectionTitle

@Composable
fun GalleryHome() {
    val moments = listOf("Neon Nights", "HDR Portraits", "Travel Films", "RAW Selects", "AI Picks", "Cinematic Clips")
    GlassSurface(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                SectionTitle("Pixora Library")
                Text("AI clustered", color = PixoraColors.Aurora, style = MaterialTheme.typography.labelLarge)
            }
            LazyVerticalGrid(columns = GridCells.Adaptive(140.dp), modifier = Modifier.height(430.dp), horizontalArrangement = Arrangement.spacedBy(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(moments) { title ->
                    Box(Modifier.aspectRatio(.78f).background(Brush.linearGradient(listOf(Color(0xFF121826), Color(0xFF102C2F), Color(0xFF3B315F)))).padding(12.dp)) {
                        Text(title, color = Color.White, style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    }
}
