/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import laboratorios_entities.Clases_por_profesor;
import laboratorios_interface_DAO.Clases_por_profesor_interface;

/**
 *
 * @author cchav
 */
public class Dt_clases_por_profesor implements Clases_por_profesor_interface{
    
    final String INSERT = "INSERT INTO clases_por_profesor (id_profesor, id_clase) VALUES (?, ?)";
    final String UPDATE = "UPDATE clases_por_profesor SET id_profesor = ?, id_clase = ? WHERE id = ?";
    final String DELETE = "DELETE FROM clases_por_profesor WHERE id = ?";
    final String GETALL = "SELECT id, codigo_clase, nombre_clase, cantidad_estudiantes_clase, cantidad_creditos FROM clases";
    final String GETONE = "SELECT id, codigo_clase, nombre_clase, cantidad_estudiantes_clase, cantidad_creditos WHERE id = ?";    
    private Connection conn;

    @Override
    public void insertar(Clases_por_profesor c) throws DAO_exception{
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, c.getId_profesor());
            stat.setLong(2, c.getId_clase());
            if(stat.executeUpdate() == 0){
               throw new DAO_exception("Puede que no se haya guardado");
            }
        } catch (SQLException e) {
            throw new DAO_exception("Error en SQL", e);
        }finally{
            
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAO_exception("Error en SQL", e);
                }
            }
        }
    }

    @Override
    public void modificar(Clases_por_profesor c) throws DAO_exception{
       PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setLong(1, c.getId_profesor());
            stat.setLong(2, c.getId_clase());
            stat.setLong(3, c.getId());
            if(stat.executeUpdate() == 0){
               throw new DAO_exception("Puede que no se haya guardado");
            }
        } catch (SQLException e) {
            throw new DAO_exception("Error en SQL", e);
        } finally{
            
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAO_exception("Error en SQL", e);
                }
            }
        }
    }

    @Override
    public void eliminar(Clases_por_profesor c) throws DAO_exception{
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, c.getId());
            if(stat.executeUpdate() == 0){
               throw new DAO_exception("Puede que no se haya guardado");
            }
        } catch (SQLException e) {
            throw new DAO_exception("Error en SQL", e);
        } finally{
            
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAO_exception("Error en SQL", e);
                }
            }
        }
    }

    @Override
    public List<Clases_por_profesor> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Clases_por_profesor obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
