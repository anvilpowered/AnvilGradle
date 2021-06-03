import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("com.gradle.plugin-publish").version("0.14.0")
  `java-gradle-plugin`
  val kotlinVersion = "1.5.10"
  kotlin("jvm").version(kotlinVersion)
}

group = "org.anvilpowered"
version = "0.1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(gradleKotlinDsl())
}

tasks {
  withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
  }
}

gradlePlugin {
  plugins {
    create("anvilgradle") {
      id = "org.anvilpowered.anvilgradle"
      displayName = "AnvilGradle"
      implementationClass = "org.anvilpowered.anvilgradle.AnvilGradlePlugin"
    }
  }
}

pluginBundle {
  website = "https://anvilpowered.org"
  vcsUrl = "https://github.com/AnvilPowered/AnvilGradle"
  mavenCoordinates {
    groupId = project.group.toString()
    artifactId = "anvilgradle"
  }
}
