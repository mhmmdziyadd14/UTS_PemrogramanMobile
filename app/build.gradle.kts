plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.uts_152023198"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.uts_152023198"
        minSdk = 24
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
    // Mengaktifkan ViewBinding jika diperlukan (opsional)
    buildFeatures {
        viewBinding = true
    }
}

// Ini adalah bagian yang Anda tanyakan (Kode untuk Dependensi)
dependencies {

    // Dependensi Inti AndroidX
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // 1. Material Design (Untuk BottomNavigationView, CardView, Tombol, Tampilan Teks)
    implementation("com.google.android.material:material:1.11.0")

    // 2. Fragment (Untuk Bottom Navigation)
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    // 3. RecyclerView (Untuk Halaman Kontak dan Berita)
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // 4. GridLayout (Untuk Kalkulator agar 'layout_columnWeight' berfungsi)
    implementation("androidx.gridlayout:gridlayout:1.0.0")

    // 5. ViewModel (Agar data tidak hilang saat pindah Fragment)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    // implementation(libs.firebase.inappmessaging) <-- BARIS INI DIHAPUS KARENA ERROR

    // Dependensi untuk Testing (bawaan)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}