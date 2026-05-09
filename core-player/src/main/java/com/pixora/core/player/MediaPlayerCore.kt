package com.pixora.core.player

import android.content.Context
import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

enum class PixoraDecoder { ExoPlayer, LibVlc, MediaCodec }

data class PlaybackState(val uri: Uri? = null, val playing: Boolean = false, val speed: Float = 1f, val decoder: PixoraDecoder = PixoraDecoder.ExoPlayer, val subtitleStyle: SubtitleStyle = SubtitleStyle())

data class SubtitleStyle(val fontScale: Float = 1f, val backgroundOpacity: Float = .45f, val colorArgb: Long = 0xFFFFFFFF)

interface MediaPlayerCore {
    val state: StateFlow<PlaybackState>
    fun load(uri: Uri)
    fun play()
    fun pause()
    fun seekTo(positionMs: Long)
    fun setSpeed(speed: Float)
    fun switchDecoder(decoder: PixoraDecoder)
    fun release()
}

class ExoMediaPlayerCore(context: Context) : MediaPlayerCore {
    private val player = ExoPlayer.Builder(context).build()
    private val mutableState = MutableStateFlow(PlaybackState())
    override val state: StateFlow<PlaybackState> = mutableState
    override fun load(uri: Uri) { player.setMediaItem(MediaItem.fromUri(uri)); player.prepare(); mutableState.value = mutableState.value.copy(uri = uri, decoder = PixoraDecoder.ExoPlayer) }
    override fun play() { player.play(); mutableState.value = mutableState.value.copy(playing = true) }
    override fun pause() { player.pause(); mutableState.value = mutableState.value.copy(playing = false) }
    override fun seekTo(positionMs: Long) { player.seekTo(positionMs) }
    override fun setSpeed(speed: Float) { player.setPlaybackSpeed(speed); mutableState.value = mutableState.value.copy(speed = speed) }
    override fun switchDecoder(decoder: PixoraDecoder) { mutableState.value = mutableState.value.copy(decoder = decoder) }
    override fun release() { player.release() }
}

class VlcMediaPlayerCore : MediaPlayerCore {
    private val mutableState = MutableStateFlow(PlaybackState(decoder = PixoraDecoder.LibVlc))
    override val state: StateFlow<PlaybackState> = mutableState
    override fun load(uri: Uri) { mutableState.value = mutableState.value.copy(uri = uri, decoder = PixoraDecoder.LibVlc) }
    override fun play() { mutableState.value = mutableState.value.copy(playing = true) }
    override fun pause() { mutableState.value = mutableState.value.copy(playing = false) }
    override fun seekTo(positionMs: Long) = Unit
    override fun setSpeed(speed: Float) { mutableState.value = mutableState.value.copy(speed = speed) }
    override fun switchDecoder(decoder: PixoraDecoder) { mutableState.value = mutableState.value.copy(decoder = decoder) }
    override fun release() = Unit
}
