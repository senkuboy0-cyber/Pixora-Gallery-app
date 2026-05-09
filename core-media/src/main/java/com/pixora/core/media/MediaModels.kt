package com.pixora.core.media

import android.net.Uri

enum class MediaKind { Photo, Video, LivePhoto, RemoteStream }

data class MediaAsset(
    val id: String,
    val uri: Uri,
    val kind: MediaKind,
    val displayName: String,
    val mimeType: String,
    val durationMillis: Long? = null,
    val width: Int? = null,
    val height: Int? = null,
    val capturedAtMillis: Long? = null,
    val isHdr: Boolean = false,
)

data class MediaCluster(
    val title: String,
    val assets: List<MediaAsset>,
    val semanticTags: Set<String> = emptySet(),
)
