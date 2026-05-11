package com.centroplus.mobile;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/centroplus/mobile/views/MainView.fxml"
                )
        );

        Scene scene = new Scene(
                loader.load(),
                1000,
                650
        );

        scene.getStylesheets().add(
                getClass()
                        .getResource(
                                "/com/centroplus/mobile/views/styles.css"
                        )
                        .toExternalForm()
        );

        stage.setTitle("CentroPlus Connect");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}