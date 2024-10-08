plugins {
    alias(libs.plugins.kotlin.jvm)
    application
}

application {
    mainClass = "MainKt"
}

dependencies {
    implementation(project(":lib"))
}

kotlin.jvmToolchain(21)
