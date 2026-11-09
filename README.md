# Aplikasi Catat Produk Toko (ProdukApp)

Aplikasi desktop berbasis JavaFX untuk mengelola pencatatan daftar produk toko secara sederhana dan interaktif. Proyek ini dibangun menggunakan arsitektur MVC (Model-View-Controller) dan dikelola dengan Maven.

## Identitas Pengembang
* **Nama:** Ahmad Azizi
* **NIM:** 2504825
* **Kelas:** MKB 3A
* **Program Studi:** Mekatronika dan Kecerdasan Buatan - Universitas Pendidikan Indonesia (UPI) Kampus Purwakarta

---

## Fitur Utama
1. **Manajemen Produk (CRUD):** Menambah produk baru, melihat daftar produk, mengubah (edit) data produk, dan menghapus produk.
2. **Kode Produk Otomatis:** Sistem menghasilkan kode unik secara otomatis dengan format `PRD001`, `PRD002`, dan seterusnya.
3. **Unggah & Pratinjau Gambar:** Mendukung lampiran foto produk (`ImageView` & `FileChooser`) yang ditampilkan pada form, *thumbnail* tabel, dan halaman detail.
4. **Pencarian Produk:** Fitur *filter* pencarian berdasarkan kata kunci nama produk.
5. **Validasi Input:** Memastikan nama produk tidak kosong dan harga produk bernilai valid (lebih dari nol).

---

## Teknologi yang Digunakan
* **Bahasa Pemrograman:** Java
* **GUI Framework:** JavaFX 21 & SceneBuilder (FXML, CSS)
* **Build Tool:** Apache Maven

---

## Alur Penggunaan Aplikasi (Dokumentasi UI)

Berikut adalah alur kerja penggunaan aplikasi dari awal hingga akhir:

### 1. Halaman Awal Daftar Produk
Saat aplikasi pertama kali dijalankan, pengguna akan disambut oleh halaman **Daftar Produk Toko**. Pada tahap awal, tabel masih kosong dan menampilkan pesan *"Belum ada data produk."*

[1. Halaman Awal Daftar Produk] <img width="1121" height="878" alt="Screenshot 2026-11-09 145201" src="https://github.com/user-attachments/assets/dedc6d08-7474-4f68-b8f0-cc4bf211a7b1" />


### 2. Menambahkan Produk Baru
Pengguna menekan tombol **Tambah Produk Baru** untuk membuka halaman form. Di sini pengguna mengisi nama produk (contoh: *Roti*), memilih kategori (*Makanan* / *Minuman*), memasukkan harga, serta memilih foto produk melalui tombol **Upload IMG** sebelum menekan **Simpan Produk**.

[2. Form Tambah Produk Baru]<img width="1117" height="878" alt="Screenshot 2026-11-09 193551" src="https://github.com/user-attachments/assets/b5dc9ad1-7aff-46c1-a429-7487f8f68435" />


### 3. Halaman Detail Produk
Setelah produk baru disimpan, aplikasi secara otomatis mengarahkan pengguna ke halaman **Detail Produk Toko** untuk menampilkan rincian data yang baru saja dibuat beserta kode otomatisnya (`PRD001`) dan foto produk.

[3. Detail Produk Baru]<img width="1117" height="883" alt="Screenshot 2026-11-09 193600" src="https://github.com/user-attachments/assets/f6078512-2ba4-464e-b8ae-d010fc55456f" />


### 4. Melihat Daftar Produk di Tabel
Pengguna kembali ke halaman daftar dengan menekan tombol **Kembali ke Daftar** atau **Lihat Daftar**. Produk yang telah ditambahkan kini tampil di dalam tabel lengkap dengan pratinjau gambar (*thumbnail*).

[4. Daftar Produk Setelah Ditambah]<img width="1115" height="882" alt="Screenshot 2026-11-09 193625" src="https://github.com/user-attachments/assets/eb880eef-50b8-426e-b30f-030efcfa0863" />


### 5. Mengubah (Edit) Data Produk
Pengguna memilih baris produk pada tabel lalu menekan tombol **Edit Produk**. Aplikasi membuka kembali halaman form yang sudah terisi data produk sebelumnya (`Edit Produk (PRD001)`), sehingga pengguna dapat memperbarui informasi yang diinginkan.

[5. Form Edit Produk]<img width="1121" height="876" alt="Screenshot 2026-11-09 193648" src="https://github.com/user-attachments/assets/58aca69c-b1d3-4bd2-a41d-fa32e3819cf5" />


### 6. Detail Produk Setelah Diedit
Begitu perubahan disimpan, aplikasi kembali menampilkan halaman **Detail Produk Toko** secara otomatis untuk memperlihatkan hasil pembaruan data (contoh: nama produk berhasil diubah menjadi *Sari Roti*).

[6. Detail Produk Setelah Edit]<img width="1117" height="880" alt="Screenshot 2026-11-09 193704 edit" src="https://github.com/user-attachments/assets/dbd11dbc-246c-48c5-a9f7-5d12a773d3a8" />


### 7. Mengecek Keseluruhan Data di Daftar Produk
Pengguna membuka kembali halaman **Daftar Produk Toko** untuk mengecek data yang sudah diperbarui maupun melihat daftar produk lainnya yang telah ditambahkan ke dalam tabel (`PRD001`, `PRD002`, `PRD003`).

[7. Mengecek Daftar Produk]<img width="1116" height="878" alt="Screenshot 2026-11-09 193934" src="https://github.com/user-attachments/assets/8fb02a79-b383-4217-8e4b-22b2dc4d185e" />


### 8. Konfirmasi Menghapus Produk
Untuk menghapus produk, pengguna memilih salah satu baris produk pada tabel (contoh: *Le Mineral - PRD003*) lalu menekan tombol **Hapus**. Sistem akan memunculkan kotak dialog konfirmasi (*Confirmation Alert*) untuk mencegah penghapusan yang tidak disengaja.

[8. Konfirmasi Hapus Produk]<img width="1116" height="882" alt="Screenshot 2026-11-09 194018" src="https://github.com/user-attachments/assets/a2d7f4e0-6a23-4def-ad7c-9d20733b3d38" />


### 9. Daftar Produk Setelah Dihapus
Setelah pengguna menekan tombol **Yes** pada dialog konfirmasi, produk tersebut terhapus dari tabel dan aplikasi menampilkan pesan status *"Data berhasil dihapus."* di bagian bawah layar.

[9. Hasil Setelah Produk Dihapus]<img width="1116" height="878" alt="Screenshot 2026-11-09 194031" src="https://github.com/user-attachments/assets/8f1f5d25-1472-47f3-a9fd-5aa44b1de7f0" />


---

## Cara Menjalankan Proyek
1. Pastikan **JDK 21** (atau versi yang kompatibel) dan **Apache Maven** sudah terpasang di perangkat Anda.
2. *Clone* repositori ini:
   ```bash
   git clone [https://github.com/AhmdAzz/AppToko.git](https://github.com/AhmdAzz/AppToko.git)
