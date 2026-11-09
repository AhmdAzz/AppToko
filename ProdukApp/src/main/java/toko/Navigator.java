package toko;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import toko.controller.DaftarProdukController;
import toko.controller.DetailProdukController;
import toko.controller.FormProdukController;
import toko.data.DataProduk;
import toko.model.Produk;

public class Navigator {

    private Stage mainStage;
    private DataProduk data;
    private Scene scene;

    public Navigator(Stage mainStage, DataProduk data) {
        this.mainStage = mainStage;
        this.data = data;
    }

    private void render(Parent root) {
        if (scene == null) {
            scene = new Scene(root, 900, 680);
            scene.getStylesheets().add(getClass().getResource("/toko/styles/app.css").toExternalForm());
            mainStage.setScene(scene);
            mainStage.setTitle("Aplikasi Catat Produk Toko");
        } else {
            scene.setRoot(root);
        }
        mainStage.show();
    }

    public void bukaDaftar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/toko/daftar_produk.fxml"));
        Parent root = loader.load();
        DaftarProdukController ctrl = loader.getController();
        ctrl.setKonteks(this, data);
        render(root);
    }

    public void bukaForm() throws IOException {
        bukaForm(null);
    }

    public void bukaForm(Produk p) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/toko/form_produk.fxml"));
        Parent root = loader.load();
        FormProdukController ctrl = loader.getController();
        ctrl.setKonteks(this, data, p);
        render(root);
    }

    public void bukaDetail(Produk p) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/toko/detail_produk.fxml"));
        Parent root = loader.load();
        DetailProdukController ctrl = loader.getController();
        ctrl.setKonteks(this, data, p);
        render(root);
    }
}