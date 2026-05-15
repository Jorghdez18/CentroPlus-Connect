package com.proyecto.repository;

import java.util.List;

import com.proyecto.model.Incidencia;

public interface IIncideniaRepository {

    /**
     * Crea una nueva incidencia
     * @param incidencia incidencia nueva
     * @return true/ false depende del resultado
     */
    boolean create(Incidencia incidencia);

    /**
     * Busca una incidencia por su id
     * @param id id de la incidencia
     * @return devuelve una incidencia
     */
    Incidencia findById(Integer id);

    /**
     * Lista todas las incidencias
     * @return lista con todas las incidencias
     */
    List<Incidencia> findAll();

    /**
     * Actualiza los datos de la incidencia
     * @param incidencia incidencia a actualizar
     * @return true/false depdende de resultado
     */
    boolean update(Incidencia incidencia);

    /**
     * Elimina una incidencia por su id
     * @param id id de la incidencia
     * @return true/false depende de resultado
     */
    boolean deleteById(Integer id);
}
