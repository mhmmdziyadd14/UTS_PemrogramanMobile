package com.example.uts_152023198

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {

    // Durasi splash screen 5000 milidetik = 5 detik (5 detik adalah requirement soal)
    private val SPLASH_TIME_OUT: Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // R.layout.activity_splash akan dicari di package yang di-import di atas.
        setContentView(R.layout.activity_splash)

        // Handler digunakan untuk menunda eksekusi selama SPLASH_TIME_OUT
        Handler(Looper.getMainLooper()).postDelayed({
            // 1. Buat Intent untuk pindah ke MainActivity (Dashboard)
            // MainActivity::class.java akan ditemukan berkat import di atas.
            val intentKeMain = Intent(this, MainActivity::class.java)
            startActivity(intentKeMain)

            // 2. Tutup SplashActivity agar pengguna tidak bisa kembali ke sini
            finish()
        }, SPLASH_TIME_OUT)
    }
}