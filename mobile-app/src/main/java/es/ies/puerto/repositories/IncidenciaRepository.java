package es.ies.puerto.repositories;

import es.ies.puerto.models.Incidencia;
import java.util.ArrayList;
import java.util.List;

public class IncidenciaRepository {

    private List<Incidencia> incidencias = new ArrayList<>();

    public List<Incidencia> findAll() {
        return incidencias;
    }

    public void save(Incidencia i) {
        incidencias.add(i);
    }

    public void delete(int id) {
        for (int i = 0; i < incidencias.size(); i++) {
            if (incidencias.get(i).getId() == id) {
                incidencias.remove(i);
                break;
            }
        }
    }
}