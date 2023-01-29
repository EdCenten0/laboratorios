/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import laboratorios_entities.Profesores;
import laboratorios_interface_DAO.Profesores_interface;

/**
 *
 * @author cchav
 */
public class Dt_profesores implements Profesores_interface{
    
    final String INSERT = "INSERT INTO profesores (nombre_profesor, apellido_profesor, codigo_profesor) VALUES (?, ?, ?)";
    final String UPDATE = "UPDATE profesores SET nombre_profesor = ?, apellido_profesor = ?, codigo_profesor = ? WHERE id = ?";
    final String DELETE = "DELETE FROM profesores WHERE id = ?";
    final String GETALL = "SELECT id, nombre_profesor, apellido_profesor, codigo_profesor FROM profesores";
    final String GETONE = "SELECT id, nombre_profesor, apellido_profesor, codigo_profesor FROM profesores WHERE id = ?";    
    private Connection conn;

    public Dt_profesores(Connection conn) {
        this.conn = conn;
    }
    
    
    

    @Override
    public void insertar(Profesores c) throws DAO_exception{
        PreparedStatement stat = null;
        
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, c.getNombre_profesor());
            stat.setString(2, c.getApellido_profesor());
            stat.setString(3, c.getCodigo_profesor());
            if(stat.executeUpdate() == 0){
                throw new DAO_exception("Puede que no se haya guardado");
            }
        } catch (SQLException e) {
            throw new DAO_exception("Error en SQL", e);
        } finally{
            if(stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAO_exception("Error al cerrar la conexion");
                }
            }
        }
    }

    @Override
    public void modificar(Profesores c) throws DAO_exception{
        PreparedStatement stat = null;
        
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, c.getNombre_profesor());
            stat.setString(2, c.getApellido_profesor());
            stat.setString(3, c.getCodigo_profesor());
            stat.setLong(4, c.getId());
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
                    throw new DAO_exception("Error al cerrar la conexion", e);
                }
            }
        }
    }

    @Override
    public void eliminar(Profesores c) throws DAO_exception{
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
                    throw new DAO_exception("Error al cerrar la conexion", e);
                }
            }
        }
    }

    private Profesores convertir_profesor(ResultSet rs) throws SQLException{
        Long id = rs.getLong("id");
        String nombre_profesor = rs.getString("nombre_profesor");
        String apellido_profesor = rs.getString("apellido_profesor");
        String codigo_profesor = rs.getString("codigo_profesor");
        Profesores profesor = new Profesores(nombre_profesor, apellido_profesor, codigo_profesor);
        profesor.setId(id);
        return profesor;
    }
    
    @Override
    public List<Profesores> obtenerTodos() throws DAO_exception{
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Profesores> c = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){
                c.add(convertir_profesor(rs));
            }
            
            
        } catch (SQLException e) {
            throw new DAO_exception("Error en SQL", e);
        } finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAO_exception("Error al cerrar la conexion de ResultSet", e);
                    
                }
            }
            
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAO_exception("Error al cerrar la conexion de PrepareStatement", e);
                }
            }
        }
       
        return c;
    }

    @Override
    public Profesores obtener(Long id) throws DAO_exception{
        PreparedStatement stat = null;
        ResultSet rs = null;
        Profesores c = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                c = convertir_profesor(rs);
            } else{
                throw new DAO_exception("No se ha encontrado ese registro");
                
            }
            
        } catch (SQLException e) {
            throw new DAO_exception("Error en SQL", e);
        } finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAO_exception("Error al cerrar la conexion de ResultSet", e);
                    
                }
            }
            
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAO_exception("Error al cerrar la conexion de PrepareStatement", e);
                }
            }
        }
       
        return c;
    
    }
    
}
