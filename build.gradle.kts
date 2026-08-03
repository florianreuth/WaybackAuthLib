import de.florianreuth.baseproject.setupProject
import de.florianreuth.baseproject.setupPublishing

plugins {
    `java-library`
    id("de.florianreuth.baseproject")
}

setupProject()
setupPublishing()

repositories {
    maven("https://libraries.minecraft.net")
}

dependencies {
    compileOnly("com.mojang:authlib:5.0.47")
}
