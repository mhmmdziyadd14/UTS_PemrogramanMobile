package com.example.uts_152023198 // Ganti dengan package Anda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.uts_152023198.R
import java.lang.Math.sqrt
import kotlin.math.pow

class KalkulatorFragment : Fragment() {

    // Referensi UI
    private lateinit var tvResult: TextView

    // Variabel state untuk logika kalkulator
    private var currentInput = StringBuilder("0")
    private var firstOperand: Double = 0.0
    private var currentOperator: String = ""
    private var lastNumeric: Boolean = true
    private var lastDot: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Memuat layout fragment_kalkulator.xml
        val view = inflater.inflate(R.layout.fragment_kalkulator, container, false)

        // Inisialisasi TextView Hasil
        tvResult = view.findViewById(R.id.tv_result)
        updateDisplay()

        // Set listener untuk tombol angka (0-9) dan titik (.)
        setNumberClickListeners(view)

        // Set listener untuk tombol operator (+, -, *, /)
        setOperatorClickListeners(view)

        // Set listener untuk tombol fungsi (C, =, x², √)
        setFunctionClickListeners(view)

        return view
    }

    // Fungsi untuk meng-grupkan listener tombol angka
    private fun setNumberClickListeners(view: View) {
        val numberButtons = listOf<Button>(
            view.findViewById(R.id.btn_0), view.findViewById(R.id.btn_1),
            view.findViewById(R.id.btn_2), view.findViewById(R.id.btn_3),
            view.findViewById(R.id.btn_4), view.findViewById(R.id.btn_5),
            view.findViewById(R.id.btn_6), view.findViewById(R.id.btn_7),
            view.findViewById(R.id.btn_8), view.findViewById(R.id.btn_9)
        )

        for (button in numberButtons) {
            button.setOnClickListener { onNumberClick(button.text.toString()) }
        }

        // Listener untuk tombol titik (.)
        view.findViewById<Button>(R.id.btn_dot).setOnClickListener { onDotClick() }
    }

    // Fungsi untuk meng-grupkan listener tombol operator
    private fun setOperatorClickListeners(view: View) {
        val operatorButtons = listOf<Button>(
            view.findViewById(R.id.btn_plus), view.findViewById(R.id.btn_minus),
            view.findViewById(R.id.btn_multiply), view.findViewById(R.id.btn_divide)
        )

        for (button in operatorButtons) {
            button.setOnClickListener { onOperatorClick(button.text.toString()) }
        }
    }

    // Fungsi untuk meng-grupkan listener tombol fungsi
    private fun setFunctionClickListeners(view: View) {
        // Tombol Clear (C)
        view.findViewById<Button>(R.id.btn_clear).setOnClickListener { onClearClick() }

        // Tombol Sama Dengan (=)
        view.findViewById<Button>(R.id.btn_equals).setOnClickListener { onEqualsClick() }

        // Tombol Kuadrat (x²) (Sesuai permintaan soal)
        view.findViewById<Button>(R.id.btn_sqr).setOnClickListener { onSpecialFunctionClick("sqr") }

        // Tombol Akar Kuadrat (√) (Sesuai permintaan soal)
        view.findViewById<Button>(R.id.btn_sqrt).setOnClickListener { onSpecialFunctionClick("sqrt") }
    }


    // --- LOGIKA UTAMA KALKULATOR ---

    // Dipanggil saat tombol angka ditekan
    private fun onNumberClick(number: String) {
        if (!lastNumeric) {
            // Jika input sebelumnya adalah operator, reset display
            currentInput.clear().append(number)
            lastNumeric = true
        } else {
            // Jika display "0", ganti dengan angka baru
            if (currentInput.toString() == "0") {
                currentInput.clear()
            }
            currentInput.append(number)
        }
        updateDisplay()
    }

    // Dipanggil saat tombol titik (.) ditekan
    private fun onDotClick() {
        if (lastNumeric && !lastDot) {
            currentInput.append(".")
            lastNumeric = false // Setelah titik, tunggu angka
            lastDot = true
            updateDisplay()
        }
    }

    // Dipanggil saat tombol operator (+, -, *, /) ditekan
    private fun onOperatorClick(operator: String) {
        // Hanya proses jika input terakhir adalah angka
        if (lastNumeric) {
            // Jika sudah ada operator sebelumnya, hitung dulu
            if (currentOperator.isNotEmpty()) {
                onEqualsClick()
            }
            firstOperand = currentInput.toString().toDoubleOrNull() ?: 0.0
            currentOperator = operator
            lastNumeric = false
            lastDot = false
        }
    }

    // Dipanggil saat tombol sama dengan (=) ditekan
    private fun onEqualsClick() {
        if (lastNumeric && currentOperator.isNotEmpty()) {
            val secondOperand = currentInput.toString().toDoubleOrNull() ?: 0.0
            val result = performCalculation(firstOperand, secondOperand, currentOperator)

            currentInput.clear().append(formatResult(result))

            // Siapkan untuk perhitungan selanjutnya
            currentOperator = ""
            firstOperand = result
            lastDot = currentInput.contains(".")
            lastNumeric = true // Hasil perhitungan adalah numerik
            updateDisplay()
        }
    }

    // Dipanggil saat tombol Clear (C) ditekan
    private fun onClearClick() {
        currentInput.clear().append("0")
        firstOperand = 0.0
        currentOperator = ""
        lastNumeric = true
        lastDot = false
        updateDisplay()
    }

    // Dipanggil saat tombol x² atau √ ditekan
    private fun onSpecialFunctionClick(function: String) {
        if (lastNumeric) {
            val operand = currentInput.toString().toDoubleOrNull() ?: 0.0
            var result = 0.0

            if (function == "sqrt") { // Akar Kuadrat
                if (operand >= 0) {
                    result = sqrt(operand)
                } else {
                    currentInput.clear().append("Error")
                    updateDisplay()
                    return
                }
            } else if (function == "sqr") { // Kuadrat
                result = operand.pow(2)
            }

            currentInput.clear().append(formatResult(result))
            lastDot = currentInput.contains(".")
            updateDisplay()
        }
    }

    // Fungsi inti untuk melakukan perhitungan
    private fun performCalculation(op1: Double, op2: Double, operator: String): Double {
        return when (operator) {
            "+" -> op1 + op2
            "-" -> op1 - op2
            "*" -> op1 * op2
            "/" -> if (op2 != 0.0) op1 / op2 else Double.NaN // Handle bagi dengan nol
            else -> 0.0
        }
    }

    // Memformat hasil (menghilangkan .0 jika bilangan bulat)
    private fun formatResult(result: Double): String {
        return if (result.isNaN() || result.isInfinite()) {
            "Error"
        } else if (result == result.toLong().toDouble()) {
            result.toLong().toString() // Tampilkan sebagai 123
        } else {
            result.toString() // Tampilkan sebagai 123.45
        }
    }

    // Memperbarui TextView hasil
    private fun updateDisplay() {
        // Mencegah teks terlalu panjang di display
        if (currentInput.length > 12) {
            tvResult.text = currentInput.substring(0, 12)
        } else {
            tvResult.text = currentInput
        }
    }
}