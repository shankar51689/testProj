// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }  // Ensure this is not duplicated
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.0")  // Ensure this version matches Gradle 8.x compatibility
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
}

