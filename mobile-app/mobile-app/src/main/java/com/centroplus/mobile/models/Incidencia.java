package com.centroplus.mobile.models;

public class Incidencia {

    private int id;
    private String asunto;
    private String descripcion;
    private String estado;

    public Incidencia(int id,
            String asunto,
            String descripcion,
            String estado) {

        this.id = id;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {

        return asunto + " | " + estado;
    }
}