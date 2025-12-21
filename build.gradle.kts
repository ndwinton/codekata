plugins {
    kotlin("jvm") version "2.2.21"
    alias(libs.plugins.kotest)
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.bundles.kotest)
}

kotlin {
    jvmToolchain(17)
}
