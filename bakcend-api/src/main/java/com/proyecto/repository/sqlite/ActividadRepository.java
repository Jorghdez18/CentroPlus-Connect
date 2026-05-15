package com.proyecto.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.model.Actividad;
import com.proyecto.model.Usuario;
import com.proyecto.repository.IActividadRepository;

public class ActividadRepository extends SQLiteConnectionManager implements IActividadRepository {

    @Override
    public boolean create(Actividad actividad) {
        String sql = "INSERT INTO actividades VALUES(?,?,?,?,?,?)";

        try {
            Connection connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);

            //sentencia.setInt(1, actividad.getId());
            sentencia.setString(1, actividad.getNombre());
            sentencia.setString(2, actividad.getTipoActividad());
            sentencia.setInt(3, actividad.getDuracion());
            sentencia.setDouble(4, actividad.getPlazasMaximas());
            sentencia.setInt(5, actividad.getPlazasOcupadas());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error a la hora de crear la clase");
        }
        return true;
    }

    @Override
    public Actividad findById(Integer id) {

        Actividad actividad = null;
        String sql = "SELECT * FROM actividades WHERE id = ?";

        try {
            Connection connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String tipoActividad = resultado.getString("tipo_actividad");
                Integer duracion = resultado.getInt("duracion");
                Double precio = resultado.getDouble("precio");
                Integer plazasMaximas = resultado.getInt("plazas_maximas");
                Integer plazasOcupadas = resultado.getInt("plazas_ocupadas");
                return actividad = new Actividad(id, nombre, tipoActividad, duracion, precio, plazasMaximas,
                        plazasOcupadas);
            }
        } catch (Exception e) {
            System.err.println("error al buscar");
            return null;
        }
        return actividad;
    }

    @Override
    public List<Actividad> findAll() {

        List<Actividad> actividades = new ArrayList<>();
        Actividad actividad = null;
        String sql = "SELECT * FROM actividades";

        try {
            Connection connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);

            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String tipoActividad = resultado.getString("tipo_actividad");
                Integer duracion = resultado.getInt("duracion");
                Double precio = resultado.getDouble("precio");
                Integer plazasMaximas = resultado.getInt("plazas_maximas");
                Integer plazasOcupadas = resultado.getInt("plazas_ocupadas");
                actividad = new Actividad(id, nombre, tipoActividad, duracion, precio, plazasMaximas, plazasOcupadas);
                actividades.add(actividad);
            }
        } catch (Exception e) {
            System.err.println("error al buscar");
            return null;
        }
        return actividades;
    }

    @Override
    public boolean update(Actividad actividad) {
        String sql = "UPDATE actividades SET nombre = ?, tipo_actividad = ?, duracion=?, plazas_maximas=?, plazas_ocupadas=? WHERE id =?";

        try {
            Connection connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);

            sentencia.setString(1, actividad.getNombre());
            sentencia.setString(2, actividad.getTipoActividad());
            sentencia.setInt(3, actividad.getDuracion());
            sentencia.setDouble(4, actividad.getPlazasMaximas());
            sentencia.setInt(5, actividad.getPlazasOcupadas());
            sentencia.setInt(6, actividad.getId());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error a la hora de crear la clase");
        }
        return true;
    }

    @Override
    public boolean deleteByDni(Integer id) {
        String sql = "DELETE FROM actividades WHERE id =?";

        try {Connection connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            
            sentencia.setInt(1, id);
            return sentencia.executeUpdate() > 0;
        } catch (Exception e) {
           System.err.println("Error al eliminar");
           return false;
        }
    }

}
