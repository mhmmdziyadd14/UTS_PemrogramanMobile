package com.example.uts_152023198 // Ganti dengan package Anda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_152023198.R

class BeritaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Memuat layout fragment_berita
        return inflater.inflate(R.layout.fragment_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Inisialisasi RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_berita)

        // Atur Layout Manager (Linear untuk daftar vertikal)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // 2. Buat data statis
        val beritaList = generateBeritaData()

        // 3. Hubungkan dengan Adapter dan tampilkan
        val adapter = BeritaAdapter(beritaList)
        recyclerView.adapter = adapter
    }

    // Fungsi helper untuk membuat data berita statis (minimal 3 item, sesuai contoh)
    private fun generateBeritaData(): List<Berita> {
        // Pastikan Anda memiliki R.drawable.ic_article di folder drawable
        return listOf(
            Berita(
                "OpenAI Mengumumkan Platform untuk Membuat Custom ChatGPTs",
                "OpenAI telah mengumumkan platform baru untuk menciptakan AI kustom...",
                "The Verge | 13 Nov 2025",
                R.drawable.ic_article
            ),
            Berita(
                "Program Panda Kebun Binatang Nasional Berakhir Setelah Lebih...",
                "Tiga panda raksasa berguling-guling di kandang mereka pada malam...",
                "CNN | 12 Nov 2025",
                R.drawable.ic_article
            ),
            Berita(
                "ITENAS Raih Penghargaan Kampus Hijau Terbaik Nasional",
                "Institut Teknologi Nasional (ITENAS) Bandung kembali mencetak prestasi di kancah nasional.",
                "ITENAS News | 11 Nov 2025",
                R.drawable.ic_article
            ),
            Berita(
                "Perkembangan Terbaru Kotlin di Android Developer Summit",
                "Google memperkenalkan fitur-fitur baru Kotlin yang berfokus pada performa dan stabilitas.",
                "Android Dev | 10 Nov 2025",
                R.drawable.ic_article
            )
        )
    }
}