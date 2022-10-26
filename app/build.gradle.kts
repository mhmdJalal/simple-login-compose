plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.6.10"
}

android {
    namespace = "com.mhmdjalal.logincompose"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.mhmdjalal.logincompose"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "BASE_URL", "\"reqres.in\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        targetCompatibility(JavaVersion.VERSION_11)
        sourceCompatibility(JavaVersion.VERSION_11)
    }

    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources.excludes.add("/META-INF/*.kotlin_module")
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

dependencies {

    implementation(Deps.materialDesign)
    implementation(Deps.Compose.material)
    implementation(Deps.Compose.materialIcons)
    implementation(Deps.Compose.materialIconsExt)
    implementation(Deps.Compose.activity)
    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.uiTooling)
    implementation(Deps.Compose.navigation)

    implementation(Deps.gson)

    // LIFECYCLE
    implementation(Deps.lifecycleLiveData)
    implementation(Deps.lifecycleViewModel)
    implementation(Deps.lifecycleCompose)

    // DEPENDENCY INJECTION
    implementation(Deps.Compose.koin)
    implementation(Deps.Koin.core)
    implementation(Deps.Koin.android)

    // KotlinX
    implementation(Deps.KotlinX.serialization)
    implementation(Deps.KotlinX.coroutineCore)
    implementation(Deps.KotlinX.coroutineAndroid)

    // KTOR
    implementation(Deps.Ktor.core)
    implementation(Deps.Ktor.cio)
    implementation(Deps.Ktor.android)
    implementation(Deps.Ktor.serialization)
    implementation(Deps.Ktor.logging)
    implementation(Deps.Ktor.contentNegotiation)

    // TESTING
    testImplementation(Deps.Testing.jUnit)
    androidTestImplementation(Deps.Testing.extJUnit)
    androidTestImplementation(Deps.Testing.espresso)
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.Compose.ui}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Versions.Compose.ui}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${Versions.Compose.ui}")
}