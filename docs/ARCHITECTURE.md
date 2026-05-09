# Pixora Gallery Architecture

Pixora uses a modular Clean Architecture layout with Compose-only feature modules and reusable core systems.

## Layers

- `app`: application shell, Hilt application, activity, feature composition.
- `feature-*`: user-facing Compose experiences.
- `core-design`: adaptive color, typography, spacing, depth, and theme locals.
- `core-motion`: cinematic spring and interpolation tokens.
- `core-branding`: procedural logo and future animated splash primitives.
- `core-media`: media domain models and future MediaStore/cloud sync contracts.
- `core-player`: `MediaPlayerCore` abstraction with ExoPlayer and LibVLC decoder slots.
- `core-editor`: non-destructive edit graph, GPU pipeline contracts, export presets.
- `core-ai`: provider abstraction and AI-to-editor operation planning.
- `core-database`: Room persistence for indexed media.
- `core-network`: Retrofit/OkHttp endpoint factory for AI and cloud integrations.

## Design Direction

The first screen is the product experience, not a marketing landing page. It uses layered dark stage lighting, glass panels, procedural branding, adaptive typography, and constrained 8dp surfaces for a premium Android media-console feel.

## Next Production Milestones

1. MediaStore scanner and predictive thumbnail cache.
2. Real LibVLC artifact adapter and network stream browser for SMB, FTP, WebDAV, RTSP, IPTV, HLS, and DASH.
3. OpenGL ES shader graph with LUT, curves, HSL, sharpen, blur, and relight passes.
4. FFmpeg/MediaCodec export worker with timeline, captions, audio mix, and ABI-tested native distribution.
5. Secure AI key storage, provider HTTP clients, model picker, and endpoint validation.
6. Signed Play-ready release pipeline with keystore injection and provenance.
