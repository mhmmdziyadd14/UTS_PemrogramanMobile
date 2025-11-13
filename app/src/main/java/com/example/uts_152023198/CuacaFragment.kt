package com.example.uts_152023198 // Ganti dengan package Anda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uts_152023198.R

class CuacaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Memuat layout fragment_cuaca.xml yang sudah didesain
        return inflater.inflate(R.layout.fragment_cuaca, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Tidak ada logika tambahan yang diperlukan karena data bersifat statis
        // dan sudah di-hardcode di dalam file layout XML-nya.
    }
}