pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PixoraGallery"

include(":app")
include(":core")
include(":core-ui")
include(":core-motion")
include(":core-player")
include(":core-media")
include(":core-ai")
include(":core-network")
include(":core-database")
include(":core-editor")
include(":core-design")
include(":core-branding")
include(":feature-gallery")
include(":feature-player")
include(":feature-video")
include(":feature-editor")
include(":feature-settings")
include(":feature-ai")
include(":feature-tv")
