buildscript {
    dependencies {
        classpath(libs.google.services)
        classpath("com.google.gms:google-services:4.4.1");
        classpath ("com.android.tools.build:gradle:4.0.0-alpha07");
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
}