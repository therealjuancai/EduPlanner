
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.softcg.eduplanner"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.softcg.eduplanner"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures{
        viewBinding=true
    }
    hilt{
        enableAggregatingTask=false
    }

}

dependencies {


    //FRAGMENT
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    //ACTIVITY
    implementation("androidx.activity:activity-ktx:1.8.2")
    //VIEWMODEL
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    //LIVEDATA
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    //DaggerHilt
    implementation("com.google.dagger:hilt-android:2.35")

    kapt("com.google.dagger:hilt-android-compiler:2.35")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}