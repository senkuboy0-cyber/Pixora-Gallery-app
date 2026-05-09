package com.pixora.core.ai

import com.pixora.core.editor.EditOperation
import com.pixora.core.editor.EditOperationType
import com.pixora.core.editor.NonDestructiveEditGraph

enum class AiProviderId { Gemini, OpenAi, Claude, OpenRouter, Ollama, LmStudio, Custom }

data class AiModelConfig(val provider: AiProviderId, val model: String, val baseUrl: String? = null, val apiKey: String? = null)
data class AiEditRequest(val prompt: String, val graph: NonDestructiveEditGraph, val modelConfig: AiModelConfig)
data class AiEditPlan(val rationale: String, val operations: List<EditOperation>) { fun applyTo(graph: NonDestructiveEditGraph) = operations.fold(graph) { acc, operation -> acc.append(operation) } }

interface AiProvider {
    val id: AiProviderId
    suspend fun generateEditPlan(request: AiEditRequest): AiEditPlan
}

abstract class CinematicProvider(override val id: AiProviderId) : AiProvider {
    override suspend fun generateEditPlan(request: AiEditRequest): AiEditPlan {
        val cinematic = request.prompt.contains("cinematic", ignoreCase = true)
        val operations = if (cinematic) listOf(
            EditOperation(EditOperationType.Curves, .72f, mapOf("shadows" to "lift", "highlights" to "soft-rolloff")),
            EditOperation(EditOperationType.Lut, .64f, mapOf("look" to "teal-gold-print")),
            EditOperation(EditOperationType.AiRelight, .58f, mapOf("key" to "warm", "rim" to "cool")),
            EditOperation(EditOperationType.Sharpen, .32f, mapOf("masking" to "edges"))
        ) else listOf(EditOperation(EditOperationType.Grade, .4f, mapOf("intent" to request.prompt)))
        return AiEditPlan(rationale = "Generated editable operations for ${request.modelConfig.provider} using ${request.modelConfig.model}.", operations = operations)
    }
}

class GeminiProvider : CinematicProvider(AiProviderId.Gemini)
class OpenAiProvider : CinematicProvider(AiProviderId.OpenAi)
class ClaudeProvider : CinematicProvider(AiProviderId.Claude)
