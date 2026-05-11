package com.proyecto.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.model.Incidencia;
import com.proyecto.repository.IIncideniaRepository;

public class IncideniaRepository extends SQLiteConnectionManager implements IIncideniaRepository {

    @Override
    public boolean create(Incidencia incidencia) {
        String sql = "INSERT INTO incidencias VALUES (?,?,?,?,?)";
        try {
            Connection connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);

            sentencia.setInt(1, incidencia.getIdUsuario());
            sentencia.setString(2, incidencia.getAsunto());
            sentencia.setString(3, incidencia.getDescripcion());
            sentencia.setString(4, incidencia.getFecha());
            sentencia.setString(5, incidencia.getEstado());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error al crear un");
            return false;
        }

    }

    @Override
    public Incidencia findById(Integer id) {

        Incidencia incidenciaEncontrada = null;
        String sql = "SELECT * FROM incidencias WHERE id =?";

        try {
            Connection connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Integer idUsuario = resultado.getInt("id_usuario");
                String asunto = resultado.getString("asunto");
                String descripcion = resultado.getString("descripcion");
                String fecha = resultado.getString("fecha");
                String estado = resultado.getString("estado");

                return incidenciaEncontrada = new Incidencia(id, idUsuario, asunto, descripcion, fecha, estado);
            }
        } catch (Exception e) {
            System.err.println("Error al encontrar la incidencia");
            return null;
        }
        return incidenciaEncontrada;
    }

    @Override
    public List<Incidencia> findAll() {
        Incidencia incidencia = null;
        List<Incidencia> incidencias = new ArrayList<>();
        String sql = "SELECT * FROM incidencias";

        try {
            Connection connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Integer idUsuario = resultado.getInt("id_usuario");
                String asunto = resultado.getString("asunto");
                String descripcion = resultado.getString("descripcion");
                String fecha = resultado.getString("fecha");
                String estado = resultado.getString("estado");

                incidencia = new Incidencia(id, idUsuario, asunto, descripcion, fecha, estado);
                incidencias.add(incidencia);
            }
        } catch (Exception e) {
            System.err.println("Error al encontrar la incidencia");
            return null;
        }
        return incidencias;
    }

    @Override
    public boolean update(Incidencia incidencia) {
        String sql = "UPDATE incidencias SET id_usuario=?, asunto=?, descripcion=?, fecha=?, estado=? WHERE id = ?";
        try {
            Connection connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);

            sentencia.setInt(1, incidencia.getIdUsuario());
            sentencia.setString(2, incidencia.getAsunto());
            sentencia.setString(3, incidencia.getDescripcion());
            sentencia.setString(4, incidencia.getFecha());
            sentencia.setString(5, incidencia.getEstado());
            sentencia.setInt(6, incidencia.getId());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error al actualizar");
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        String sql = "DELETE FROM incidencias WHERE id =?";

        try {
            Connection connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);

            sentencia.setInt(1, id);
            return sentencia.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error al eliminar");
            return false;
        }
    }

}
