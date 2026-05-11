package com.centroplus.mobile.services;

import com.centroplus.mobile.models.Actividad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ActividadService {

        private final ObservableList<Actividad> actividades = FXCollections.observableArrayList();

        public ActividadService() {
                cargarDatosIniciales();
        }

        private void cargarDatosIniciales() {

                actividades.add(new Actividad(
                                1,
                                "Yoga",
                                "Deporte",
                                60,
                                20.0,
                                30,
                                10));

                actividades.add(new Actividad(
                                2,
                                "Pilates",
                                "Deporte",
                                45,
                                18.0,
                                25,
                                8));

                actividades.add(new Actividad(
                                3,
                                "Programación Java",
                                "Académica",
                                120,
                                50.0,
                                25,
                                20));

                actividades.add(new Actividad(
                                4,
                                "Base de Datos",
                                "Académica",
                                90,
                                40.0,
                                20,
                                12));
        }

        public ObservableList<Actividad> obtenerActividades() {
                return actividades;
        }

        public ObservableList<Actividad> obtenerSoloDeportes() {

                ObservableList<Actividad> deportes = FXCollections.observableArrayList();

                for (Actividad a : actividades) {

                        if (a.getTipoActividad()
                                        .equalsIgnoreCase("Deporte")) {

                                deportes.add(a);
                        }
                }

                return deportes;
        }

        public ObservableList<Actividad> obtenerSoloAcademicas() {

                ObservableList<Actividad> academicas = FXCollections.observableArrayList();

                for (Actividad a : actividades) {

                        if (a.getTipoActividad()
                                        .equalsIgnoreCase("Académica")) {

                                academicas.add(a);
                        }
                }

                return academicas;
        }
}