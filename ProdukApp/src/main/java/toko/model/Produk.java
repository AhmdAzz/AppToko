package toko.model;

public class Produk {

    private String kode;
    private String nama;
    private String kategori;
    private double harga;
    private String imagePath;


    public Produk(String kode, String nama, String kategori, double harga, String imagePath) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong!");
        }
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari 0!");
        }
        this.kode = kode;
        this.nama = nama.trim();
        this.kategori = kategori;
        this.harga = harga;
        this.imagePath = imagePath;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public double getHarga() {
        return harga;
    }
    
    public String getImagePath() {
        return imagePath;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}