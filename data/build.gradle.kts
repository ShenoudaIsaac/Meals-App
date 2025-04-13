plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.shnsh.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // Kotlin Coroutines Core
    implementation (libs.jetbrains.kotlinx.coroutines.core)

// Kotlin Coroutines for Android (Main dispatcher, lifecycle, etc.)
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.retrofit.v2110)

// Converter for JSON (using Gson)
    implementation (libs.converter.gson)

// Retrofit + Coroutines support (using Kotlin Call Adapter)
    implementation (libs.retrofit2.kotlin.coroutines.adapter)
    implementation( project(":domain"))

}