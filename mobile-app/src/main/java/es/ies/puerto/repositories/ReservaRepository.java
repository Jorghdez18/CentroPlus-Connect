package es.ies.puerto.repositories;

import es.ies.puerto.models.Reserva;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {

    private List<Reserva> reservas = new ArrayList<>();

    public List<Reserva> findAll() {
        return reservas;
    }

    public void save(Reserva r) {
        reservas.add(r);
    }

    public void delete(int id) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getId() == id) {
                reservas.remove(i);
                break;
            }
        }
    }
}