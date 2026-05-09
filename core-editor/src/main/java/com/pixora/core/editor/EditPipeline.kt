package com.pixora.core.editor

import android.net.Uri

enum class EditOperationType { Curves, Hsl, Lut, AiErase, AiRelight, Heal, Grade, Blur, Overlay, Text, Sharpen, Perspective, Trim, Merge, Transition, AudioMix, Caption }

data class EditOperation(val type: EditOperationType, val intensity: Float = 1f, val parameters: Map<String, String> = emptyMap())

data class NonDestructiveEditGraph(val source: Uri? = null, val operations: List<EditOperation> = emptyList()) {
    fun append(operation: EditOperation) = copy(operations = operations + operation)
}

interface GpuRenderPipeline {
    fun preview(graph: NonDestructiveEditGraph): RenderPreview
    fun export(graph: NonDestructiveEditGraph, preset: ExportPreset): RenderJob
}

data class RenderPreview(val graph: NonDestructiveEditGraph, val realtime: Boolean)
data class RenderJob(val id: String, val graph: NonDestructiveEditGraph, val preset: ExportPreset)
data class ExportPreset(val name: String, val width: Int, val height: Int, val bitrateMbps: Int, val hdr: Boolean = false)

class OpenGlEditPipeline : GpuRenderPipeline {
    override fun preview(graph: NonDestructiveEditGraph) = RenderPreview(graph = graph, realtime = true)
    override fun export(graph: NonDestructiveEditGraph, preset: ExportPreset) = RenderJob(id = "render-${graph.operations.size}-${preset.name}", graph = graph, preset = preset)
}
