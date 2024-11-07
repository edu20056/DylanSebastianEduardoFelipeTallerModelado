plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.intellihome"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.intellihome"
        minSdk = 26
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
}

dependencies {
    // Dependencias comunes
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.protolite.well.known.types)
    implementation(libs.play.services.maps)
    implementation(libs.core)
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.cardview:cardview:1.0.0")

    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.4.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-storage")
    implementation("com.squareup.picasso:picasso:2.71828")

    // JUnit para pruebas unitarias
    testImplementation("junit:junit:4.13.2")

    // Mockito para pruebas unitarias
    testImplementation("org.mockito:mockito-core:3.12.4")

    // Dependencias de pruebas unitarias y de Android
    testImplementation("androidx.test.ext:junit:1.1.5")
    testImplementation("androidx.test:core:1.6.0")
    testImplementation(libs.junit.jupiter)  // Cambia la versión aquí si es necesario

    // Para pruebas de UI con Espresso (si es necesario)
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")
    testImplementation("androidx.test:core:1.6.0")
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.mockito:mockito-core:4.0.0")
    testImplementation ("org.mockito:mockito-inline:4.0.0")
    testImplementation ("org.robolectric:robolectric:4.10.3")  // Usa la última versión de Robolectric


}

