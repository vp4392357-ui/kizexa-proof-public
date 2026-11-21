import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.kizexa.reference.minimal"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.kizexa.reference.minimal"
        minSdk = 24
        targetSdk = 35
        // Deliberately unlike any release KIZEXA Manage starts: the bundle must carry the injected values instead.
        versionCode = 1000
        versionName = "0.0.0-source"
    }

    buildTypes {
        release {
            // R8 on, so the build writes mapping.txt for the runner to upload.
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            // No signingConfig: the release bundle comes out unsigned and KIZEXA Manage signs it after the build.
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}
