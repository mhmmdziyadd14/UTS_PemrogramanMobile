package com.example.uts_152023198 // Ganti dengan package Anda

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels // <-- Import penting untuk ViewModel
import com.example.uts_152023198.R
import java.util.Calendar

class BiodataFragment : Fragment() {

    // --- (PERMINTAAN BARU) Inisialisasi ViewModel ---
    // Gunakan 'activityViewModels()' agar ViewModel ini terikat dengan MainActivity
    // dan datanya tidak hilang saat ganti Fragment
    private val viewModel: BiodataViewModel by activityViewModels()

    // Referensi untuk UI elements
    private lateinit var etNama: EditText
    private lateinit var etTglLahir: EditText
    private lateinit var spinnerProdi: Spinner
    private lateinit var radioGroupJK: RadioGroup
    private lateinit var btnSimpan: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Memuat layout fragment_biodata.xml
        return inflater.inflate(R.layout.fragment_biodata, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Inisialisasi semua referensi UI
        etNama = view.findViewById(R.id.et_nama)
        etTglLahir = view.findViewById(R.id.et_tgl_lahir)
        spinnerProdi = view.findViewById(R.id.spinner_prodi)
        btnSimpan = view.findViewById(R.id.btn_simpan)
        // (Anda bisa tambahkan RadioGroup jika ingin menyimpannya juga)
        // radioGroupJK = view.findViewById(R.id.radio_group_jk)

        // 2. Setup Spinner (Dropdown Prodi)
        setupSpinner(spinnerProdi)

        // 3. (PERMINTAAN BARU) Muat data dari ViewModel
        // Ini akan mengisi form jika Anda kembali dari halaman lain
        loadDataFromViewModel()

        // 4. Setup Listener untuk Kalender (DatePicker)
        setupDatePicker(etTglLahir)

        // 5. Setup Listener untuk Tombol Simpan
        btnSimpan.setOnClickListener {
            // (PERMINTAAN BARU) Simpan data ke ViewModel
            saveDataToViewModel()

            // Tampilkan Custom Toast
            showCustomToast("Data Berhasil Disimpan!")
        }
    }

    // --- FUNGSI HELPER ---

    // (PERMINTAAN BARU) Mengisi form dengan data dari ViewModel
    private fun loadDataFromViewModel() {
        etNama.setText(viewModel.nama)
        etTglLahir.setText(viewModel.tanggalLahir)
        spinnerProdi.setSelection(viewModel.prodiPosition)
        // if (viewModel.radioJenisKelaminId != -1) {
        //     radioGroupJK.check(viewModel.radioJenisKelaminId)
        // }
    }

    // (PERMINTAAN BARU) Menyimpan data dari form ke ViewModel
    private fun saveDataToViewModel() {
        viewModel.nama = etNama.text.toString()
        viewModel.tanggalLahir = etTglLahir.text.toString()
        viewModel.prodiPosition = spinnerProdi.selectedItemPosition
        // viewModel.radioJenisKelaminId = radioGroupJK.checkedRadioButtonId
    }

    // Mengatur Spinner (Dropdown)
    private fun setupSpinner(spinner: Spinner) {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.prodi_array, // Mengambil data dari strings.xml
            android.R.layout.simple_spinner_item // Layout default untuk item terpilih
        ).also { adapter ->
            // (PERBAIKAN TEMA) Mengatur layout dropdown agar putih (tidak hitam)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    // Mengatur Kalender (DatePicker)
    private fun setupDatePicker(etTglLahir: EditText) {
        etTglLahir.isFocusable = false
        etTglLahir.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // (PERBAIKAN TEMA) Memaksa Kalender menggunakan TEMA TERANG (LIGHT)
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                android.R.style.Theme_Holo_Light_Dialog_MinWidth, // Tema Terang
                { _, selectedYear, selectedMonth, selectedDay ->
                    val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    etTglLahir.setText(date)
                },
                year, month, day
            )
            // (Bagian dari perbaikan tema)
            datePickerDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            datePickerDialog.show()
        }
    }

    // (PERBAIKAN TOAST) Menampilkan Toast Kustom (Teks Ungu)
    private fun showCustomToast(message: String) {
        // Inflate layout custom_toast_layout.xml
        val inflater = LayoutInflater.from(requireContext())
        val layout = inflater.inflate(R.layout.custom_toast_layout, null)

        // Set teks pesan
        val textView: TextView = layout.findViewById(R.id.tv_toast_message)
        textView.text = message

        // Buat dan tampilkan Toast
        with(Toast(requireContext())) {
            duration = Toast.LENGTH_LONG
            // Posisikan di tengah bawah, sedikit di atas BottomNav
            setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 200)
            view = layout
            show()
        }
    }
}