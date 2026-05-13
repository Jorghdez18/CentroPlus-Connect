package es.ies.puerto.models;

public class Actividad {

    private int id;
    private String nombre;
    private String tipoActividad;
    private int duracionMinutos;
    private double precio;
    private int plazasMaximas;
    private int plazasOcupadas;

    public Actividad(int id, String nombre, String tipoActividad,
                     int duracionMinutos, double precio, int plazasMaximas) {
        this.id = id;
        this.nombre = nombre;
        this.tipoActividad = tipoActividad;
        this.duracionMinutos = duracionMinutos;
        this.precio = precio;
        this.plazasMaximas = plazasMaximas;
        this.plazasOcupadas = 0;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPlazasMaximas() {
        return plazasMaximas;
    }

    public int getPlazasOcupadas() {
        return plazasOcupadas;
    }
    
    public int getPlazasDisponibles() {
        return plazasMaximas - plazasOcupadas;
    }

    public boolean tienePlazas() {
        return plazasOcupadas < plazasMaximas;
    }

    public void reservarPlaza() {
        if (tienePlazas()) {
            plazasOcupadas++;
        }
    }

    public void cancelarPlaza() {
        if (plazasOcupadas > 0) {
            plazasOcupadas--;
        }
    }
}