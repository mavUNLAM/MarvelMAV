plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinxSerialization)
}

android {
    namespace = "com.unlam.marvel"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.unlam.marvel"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.picasso)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.runtime.android)
    implementation(libs.androidx.ui.android)
    implementation(libs.androidx.foundation.android)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.ui.tooling.preview.android)
    implementation(libs.androidx.ui.text.google.fonts)
    implementation(libs.ktor.client.android)
    implementation(libs.bundles.ktor)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.kotlin.serialization)
    implementation(libs.media.kamel)
    implementation(libs.koin.android)
    implementation(kotlincrypto.hash.md)
    implementation(libs.ktor.client.cio)
    // implementation(libs.koin.compose) koin-compose = {module="io.insert-koin:koin-compose", version.ref = "koin"}
    // implementation(libs.koin.compose.viewmodel) koin-compose-viewmodel = {module="io.insert-koin:koin-compose-viewmodel", version.ref = "koin"}
    // implementation(libs.koin.compose.viewmodel.navigation) koin-compose-viewmodel-navigation = {module="io.insert-koin:koin-compose-viewmodel-navigation", version.ref = "koin"}
    implementation(libs.paging.compose.common)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    debugImplementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.activity.compose)
}
