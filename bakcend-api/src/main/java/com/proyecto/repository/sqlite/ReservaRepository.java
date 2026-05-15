package com.proyecto.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.model.Reserva;
import com.proyecto.repository.IReservaRepository;

public class ReservaRepository extends SQLiteConnectionManager implements IReservaRepository {


    @Override
    public boolean create(Reserva reserva) {
        String sql = "INSERT INTO reservas VALUES (?,?,?,?)";
        try {Connection connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);

            sentencia.setInt(1, reserva.getId());
            sentencia.setInt(2,reserva.getIdActividad());
            sentencia.setString(3, reserva.getFecha());
            sentencia.setString(4, reserva.getEstado());
            return sentencia.executeUpdate()> 0;
            
        } catch (Exception e) {
            System.err.println("Error al crear un cliente nuevo");
            return false;
        }
    }

    @Override
    public Reserva findById(Integer id) {

        Reserva reservaEncontrado = null;
        String  sql = "SELECT * FROM reservas WHERE id =?";

        try {Connection connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Integer idUsuario = resultado.getInt("id_usuario");
                Integer idActividad = resultado.getInt("id_actividad");
                String fecha = resultado.getString("fecha");
                String estado = resultado.getString("estado");
                
                return reservaEncontrado = new Reserva(id, idUsuario, idActividad, fecha, estado);
            }

            
        } catch (Exception e) {
            System.err.println("Error al encontrar el cliente");
            return null;
        }
        return reservaEncontrado;
    }

    @Override
    public List<Reserva> findAll() {
        List <Reserva> reservas = new ArrayList<>();
        Reserva reserva = null;
        String  sql = "SELECT * FROM reservas WHERE id =?";

        try {Connection connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
           
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Integer idUsuario = resultado.getInt("id_usuario");
                Integer idActividad = resultado.getInt("id_actividad");
                String fecha = resultado.getString("fecha");
                String estado = resultado.getString("estado");
                
                reserva = new Reserva(id, idUsuario, idActividad, fecha, estado);
                reservas.add(reserva);
            }

            
        } catch (Exception e) {
            System.err.println("Error al encontrar el cliente");
            return null;
        }
        return reservas;
    }

    @Override
    public boolean update(Reserva reserva) {
       String sql = "UPDATE reservas SET id_actividad=?, fecha=?, estado=? WHERE id = ?";
        try {Connection connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);

            
            sentencia.setInt(1,reserva.getIdActividad());
            sentencia.setString(2, reserva.getFecha());
            sentencia.setString(3, reserva.getEstado());
            sentencia.setInt(4, reserva.getId());
            return sentencia.executeUpdate()> 0;
            
        } catch (Exception e) {
            System.err.println("Error al crear un cliente nuevo");
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        String sql = "DELETE FROM reservas WHERE id =?";

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
