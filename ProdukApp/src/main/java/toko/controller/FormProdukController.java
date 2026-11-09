package toko.controller;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import toko.Navigator;
import toko.data.DataProduk;
import toko.model.Produk;
import javafx.stage.FileChooser;

public class FormProdukController {

    @FXML private Label judulFormLabel;
    @FXML private TextField namaField;
    @FXML private TextField hargaField;
    @FXML private ComboBox<String> jenisBox;
    @FXML private Label pesanLabel;
    @FXML private ImageView imageViewPreview;
    
    private Navigator nav;
    private DataProduk data;
    private Produk pEdit;
    
    // Tambahan: Variabel untuk menyimpan path gambar
    private String selectedImagePath = "";

    @FXML
    private void initialize() {
        jenisBox.getItems().clear();
        jenisBox.getItems().addAll("Makanan", "Minuman");
        jenisBox.setValue("Makanan");
    }

    public void setKonteks(Navigator nav, DataProduk data, Produk pEdit) {
        this.nav = nav;
        this.data = data;
        this.pEdit = pEdit;

        if (pEdit != null) {
            judulFormLabel.setText("Edit Produk (" + pEdit.getKode() + ")");
            namaField.setText(pEdit.getNama());
            jenisBox.setValue(pEdit.getKategori());
            hargaField.setText(String.valueOf(pEdit.getHarga()));
            
            // Tambahan: Menampilkan gambar saat mode Edit
            selectedImagePath = pEdit.getImagePath(); // Pastikan method ini sesuai dengan getter di Produk.java
            if (selectedImagePath != null && !selectedImagePath.isEmpty()) {
                imageViewPreview.setImage(new Image(selectedImagePath));
            } else {
                imageViewPreview.setImage(null);
            }
        } else {
            judulFormLabel.setText("Tambah Produk Baru");
            namaField.clear();
            hargaField.clear();
            
            // Tambahan: Mengosongkan form gambar saat mode Tambah
            selectedImagePath = "";
            imageViewPreview.setImage(null);
        }
    }

    // Tambahan: Method untuk tombol "Pilih Gambar"
    @FXML
    private void pilihGambar() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih Gambar Produk");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        // Menampilkan dialog open file
        File selectedFile = fileChooser.showOpenDialog(imageViewPreview.getScene().getWindow());

        if (selectedFile != null) {
            // Mengubah file menjadi format URI string agar terbaca oleh Image JavaFX
            selectedImagePath = selectedFile.toURI().toString();
            // Tampilkan ke ImageView
            imageViewPreview.setImage(new Image(selectedImagePath));
        }
    }

    @FXML
    private void simpan() {
        if (data == null) return;
        try {
            String nama = namaField.getText().trim();
            String kat = jenisBox.getValue();
            double harga = Double.parseDouble(hargaField.getText().trim());
            
            // Perbaikan: Ambil path gambar dari variabel selectedImagePath
            String imagePath = selectedImagePath;

            if (pEdit == null) {
                // Pastikan fungsi tambahData di DataProduk sudah menerima parameter imagePath
                Produk pBaru = data.tambahData(nama, kat, harga, imagePath);
                nav.bukaDetail(pBaru);
            } else {
                // Pastikan fungsi editData di DataProduk sudah menerima parameter imagePath
                data.editData(pEdit, nama, kat, harga, imagePath);
                Produk pUbah = new Produk(pEdit.getKode(), nama, kat, harga, imagePath);
                nav.bukaDetail(pUbah);
            }
        } catch (NumberFormatException e) {
            pesanLabel.setText("Harga harus berupa angka!");
        } catch (IllegalArgumentException e) {
            pesanLabel.setText(e.getMessage());
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka halaman.");
            e.printStackTrace();
        }
    }

    @FXML
    private void bukaDaftar() {
        try {
            nav.bukaDaftar();
        } catch (IOException e) {
            pesanLabel.setText("Gagal kembali.");
            e.printStackTrace();
        }
    }
}