package com.centroplus.mobile.controllers;

import com.centroplus.mobile.models.Actividad;
import com.centroplus.mobile.models.Reserva;
import com.centroplus.mobile.services.ActividadService;
import com.centroplus.mobile.services.ReservaService;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class MainController {

    @FXML
    private ListView<Actividad> listaActividades;

    @FXML
    private ListView<Reserva> listaReservas;

    private ActividadService actividadService;
    private ReservaService reservaService;

    private ObservableList<Actividad> actividades;

    @FXML
    public void initialize() {

        actividadService = new ActividadService();
        reservaService = new ReservaService();

        actividades = actividadService.obtenerActividades();
        listaActividades.setItems(actividades);

        listaReservas.setItems(
                reservaService.obtenerReservas()
        );
    }

    @FXML
    private void reservarActividad() {

        Actividad actividad =
                listaActividades.getSelectionModel().getSelectedItem();

        if (actividad == null) {
            mostrarAlerta("Selecciona una actividad");
            return;
        }

        Reserva nueva = new Reserva(
                listaReservas.getItems().size() + 1,
                "Usuario",
                actividad.getNombre(),
                "2026-05-11",
                "ACTIVA"
        );

        listaReservas.getItems().add(nueva);

        mostrarAlerta("Reserva realizada correctamente");
    }

    @FXML
    private void cancelarReserva() {

        Reserva reserva =
                listaReservas.getSelectionModel().getSelectedItem();

        if (reserva == null) {
            mostrarAlerta("Selecciona una reserva");
            return;
        }

        listaReservas.getItems().remove(reserva);

        mostrarAlerta("Reserva cancelada");
    }

    @FXML
    private void mostrarFormularioIncidencia() {

        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Incidencia");

        TextField asunto = new TextField();
        TextArea descripcion = new TextArea();

        VBox box = new VBox(
                10,
                new Label("Asunto"),
                asunto,
                new Label("Descripción"),
                descripcion
        );

        box.setPadding(new Insets(20));

        dialog.getDialogPane().setContent(box);

        dialog.getDialogPane().getButtonTypes().addAll(
                ButtonType.OK,
                ButtonType.CANCEL
        );

        dialog.showAndWait();

        mostrarAlerta("Incidencia enviada correctamente");
    }

    private void mostrarAlerta(String msg) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}