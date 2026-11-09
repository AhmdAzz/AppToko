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

![1. Halaman Awal Daftar Produk](Screenshot%202026-11-09%20145201.png)

### 2. Menambahkan Produk Baru
Pengguna menekan tombol **Tambah Produk Baru** untuk membuka halaman form. Di sini pengguna mengisi nama produk (contoh: *Roti*), memilih kategori (*Makanan* / *Minuman*), memasukkan harga, serta memilih foto produk melalui tombol **Upload IMG** sebelum menekan **Simpan Produk**.

![2. Form Tambah Produk Baru](Screenshot%202026-11-09%20193551.png)

### 3. Halaman Detail Produk
Setelah produk baru disimpan, aplikasi secara otomatis mengarahkan pengguna ke halaman **Detail Produk Toko** untuk menampilkan rincian data yang baru saja dibuat beserta kode otomatisnya (`PRD001`) dan foto produk.

![3. Detail Produk Baru](Screenshot%202026-11-09%20193704.png)

### 4. Melihat Daftar Produk di Tabel
Pengguna kembali ke halaman daftar dengan menekan tombol **Kembali ke Daftar** atau **Lihat Daftar**. Produk yang telah ditambahkan kini tampil di dalam tabel lengkap dengan pratinjau gambar (*thumbnail*).

![4. Daftar Produk Setelah Ditambah](Screenshot%202026-11-09%20193625.png)

### 5. Mengubah (Edit) Data Produk
Pengguna memilih baris produk pada tabel lalu menekan tombol **Edit Produk**. Aplikasi membuka kembali halaman form yang sudah terisi data produk sebelumnya (`Edit Produk (PRD001)`), sehingga pengguna dapat memperbarui informasi yang diinginkan.

![5. Form Edit Produk](Screenshot%202026-11-09%20193648.png)

### 6. Detail Produk Setelah Diedit
Begitu perubahan disimpan, aplikasi kembali menampilkan halaman **Detail Produk Toko** secara otomatis untuk memperlihatkan hasil pembaruan data (contoh: nama produk berhasil diubah menjadi *Sari Roti*).

![6. Detail Produk Setelah Edit](Screenshot%202026-11-09%20193704%20edit.png)

### 7. Mengecek Keseluruhan Data di Daftar Produk
Pengguna membuka kembali halaman **Daftar Produk Toko** untuk mengecek data yang sudah diperbarui maupun melihat daftar produk lainnya yang telah ditambahkan ke dalam tabel (`PRD001`, `PRD002`, `PRD003`).

![7. Mengecek Daftar Produk](Screenshot%202026-11-09%20193934.png)

### 8. Konfirmasi Menghapus Produk
Untuk menghapus produk, pengguna memilih salah satu baris produk pada tabel (contoh: *Le Mineral - PRD003*) lalu menekan tombol **Hapus**. Sistem akan memunculkan kotak dialog konfirmasi (*Confirmation Alert*) untuk mencegah penghapusan yang tidak disengaja.

![8. Konfirmasi Hapus Produk](Screenshot%202026-11-09%20194018.png)

### 9. Daftar Produk Setelah Dihapus
Setelah pengguna menekan tombol **Yes** pada dialog konfirmasi, produk tersebut terhapus dari tabel dan aplikasi menampilkan pesan status *"Data berhasil dihapus."* di bagian bawah layar.

![9. Hasil Setelah Produk Dihapus](Screenshot%202026-11-09%20194031.png)

---

## Cara Menjalankan Proyek
1. Pastikan **JDK 21** (atau versi yang kompatibel) dan **Apache Maven** sudah terpasang di perangkat Anda.
2. *Clone* repositori ini:
   ```bash
   git clone [https://github.com/AhmdAzz/AppToko.git](https://github.com/AhmdAzz/AppToko.git)
