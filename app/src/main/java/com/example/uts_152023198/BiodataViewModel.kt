package com.example.uts_152023198 // Ganti dengan package Anda

import androidx.lifecycle.ViewModel

/**
 * Brankas untuk menyimpan data Biodata selama aplikasi berjalan.
 * Data di sini TIDAK akan hilang saat Anda pindah-pindah Fragment.
 */
class BiodataViewModel : ViewModel() {
    // Variabel untuk menyimpan data
    var nama: String? = null
    var tanggalLahir: String? = null
    var prodiPosition: Int = 0
    var radioJenisKelaminId: Int = -1 // -1 berarti belum dipilih
}