// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0")
        classpath("com.google.gms:google-services:4.4.2")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.google.gms.google.services) apply false
}



