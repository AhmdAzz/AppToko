package toko.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import toko.Navigator;
import toko.data.DataProduk;
import toko.model.Produk;

public class DetailProdukController {

    @FXML private Label kodeLabel;
    @FXML private Label namaLabel;
    @FXML private Label kategoriLabel;
    @FXML private Label hargaLabel;
    @FXML private Label pesanLabel;
    @FXML private ImageView imageViewDetail;

    private Navigator nav;
    private DataProduk data;
    private Produk p;

    public void setKonteks(Navigator nav, DataProduk data, Produk p) {
        this.nav = nav;
        this.data = data;
        this.p = p;

        if (p != null) {
            if (kodeLabel != null) kodeLabel.setText(p.getKode());
            if (namaLabel != null) namaLabel.setText(p.getNama());
            if (kategoriLabel != null) kategoriLabel.setText(p.getKategori());
            if (hargaLabel != null) hargaLabel.setText(String.valueOf(p.getHarga()));
            
            if (imageViewDetail != null) {
                String imagePath = p.getImagePath(); 
                if (imagePath != null && !imagePath.isEmpty()) {
                    imageViewDetail.setImage(new Image(imagePath));
                } else {
                    imageViewDetail.setImage(null);
                }
            }
        }
    }

    @FXML
    private void edit() {
        if (p == null) return;
        try {
            nav.bukaForm(p);
        } catch (IOException e) {
            if (pesanLabel != null) pesanLabel.setText("Gagal membuka form edit.");
            e.printStackTrace();
        }
    }

    @FXML
    private void bukaDaftar() {
        try {
            nav.bukaDaftar();
        } catch (IOException e) {
            if (pesanLabel != null) pesanLabel.setText("Gagal kembali ke daftar.");
            e.printStackTrace();
        }
    }
}
