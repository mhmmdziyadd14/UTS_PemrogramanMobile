package com.example.uts_152023198 // Ganti dengan package Anda

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
// Pastikan Anda sudah membuat 5 Fragment ini:
import com.example.uts_152023198.BiodataFragment
import com.example.uts_152023198.KontakFragment
import com.example.uts_152023198.KalkulatorFragment
import com.example.uts_152023198.CuacaFragment
import com.example.uts_152023198.BeritaFragment


class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_navigation)

        // Tampilkan fragment Biodata sebagai tampilan default
        if (savedInstanceState == null) {
            loadFragment(BiodataFragment())
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_biodata -> {
                    loadFragment(BiodataFragment())
                    true
                }
                R.id.nav_kontak -> {
                    loadFragment(KontakFragment())
                    true
                }
                R.id.nav_kalkulator -> {
                    loadFragment(KalkulatorFragment())
                    true
                }
                R.id.nav_cuaca -> {
                    loadFragment(CuacaFragment())
                    true
                }
                R.id.nav_berita -> {
                    loadFragment(BeritaFragment())
                    true
                }
                else -> false
            }
        }
    }

    // Fungsi untuk mengganti fragment yang ditampilkan di FrameLayout
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}