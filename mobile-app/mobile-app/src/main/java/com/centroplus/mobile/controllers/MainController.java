package com.centroplus.mobile.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import com.centroplus.mobile.models.Actividad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainController {

    @FXML
    private Label labelTitulo;

    @FXML
    private ListView<String> listaActividades;

    private ObservableList<Actividad> actividades;

    @FXML
    public void initialize() {
        actividades = FXCollections.observableArrayList(
                new Actividad(1, "Yoga", "Deporte", 60, 200, 18, 65),
                new Actividad(2, "Pilates", "Deporte", 50, 180, 18, 60),
                new Actividad(3, "Meditación", "Bienestar", 30, 50, 15, 99),
                new Actividad(4, "Spinning", "Deporte", 45, 400, 18, 50)
        );

        actualizarLista(actividades);
    }

    private void actualizarLista(ObservableList<Actividad> lista) {
        listaActividades.getItems().clear();
        for (Actividad a : lista) {
            listaActividades.getItems().add(a.getNombre() + " (" + a.getTipo() + ") - " + a.getDuracion() + " min");
        }
    }

    @FXML
    private void filtrarDeportes() {
        ObservableList<Actividad> deportes = FXCollections.observableArrayList();
        for (Actividad a : actividades) {
            if ("Deporte".equals(a.getTipo())) {
                deportes.add(a);
            }
        }
        actualizarLista(deportes);
    }
}