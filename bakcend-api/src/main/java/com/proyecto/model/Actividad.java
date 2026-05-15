package com.proyecto.model;

import java.util.Objects;

public class Actividad {

    private Integer id;
    private String nombre;
    private String tipoActividad;
    private Integer duracion;
    private double precio;
    private Integer plazasMaximas;
    private Integer plazasOcupadas;


    public Actividad(Integer id, String nombre, String tipoActividad, Integer duracion, Double precio,
            Integer plazasMaximas, Integer plazasOcupadas) {

        this.id = id;
        this.nombre = nombre;
        this.tipoActividad = tipoActividad;
        this.duracion = duracion;
        this.precio = precio;
        this.plazasMaximas = plazasMaximas;
        this.plazasOcupadas = plazasOcupadas;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoActividad() {
        return this.tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public Integer getDuracion() {
        return this.duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getPlazasMaximas() {
        return this.plazasMaximas;
    }

    public void setPlazasMaximas(Integer plazasMaximas) {
        this.plazasMaximas = plazasMaximas;
    }

    public Integer getPlazasOcupadas() {
        return this.plazasOcupadas;
    }

    public void setPlazasOcupadas(Integer plazasOcupadas) {
        this.plazasOcupadas = plazasOcupadas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Actividad other = (Actividad) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Actividad [id=" + id + ", nombre=" + nombre + ", tipoActividad=" + tipoActividad + ", duracion="
                + duracion + ", precio=" + precio + ", plazasMaximas=" + plazasMaximas + ", plazasOcupadas="
                + plazasOcupadas + "]";
    }

    
}
