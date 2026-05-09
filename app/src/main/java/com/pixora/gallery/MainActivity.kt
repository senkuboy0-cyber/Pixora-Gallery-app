package com.pixora.gallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pixora.core.branding.PixoraLogo
import com.pixora.core.design.PixoraTheme
import com.pixora.core.ui.AmbientStage
import com.pixora.feature.ai.AiStudioPanel
import com.pixora.feature.editor.EditorConsole
import com.pixora.feature.gallery.GalleryHome
import com.pixora.feature.player.CinematicPlayerPanel
import com.pixora.feature.settings.SettingsConsole
import com.pixora.feature.video.VideoTimelinePanel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { PixoraApp() }
    }
}

@Composable
private fun PixoraApp() {
    PixoraTheme {
        AmbientStage {
            Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(20.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) { PixoraLogo(Modifier.size(72.dp).padding(4.dp)) }
                GalleryHome()
                CinematicPlayerPanel()
                EditorConsole()
                VideoTimelinePanel()
                AiStudioPanel()
                SettingsConsole()
            }
        }
    }
}
