package com.centroplus.mobile.models;

public class Actividad {
    private int id;
    private String nombre;
    private String tipo;
    private int duracion;
    private int calorias;
    private int edadMin;
    private int edadMax;

    public Actividad(int id, String nombre, String tipo, int duracion, int calorias, int edadMin, int edadMax) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracion = duracion;
        this.calorias = calorias;
        this.edadMin = edadMin;
        this.edadMax = edadMax;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getCalorias() {
        return calorias;
    }

    public int getEdadMin() {
        return edadMin;
    }

    public int getEdadMax() {
        return edadMax;
    }
}