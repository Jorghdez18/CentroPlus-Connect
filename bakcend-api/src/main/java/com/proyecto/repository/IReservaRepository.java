package com.proyecto.repository;

import java.util.List;

import com.proyecto.model.Reserva;

public interface IReservaRepository {

    /**
     * Crea una reserva nueva
     * @param reserva reserva a crear
     * @return true/false depende de resultado
     */
    boolean create(Reserva reserva);

    /**
     * Busca reserva por id 
     * @param id id de la reserva
     * @return reserva encontrada
     */
    Reserva findById(Integer id);

    /**
     * Lista todas las reservas que hay
     * @return todas las reservas
     */
    List<Reserva> findAll();

    /**
     * Actualiza una reserva
     * @param reserva reserva a actualizar
     * @return true/false depende de resultado
     */
    boolean update(Reserva reserva);

    /**
     * Elimina una reserva por su id 
     * @param id id de la reserva
     * @return true/false depende del resultado
     */
    boolean deleteById(Integer id);
}
