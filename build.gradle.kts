plugins {
    alias(libs.plugins.android.application)       apply false
    alias(libs.plugins.kotlin.multiplatform)      apply false
    alias(libs.plugins.compose.multiplatform)     apply false
    alias(libs.plugins.compose.compiler)          apply false
    alias(libs.plugins.ksp)                       apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0" apply false
}