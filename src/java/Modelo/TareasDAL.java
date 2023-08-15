/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;



import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jc997
 */
public class TareasDAL {

    Connection conexion;

    public TareasDAL() {
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }

    public List<Tareas> listarTareas() {

        PreparedStatement ps;
        ResultSet rs;

        List<Tareas> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT id, titulo, descripcion, hora FROM tareas");
            rs = ps.executeQuery();

            while (rs.next()) {
               

                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String descripcion;
                descripcion = rs.getString("descripcion");
                String hora  = rs.getString("hora");

                

                Tareas tarea = new Tareas(id, titulo, descripcion, hora);
                lista.add(tarea);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al listar tareas: " + e.toString());
            return null;
        }
    }

    /**
     *
     * @param _id
     * @return
     */
    public Tareas MostarTareas(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        Tareas tarea = null;


        try {
            ps = conexion.prepareStatement("SELECT id, codigo, nombre, precio FROM tareas WHERE id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String hora = rs.getString("hora");

                tarea = new Tareas(id, titulo, descripcion, hora);
            }
            return tarea;
        } catch (SQLException e) {
            System.out.println("Error al mostrar tarea: " + e.toString());
            return null;
        }
    }

     public boolean Insertar(Tareas tarea) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("INSERT INTO tareas (titulo, descripcion, hora) VALUES (?,?,?)");
            ps.setString(1, tarea.getTitulo());
            ps.setString(2, tarea.getDescripcion());
            ps.setString(3, tarea.getHora());
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar tarea: " + e.toString());
            return false;
        }
    }

    public boolean Actualizar(Tareas tarea) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("UPDATE tareas SET titulo=?, descripcion=?, hora=? WHERE id=?");
            ps.setString(1, tarea.getTitulo());
            ps.setString(2, tarea.getDescripcion());
            ps.setString(3, tarea.getHora());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean Eliminar(int _id) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("DELETE FROM tareas WHERE id=?");
            ps.setInt(1, _id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al Eliminar tarea: " + e.toString());
            return false;
        }
    }

}