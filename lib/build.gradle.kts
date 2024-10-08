plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    // Doesn't affect the bug. You can remove this dependency
    implementation(libs.kotlin.reflect)
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use Kotlin Test test framework
            useKotlinTest(libs.versions.kotlin.get())
        }
    }
}

kotlin.jvmToolchain(21)
