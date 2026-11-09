package toko;

import javafx.application.Application;
import javafx.stage.Stage;
import toko.data.DataProduk;

public class MainApp extends Application {

    @Override
    public void start(Stage mainStage) throws Exception {
        DataProduk data = new DataProduk();
        Navigator nav = new Navigator(mainStage, data);
        nav.bukaDaftar();
    }

    public static void main(String[] args) {
        launch(args);
    }
}