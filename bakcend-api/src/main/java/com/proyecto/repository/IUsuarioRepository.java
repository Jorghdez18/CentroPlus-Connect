package com.proyecto.repository;

import java.util.List;

import com.proyecto.model.Usuario;

public interface IUsuarioRepository {

    /**
     * Crea un usuario nuevo
     * @param usuario usuario nuevo
     * @return true/false depdende de resultado
     */
    boolean create(Usuario usuario);

    /**
     * Busca un usuario por su id
     * @param id id del usuario
     * @return usuario encontrado
     */
    Usuario findById(Integer id);

    /**
     * Lista todos los usuarios
     * @return todos los usuarios
     */
    List<Usuario> findAll();

     /**
     * Actualiza un Usuario
     * @param usuario usuario a actualizar
     * @return true/false depdende de resultado
     */
    boolean update(Usuario usuario);

     /**
     * Elimina un usuario segun su id 
     * @param id dni del cliente
     * @return true / false segun resultado
     */
    boolean deleteById(Integer id);
    
}
