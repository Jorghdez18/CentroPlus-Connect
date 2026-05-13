package es.ies.puerto.services;

import es.ies.puerto.models.Reserva;
import es.ies.puerto.repositories.ReservaRepository;

import java.time.LocalDate;
import java.util.List;

public class ReservaService {

    private ReservaRepository repo = new ReservaRepository();

    public List<Reserva> findAll() {
        return repo.findAll();
    }

    public boolean crearReserva(int id, int idUsuario, int idActividad) {

        List<Reserva> lista = repo.findAll();

        for (Reserva r : lista) {
            if (r.getIdUsuario() == idUsuario &&
                r.getIdActividad() == idActividad) {
                return false; // duplicada
            }
        }

        Reserva nueva = new Reserva(id, idUsuario, idActividad,
                LocalDate.now(), "ACTIVA");

        repo.save(nueva);
        return true;
    }

    public void cancelarReserva(int id) {
        repo.delete(id);
    }
}