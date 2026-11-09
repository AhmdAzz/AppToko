package toko.data;

import java.util.HashSet;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import toko.model.Produk;

public class DataProduk {

    private ObservableList<Produk> listProduk = FXCollections.observableArrayList();

    public DataProduk() {
        // data kosong di awal
    }

    public ObservableList<Produk> getListProduk() {
        return listProduk;
    }

    // buat auto kode PRD001 dst
    private String genKode() {
        Set<Integer> set = new HashSet<>();
        for (Produk p : listProduk) {
            if (p.getKode() != null && p.getKode().startsWith("PRD")) {
                try {
                    int val = Integer.parseInt(p.getKode().substring(3));
                    set.add(val);
                } catch (Exception e) {}
            }
        }

        int i = 1;
        while (set.contains(i)) {
            i++;
        }
        return String.format("PRD%03d", i);
    }

    public Produk tambahData(String nama, String kategori, double harga, String imagePath) {
        String kode = genKode();
        Produk baru = new Produk(kode, nama, kategori, harga, imagePath);
        listProduk.add(baru);
        return baru;
    }

    public void editData(Produk lama, String nama, String kategori, double harga, String imagePath) {
        int idx = listProduk.indexOf(lama);
        if (idx != -1) {
            Produk ubah = new Produk(lama.getKode(), nama, kategori, harga, imagePath);
            listProduk.set(idx, ubah);
        }
    }

    public void hapusData(Produk p) {
        listProduk.remove(p);
    }
}