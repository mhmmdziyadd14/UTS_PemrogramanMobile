package com.example.uts_152023198

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_152023198.R

// KontakAdapter menerima List<Kontak> sebagai data
class KontakAdapter(private val kontakList: List<Kontak>) :
    RecyclerView.Adapter<KontakAdapter.KontakViewHolder>() {

    // 1. KontakViewHolder: Menginisialisasi dan menampung referensi View (dari item_kontak.xml)
    class KontakViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Mengambil ID dari item_kontak.xml
        val tvNama: TextView = itemView.findViewById(R.id.tv_nama)
        val tvTelepon: TextView = itemView.findViewById(R.id.tv_telepon)
        val ivFoto: ImageView = itemView.findViewById(R.id.iv_foto)
    }

    // 2. onCreateViewHolder: Bertanggung jawab memuat layout XML (item_kontak.xml)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KontakViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_kontak, parent, false)
        return KontakViewHolder(view)
    }

    // 3. onBindViewHolder: Bertanggung jawab mengikat (bind) data ke View
    override fun onBindViewHolder(holder: KontakViewHolder, position: Int) {
        val kontak = kontakList[position]

        // Mengisi TextView dan ImageView dengan data dari objek Kontak
        holder.tvNama.text = kontak.nama
        holder.tvTelepon.text = kontak.telepon
        holder.ivFoto.setImageResource(kontak.imageResId)
    }

    // 4. getItemCount: Memberikan jumlah total item dalam daftar
    override fun getItemCount() = kontakList.size
}