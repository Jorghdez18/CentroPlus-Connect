package com.proyecto.repository;

import java.util.List;

import com.proyecto.model.Actividad;

public interface IActividadRepository {

    /**
     * Crea una actividad para el centro 
     * @param actividad actividad nueva
     * @return true/false depende del resultado
     */
    boolean create(Actividad actividad);

    /**
     * Busca por id de la actividad
     * @param id id de la actividad
     * @return actividad encontrada
     */
    Actividad findById(Integer id);

    /**
     * Lista todas las actividades
     * @return lista con todas las actividades
     */
    List<Actividad> findAll();

    /**
     * Actualiza una actividad
     * @param actividad actividad a actualizar
     * @return true/false depende del resultado
     */
    boolean update(Actividad actividad);

    /**
     * Elimina una actividad por su id
     * @param id id de la actividad
     * @return true/ false depende de resultado
     */
    boolean deleteByDni(Integer id);



    
}
