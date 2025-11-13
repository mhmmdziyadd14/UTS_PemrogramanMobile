package com.example.uts_152023198

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_152023198.R // Import R

class KontakFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_kontak, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.rv_kontak)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Buat data statis (minimal 15 kontak)
        val kontakList = generateKontakData()

        val adapter = KontakAdapter(kontakList)
        recyclerView.adapter = adapter
    }

    // Fungsi helper untuk membuat data kontak statis
    private fun generateKontakData(): List<Kontak> {
        // [TODO]: Ganti R.drawable.ic_person dengan R.drawable.ikon_lain jika ada
        return listOf(
            Kontak("Ripal", "0812-1111-2222", R.drawable.ic_person), // Dosen
            Kontak("Ammar", "0812-1234-5678", R.drawable.ic_person),
            Kontak("Nopal", "0821-8765-4321", R.drawable.ic_person),
            Kontak("Noped", "0857-0000-1111", R.drawable.ic_person),
            Kontak("Surucup", "0878-2222-3333", R.drawable.ic_person),
            Kontak("Dika", "0896-4444-5555", R.drawable.ic_person),
            Kontak("Felisaa", "0811-6666-7777", R.drawable.ic_person),
            Kontak("Genki", "0819-8888-9999", R.drawable.ic_person),
            Kontak("Tajudin", "0813-1000-2000", R.drawable.ic_person),
            Kontak("Mike Tyson", "0852-3000-4000", R.drawable.ic_person),
            Kontak("Joko Widodo", "0877-5000-6000", R.drawable.ic_person),
            Kontak("Kurnia Mega", "0895-7000-8000", R.drawable.ic_person),
            Kontak("Tom Haye", "0815-9000-0000", R.drawable.ic_person),
            Kontak("Pasha", "0856-1111-3333", R.drawable.ic_person),
            Kontak("Dudung", "0817-2222-4444", R.drawable.ic_person),
        )
    }
}