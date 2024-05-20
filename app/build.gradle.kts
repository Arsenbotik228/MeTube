plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.navigationArgs)
}

android {
    namespace = "com.myself223.metube"
    compileSdk = config.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.myself223.metube"
        minSdk = config.versions.minSdk.get().toInt()
        targetSdk = config.versions.targetSdk.get().toInt()
        versionCode = config.versions.versionCode.get().toInt()
        versionName = config.versions.versionName.get()
        buildConfigField("String","BASE_URL","\"https://www.googleapis.com/youtube/v3/\"")
        buildConfigField("String","CHANEL_ID","\"UC2oIn4q3AiBK5-I-NbqMvFw\"")
        buildConfigField("String","API_KEY","\"AIzaSyDyLGRas-kZFUc2kUusMSB4sED9X-PbzWI\"")
        testInstrumentationRunner = config.versions.testInstrumentationRunner.get()
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(config.versions.getDefaultProguardFile.get()),
                config.versions.proguardFiles.get()
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
        buildConfig = true
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    val exoPlayerVersion = "2.18.1"
    implementation("com.google.android.exoplayer:exoplayer-core:$exoPlayerVersion")
    implementation("com.google.android.exoplayer:exoplayer-ui:$exoPlayerVersion")

    implementation(libs.androidx.fragment)
    val nav_version = "2.7.7"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")

    //core.ktx,material,appCompat,activity,constraintlayout,navController
    implementation(libs.bundles.ui.component)
    //junit,espresso
    implementation(libs.bundles.test.component)
    //Retrofit
    implementation(libs.bundles.network.component)
    // define any required OkHttp artifacts without version
    implementation("com.squareup.okhttp3:okhttp:4.+")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    //koin
    implementation(libs.bundles.koin.component)
    implementation(libs.androidx.lifecycle.viewmodel.compose)


}