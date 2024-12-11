// Top-level build file where you can add configuration options common to all sub-projects/modules.
//buildscript {
//    repositories {
//        google()
//        mavenCentral()
//    }
//    dependencies {
//        classpath("com.android.tools.build:gradle:7.4.2")  // Ensure AGP version is compatible with your setup
//        classpath("com.google.gms:google-services:4.3.15")  // Firebase plugin version
//    }

//    plugins {
//        alias(libs.plugins.android.application) apply true
//        alias(libs.plugins.jetbrains.kotlin.android) apply true
//        id("com.google.gms.google-services") version "4.4.2" apply false
//    }

plugins {
    
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
}
//}