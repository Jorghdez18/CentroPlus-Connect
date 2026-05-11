package com.centroplus.mobile.services;

import com.centroplus.mobile.models.Reserva;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReservaService {

    private final ObservableList<Reserva> reservas =
            FXCollections.observableArrayList();

    public ReservaService() {

        reservas.add(new Reserva(
                1,
                "Usuario",
                "Yoga",
                "2026-05-11",
                "ACTIVA"
        ));
    }

    public ObservableList<Reserva> obtenerReservas() {
        return reservas;
    }
}