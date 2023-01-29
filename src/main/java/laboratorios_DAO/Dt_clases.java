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
import laboratorios_entities.Clases;
import laboratorios_interface_DAO.*;

/**
 *
 * @author cchav
 */
public class Dt_clases implements Clases_interface{
    
    final String INSERT = "INSERT INTO clases (codigo_clase, nombre_clase, cantidad_estudiantes_clase, cantidad_creditos) VALUES (?, ?, ?, ?)";
    final String UPDATE = "UPDATE clases SET codigo_clase = ?, nombre_clase = ?, cantidad_estudiantes_clase = ?, cantidad_creditos = ? WHERE id = ?";
    final String DELETE = "DELETE FROM clases WHERE id = ?";
    final String GETALL = "SELECT id, codigo_clase, nombre_clase, cantidad_estudiantes_clase, cantidad_creditos FROM clases";
    final String GETONE = "SELECT id, codigo_clase, nombre_clase, cantidad_estudiantes_clase, cantidad_creditos FROM clases WHERE id = ?";    
    private Connection conn;
    
    public Dt_clases(Connection connection) {
        this.conn = connection;
    }

    @Override
    public void insertar(Clases c) throws DAO_exception{
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, c.getCodigo_clase());
            stat.setString(2, c.getNombre_clase());
            stat.setInt(3, c.getCantidad_estudiantes_clase());
            stat.setInt(4, c.getCantidad_creditos());
            if(stat.executeUpdate() == 0){
               throw new DAO_exception("Puede que no se haya guardado");
            }
            
        } catch(SQLException e){
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
    public void modificar(Clases c) throws DAO_exception{
       PreparedStatement stat = null;
       
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, c.getCodigo_clase());
            stat.setString(2, c.getNombre_clase());
            stat.setInt(3, c.getCantidad_estudiantes_clase());
            stat.setInt(4, c.getCantidad_creditos());
            stat.setLong(5, c.getId());
            if(stat.executeUpdate()==0){
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
    public void eliminar(Clases c) throws DAO_exception{
        PreparedStatement stat = null;
        
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, c.getId());
            
            if(stat.executeUpdate()==0){
                throw new DAO_exception("Puede que no se haya borrado");
                
            }
        } catch (SQLException e) {
            throw new DAO_exception("Error en borrar", e);
            
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
    
    private Clases convertir_clases(ResultSet rs) throws SQLException{
        Long id = rs.getLong("id");
        String codigo_clase = rs.getString("codigo_clase");
        String nombre_clase = rs.getString("nombre_clase");
        int cantidad_estudiantes_clase = rs.getInt("cantidad_estudiantes_clase");
        int cantidad_creditos = rs.getInt("cantidad_creditos");
        Clases clase = new Clases(codigo_clase, nombre_clase, cantidad_estudiantes_clase, cantidad_creditos);
        clase.setId(id);
        return clase;
        
    }

    @Override
    public List<Clases> obtenerTodos() throws DAO_exception{
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Clases> c = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){
                c.add(convertir_clases(rs));
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
    public Clases obtener(Long id) throws DAO_exception{
        PreparedStatement stat = null;
        ResultSet rs = null;
        Clases c = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                c = convertir_clases(rs);
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
