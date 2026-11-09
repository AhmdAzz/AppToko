package toko.controller;

import java.io.IOException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import toko.Navigator;
import toko.data.DataProduk;
import toko.model.Produk;

public class DaftarProdukController {

    @FXML private TableView<Produk> tabel;
    @FXML private TableColumn<Produk, String> kodeCol;
    @FXML private TableColumn<Produk, String> namaCol;
    @FXML private TableColumn<Produk, String> kategoriCol;
    @FXML private TableColumn<Produk, Double> hargaCol;
    
    // Tambahan: Kolom untuk gambar
    @FXML private TableColumn<Produk, ImageView> gambarCol;
    
    @FXML private TextField cariField;
    @FXML private Label pesanLabel;
    
    private Navigator nav;
    private DataProduk data;
    private ObservableList<Produk> listTampil = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        kodeCol.setCellValueFactory(new PropertyValueFactory<>("kode"));
        namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kategoriCol.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        hargaCol.setCellValueFactory(new PropertyValueFactory<>("harga"));
        
        // Tambahan: Mengatur sel kolom gambar
        gambarCol.setCellValueFactory(cellData -> {
            String imagePath = cellData.getValue().getImagePath(); // Pastikan getter sesuai dengan di Produk.java
            if (imagePath != null && !imagePath.isEmpty()) {
                ImageView imgView = new ImageView(new Image(imagePath));
                imgView.setFitHeight(50); // Tinggi thumbnail
                imgView.setFitWidth(50);  // Lebar thumbnail
                imgView.setPreserveRatio(true);
                return new SimpleObjectProperty<>(imgView);
            }
            return new SimpleObjectProperty<>(null);
        });

        tabel.setItems(listTampil);
        tabel.setPlaceholder(new Label("Belum ada data produk."));
    }

    public void setKonteks(Navigator nav, DataProduk data) {
        this.nav = nav;
        this.data = data;
        cari();
    }

    @FXML
    private void cari() {
        if (data == null) return;
        listTampil.clear();
        String keyword = cariField.getText().trim().toLowerCase();

        for (Produk p : data.getListProduk()) {
            if (p.getNama().toLowerCase().contains(keyword)) {
                listTampil.add(p);
            }
        }
        pesanLabel.setText("Jumlah produk yang tampil: " + listTampil.size());
    }

    @FXML
    private void tambah() {
        try {
            nav.bukaForm();
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka form.");
            e.printStackTrace();
        }
    }

    @FXML
    private void detail() {
        Produk p = tabel.getSelectionModel().getSelectedItem();
        if (p == null) {
            pesanLabel.setText("Pilih baris di tabel dulu!");
            return;
        }
        try {
            nav.bukaDetail(p);
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka detail.");
            e.printStackTrace();
        }
    }

    @FXML
    private void edit() {
        Produk p = tabel.getSelectionModel().getSelectedItem();
        if (p == null) {
            pesanLabel.setText("Pilih produk yang mau diedit!");
            return;
        }
        try {
            nav.bukaForm(p);
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka form edit.");
            e.printStackTrace();
        }
    }

    @FXML
    private void hapus() {
        Produk p = tabel.getSelectionModel().getSelectedItem();
        if (p == null) {
            pesanLabel.setText("Pilih produk yang mau dihapus!");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, 
                "Hapus produk " + p.getNama() + " (" + p.getKode() + ")?", 
                ButtonType.YES, ButtonType.NO);
        alert.initOwner(tabel.getScene().getWindow());
        
        if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
            data.hapusData(p);
            cari();
            pesanLabel.setText("Data berhasil dihapus.");
        }
    }
}