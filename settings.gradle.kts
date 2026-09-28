pluginManagement {
    includeBuild("build-logic")
}

plugins {
    id("base.settings")
}

dependencyResolutionManagement {
    repositories {
        maven("https://libraries.minecraft.net")
    }
}

rootProject.name = "waybackauthlib"
