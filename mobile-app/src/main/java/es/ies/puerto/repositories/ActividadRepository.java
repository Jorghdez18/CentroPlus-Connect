package es.ies.puerto.repositories;

import es.ies.puerto.models.Actividad;
import java.util.ArrayList;
import java.util.List;

public class ActividadRepository {

    private List<Actividad> actividades = new ArrayList<>();

    public List<Actividad> findAll() {
        return actividades;
    }

    public Actividad findById(int id) {
        for (Actividad actividad : actividades) {
            if (actividad.getId() == id) {
                return actividad;
            }
        }
        return null;
    }

    public void save(Actividad actividad) {
        actividades.add(actividad);
    }

    public void delete(int id) {
        for (int i = 0; i < actividades.size(); i++) {
            if (actividades.get(i).getId() == id) {
                actividades.remove(i);
                break;
            }
        }
    }
}