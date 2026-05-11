package com.centroplus.mobile.models;

public class Reserva {

    private int id;
    private String usuario;
    private String actividad;
    private String fecha;
    private String estado;

    public Reserva(int id,
            String usuario,
            String actividad,
            String fecha,
            String estado) {

        this.id = id;
        this.usuario = usuario;
        this.actividad = actividad;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getActividad() {
        return actividad;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {

        return actividad +
                " | " +
                fecha +
                " | " +
                estado;
    }
}