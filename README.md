# Pixora Gallery

Pixora Gallery is a futuristic AI-powered Android media ecosystem scaffolded as a production-grade Kotlin and Jetpack Compose project.

Repository: https://github.com/senkuboy0-cyber/Pixora-Gallery-app

## Current Implementation

- Kotlin + Jetpack Compose only UI surface.
- Clean multi-module architecture for app, core systems, and feature surfaces.
- Material 3 based cinematic design system with adaptive colors, depth tokens, glass surfaces, typography locals, and procedural Compose Canvas branding.
- Media domain models, Room database foundation, repository-ready module boundaries.
- Hybrid player abstraction with ExoPlayer implementation and LibVLC adapter seam.
- Non-destructive GPU edit graph contracts for photo and video editing operations.
- Modular AI provider architecture for Gemini, OpenAI, Claude, OpenRouter, Ollama, LM Studio, and custom endpoints.
- AI edit plans map prompts such as `Make this cinematic` into real editor graph operations instead of visual-only overlays.
- Advanced settings surface covering animation, typography, blur, AI provider, decoder, player, subtitle, cache, privacy, developer, experimental, and accessibility controls.
- Android TV entry support and TV module boundary.
- ABI splits for `arm64-v8a`, `armeabi-v7a`, `x86`, `x86_64`, plus universal APK.
- GitHub Actions for debug/release builds, artifact upload, automatic tags, and GitHub Releases using wildcard APK discovery.

## Build

```bash
chmod +x ./gradlew
./gradlew assembleDebug
./gradlew assembleRelease
```

The Gradle launcher downloads Gradle 8.10.2 on first use. CI uses Java 21 and Android SDK setup.

## Module Map

```text
app/
core/
core-ui/
core-motion/
core-player/
core-media/
core-ai/
core-network/
core-database/
core-editor/
core-design/
core-branding/
feature-gallery/
feature-player/
feature-video/
feature-editor/
feature-settings/
feature-ai/
feature-tv/
```

## Engineering Notes

Pixora is structured for incremental hardening: native LibVLC and FFmpeg binary adapters, MediaStore indexing, GPU shader rendering, real provider HTTP integrations, editor timelines, and signed release distribution can land behind the existing module boundaries without collapsing the architecture.
