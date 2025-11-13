Proyek UTS Pemrograman Mobile - Dashboard App

Ini adalah proyek aplikasi Android native yang dibuat untuk memenuhi Ujian Tengah Semester (UTS) mata kuliah Pemrograman Mobile.

Aplikasi ini mengimplementasikan berbagai komponen UI fundamental Android dalam sebuah aplikasi dashboard multifungsi dengan 5 menu utama.

Nama: Muhammad Ziyad

NIM: 152023198

Mata Kuliah: Pemrograman Mobile

Dosen: Galih Ashari R., S.Si., MT

Tampilan Aplikasi 
<img width="279" height="347" alt="image" src="https://github.com/user-attachments/assets/c4b5c47b-407c-4ecd-8b8d-3a78db2c5b26" />


Aplikasi ini didesain menggunakan tema warna kustom "Plume Wine" (#5E4074) dan "Linen Cloud" (#F7F9EC).



Splash Screen

<img width="540" height="1156" alt="image" src="https://github.com/user-attachments/assets/b3a336f5-1658-4e6e-9020-13c9396dd292" />



Halaman Biodata


<img width="540" height="1155" alt="image" src="https://github.com/user-attachments/assets/56d6ac99-eacd-432a-98ac-fa7ff4b56bb2" />




Kontak 


<img width="540" height="1156" alt="image" src="https://github.com/user-attachments/assets/a901cd0a-0ca1-439e-bf32-667f83a2b82d" />



Kalkulator


<img width="540" height="1152" alt="image" src="https://github.com/user-attachments/assets/6e88da79-78ee-4ea4-883c-f97820d7796a" />




Berita 



<img width="540" height="1158" alt="image" src="https://github.com/user-attachments/assets/bca653cc-a3b0-427c-90d1-0551df91949d" />










Fitur Utama

Aplikasi ini mencakup semua fitur yang disyaratkan oleh soal UTS:

Splash Screen: Tampilan pembuka aplikasi selama 5 detik, menampilkan foto profil (lingkaran) dan identitas mahasiswa dengan font elegan.

Bottom Navigation: Navigasi utama 5-menu (BottomNavigationView) dengan tema ungu kustom dan mode "hanya ikon" (label tersembunyi).

Arsitektur Fragment: Setiap menu (Biodata, Kontak, dll.) dikelola sebagai Fragment terpisah yang di-host oleh MainActivity.

Halaman Biodata (Interaktif):

Form input pengguna yang scrollable (ScrollView).

Input Tanggal Lahir menggunakan DatePickerDialog (dengan perbaikan tema terang).

Input Program Studi menggunakan Spinner (Dropdown) (dengan perbaikan tema terang).

Input Nama dan RadioButton Jenis Kelamin.

State Persistence: Data form tidak hilang saat berpindah antar fragment, berkat implementasi ViewModel (Jetpack Lifecycle).

Toast kustom saat tombol "Simpan" ditekan.

Halaman Kontak (RecyclerView):

Menampilkan daftar 15+ kontak statis menggunakan RecyclerView dan LinearLayoutManager.

Desain item "menawan" menggunakan CardView dengan foto lingkaran.

Halaman Berita (RecyclerView):

Menampilkan daftar berita statis menggunakan RecyclerView dengan desain CardView yang berbeda (gambar di kiri, teks di kanan).

Halaman Kalkulator (Fungsional):

Kalkulator fungsional dengan desain androidx.gridlayout.widget.GridLayout.

Mendukung operasi: Tambah (+), Kurang (-), Kali (*), Bagi (/).

Mendukung operasi tambahan: Kuadrat (x²) dan Akar Kuadrat (√).

Halaman Cuaca (Statis):

Tampilan UI statis menggunakan CardView berlapis untuk menunjukkan informasi cuaca.

Desain & Tema Kustom:

Aplikasi menerapkan tema warna "Plume Wine" & "Linen Cloud" secara konsisten di semua halaman, header, tombol, dan drawable kustom.

Teknologi yang Digunakan

Proyek ini dibangun menggunakan 100% Kotlin dan arsitektur Android Views (XML).

Bahasa: Kotlin

Arsitektur UI: Android Views (XML Layouts)

Komponen Utama:

Activity & Fragment

BottomNavigationView (Material Design)

RecyclerView (dengan Adapter dan ViewHolder kustom)

Layouting:

ConstraintLayout (utama)

RelativeLayout (untuk activity_main)

LinearLayout & ScrollView

androidx.gridlayout.widget.GridLayout (untuk Kalkulator)

UI & Desain:

CardView (Material Design)

TextInputLayout & TextInputEditText (Material Design)

Spinner & DatePickerDialog

Kustom Drawable (Shape & Selector XML)

Kustom Style & Theme (styles.xml)

Kustom Color State List (res/color/nav_item_color.xml)

State Management (Lifecycle):

ViewModel (dari Android Jetpack) untuk mempertahankan data di Halaman Biodata saat berpindah fragment.

Build System: Gradle (dengan Groovy/KTS)

(JAWABAN SOAL 1) - Insight Materi (SubCPMK 2)

Sesuai petunjuk pengerjaan (poin b), berikut adalah insight dan pembelajaran yang didapat dari pengerjaan proyek ini terkait materi SubCPMK 2:

Proyek ini memberikan pemahaman praktis yang mendalam mengenai fundamental UI/UX Android. Insight utamanya adalah:

Pemisahan Tanggung Jawab (SoC): Terdapat pemisahan yang jelas antara Logika Tampilan (XML) dan Logika Bisnis (Kotlin). Hal ini terbukti sangat vital saat kami memutuskan untuk mengganti seluruh tema warna aplikasi (menjadi Ungu-Putih) di akhir; kami hanya perlu menyentuh file resource (XML, style, drawable) tanpa harus mengubah satu baris pun file logika Kotlin yang sudah berfungsi.

Arsitektur Fragment & Navigasi: Penggunaan BottomNavigationView yang dikombinasikan dengan Fragment adalah standar industri untuk aplikasi modern. MainActivity berfungsi sebagai "Host" tunggal, sementara Fragment (seperti KontakFragment, KalkulatorFragment, dll.) bertindak sebagai layar modular yang bisa diganti-ganti di dalam FragmentContainer.

Efisiensi RecyclerView: RecyclerView adalah komponen paling kuat untuk menampilkan daftar. Berbeda dengan ListView lama, RecyclerView memaksa penggunaan ViewHolder Pattern (via Adapter) yang secara efisien mendaur ulang view saat di-scroll. Ini terbukti saat mengimplementasikan Halaman Kontak (15+ item) dan Berita, di mana performa tetap terjaga.

Menangani Siklus Hidup (Lifecycle) & State: Insight terbesar adalah saat data di Halaman Biodata hilang ketika berpindah fragment. Ini adalah demonstrasi nyata dari Fragment Lifecycle (di mana fragment di-destroy dan di-create ulang). Solusinya adalah menggunakan ViewModel yang lifecycle-aware. ViewModel bertindak sebagai "brankas" data yang tidak ikut hancur saat fragment dihancurkan, sehingga data (Nama, Tgl Lahir) dapat disimpan dan dipulihkan dengan aman.

Kekuatan Layouting Kustom: ConstraintLayout sangat fleksibel untuk desain kompleks (seperti Halaman Cuaca dan Berita). Namun, untuk Halaman Kalkulator, androidx.gridlayout.widget.GridLayout jauh lebih superior. Penggunaan layout_columnWeight dan layout_rowWeight (dari library androidx tambahan, bukan GridLayout bawaan) sangat penting untuk memastikan semua tombol kalkulator memiliki ukuran yang proporsional secara otomatis.
