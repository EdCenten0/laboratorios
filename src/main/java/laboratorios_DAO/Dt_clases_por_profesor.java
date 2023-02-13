/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import laboratorios_entities.Clases_por_profesor;
import laboratorios_interface_DAO.Clases_por_profesor_interface;

/**
 *
 * @author cchav
 */
public class Dt_clases_por_profesor implements Clases_por_profesor_interface{
    
    final String INSERT = "INSERT INTO laboratorios.clases_por_profesor (id_profesor, id_clase) VALUES (?, ?)";
    final String UPDATE = "UPDATE laboratorios.clases_por_profesor SET id_profesor = ?, id_clase = ? WHERE id = ?";
    final String DELETE = "DELETE FROM laboratorios.clases_por_profesor WHERE id = ?";
    final String GETALL = "SELECT * FROM laboratorios.clases_por_profesor";
    final String GETONE = "SELECT * FROM laboratorios.clases_por_profesor WHERE id = ?";     
    private Connection conn;

    public Dt_clases_por_profesor(Connection conn) {
        this.conn = conn;
    }

    
    
    
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

    private Clases_por_profesor convertir_clases_Clases_por_profesor(ResultSet rs) throws SQLException{
        Long id = rs.getLong("id");
        Long id_profesor = rs.getLong("id_profesor");
        Long id_clase = rs.getLong("id_clase");
        
        Clases_por_profesor clases_por_profesor = new Clases_por_profesor(id_profesor, id_clase);
        clases_por_profesor.setId(id);
        return clases_por_profesor;
        
        
    }

    @Override
    public List<Clases_por_profesor> obtenerTodos() throws DAO_exception {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Clases_por_profesor> c = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){
                c.add(convertir_clases_Clases_por_profesor(rs));
            }
        } catch (SQLException e) {
            throw new DAO_exception("Error en SQL", e);
        }finally{
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
    public Clases_por_profesor obtener(Long id) throws DAO_exception {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Clases_por_profesor c = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                c = convertir_clases_Clases_por_profesor(rs);
                
            }else{
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
