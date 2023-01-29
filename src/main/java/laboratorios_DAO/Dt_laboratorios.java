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
import laboratorios_entities.Laboratorios;
import laboratorios_interface_DAO.Laboratorios_interface;
/**
 *
 * @author cchav
 */
public class Dt_laboratorios implements Laboratorios_interface{

    final String INSERT = "INSERT INTO laboratorios (nombre_laboratorio) VALUES (?)";
    final String UPDATE = "UPDATE laboratorios SET nombre_laboratorio = ? WHERE id = ?";
    final String DELETE = "DELETE FROM laboratorios WHERE id = ?";
    final String GETALL = "SELECT id, nombre_laboratorio FROM laboratorios";
    final String GETONE = "SELECT id, nombre_laboratorio FROM laboratorios WHERE id = ?";
    private Connection conn;

    public Dt_laboratorios(Connection conn) {
        this.conn = conn;
    }
    
    
    
    @Override
    public void insertar(Laboratorios c) throws DAO_exception{
        PreparedStatement stat = null;
        
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, c.getNombre_laboratorio());
            if(stat.executeUpdate()==0){
                throw new DAO_exception("Puede que no se haya guardado");
            }
        } catch (SQLException e) {
            throw new DAO_exception("Error en SQL", e);
               
        }finally{
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
    public void modificar(Laboratorios c) throws DAO_exception{
        PreparedStatement stat = null;
        
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, c.getNombre_laboratorio());
            stat.setLong(2, c.getId());
            
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
                    throw new DAO_exception("Error al cerrar la conexion", e);
                }
            }
        }
               
        
    }

    @Override
    public void eliminar(Laboratorios c) throws DAO_exception{
        PreparedStatement stat = null;
        
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, c.getId());
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
                    throw new DAO_exception("Error al cerrar la conexion", e);
                }
            }
        }
    }

    private Laboratorios convertir_laboratorios(ResultSet rs) throws SQLException{
        Long id = rs.getLong("id");
        String nombre_laboratorio = rs.getString("nombre_laboratorio");
        
        Laboratorios laboratorio = new Laboratorios(nombre_laboratorio);
        laboratorio.setId(id);
        
        return laboratorio;
    }
    
    @Override
    public List<Laboratorios> obtenerTodos() throws DAO_exception{
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Laboratorios> c = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){
                c.add(convertir_laboratorios(rs));
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
    public Laboratorios obtener(Long id) throws DAO_exception{
        PreparedStatement stat = null;
        ResultSet rs = null;
        Laboratorios c = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                c = convertir_laboratorios(rs);
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
