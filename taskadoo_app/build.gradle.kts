// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    kotlin("plugin.serialization") version "2.0.21"
}

dependencies{
    val nav_version = "2.8.8"


//
//    // Jetpack Compose integration
//    implementation("androidx.navigation:navigation-compose:$nav_version")
//
//    // Views/Fragments integration
//    implementation("androidx.navigation:navigation-fragment:$nav_version")
//    implementation("androidx.navigation:navigation-ui:$nav_version")
//
//    // Feature module support for Fragments
//    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

    // Testing Navigation
//    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")
//
//    // JSON serialization library, works with the Kotlin serialization plugin
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
}