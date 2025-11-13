package com.example.uts_152023198

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_152023198.R

// BeritaAdapter menerima List<Berita> sebagai data
class BeritaAdapter(private val beritaList: List<Berita>) :
    RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>() {

    // 1. BeritaViewHolder: Menampung referensi View (dari item_berita.xml)
    class BeritaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivFoto: ImageView = itemView.findViewById(R.id.iv_berita_foto)
        val tvJudul: TextView = itemView.findViewById(R.id.tv_berita_judul)
        val tvSumber: TextView = itemView.findViewById(R.id.tv_berita_sumber)
    }

    // 2. onCreateViewHolder: Memuat layout XML (item_berita.xml)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_berita, parent, false)
        return BeritaViewHolder(view)
    }

    // 3. onBindViewHolder: Mengikat (bind) data dari objek Berita ke View
    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        val berita = beritaList[position]

        holder.tvJudul.text = berita.judul
        holder.tvSumber.text = "${berita.sumber}"
        holder.ivFoto.setImageResource(berita.imageResId)
    }

    // 4. getItemCount: Memberikan jumlah total item
    override fun getItemCount() = beritaList.size
}