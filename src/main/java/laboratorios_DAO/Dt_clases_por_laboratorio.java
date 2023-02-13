/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_DAO;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import laboratorios_entities.Clases;
import laboratorios_entities.Clases_por_laboratorio;
import laboratorios_interface_DAO.Clases_por_laboratorio_interface;

/**
 *
 * @author cchav
 */
public class Dt_clases_por_laboratorio implements Clases_por_laboratorio_interface{

    final String INSERT = "INSERT INTO clases_por_laboratorio (id_clase, id_laboratorio) VALUES (?, ?)";
    final String UPDATE = "UPDATE clases_por_laboratorio SET id_clase = ?, id_laboratorio = ? WHERE id = ?";
    final String DELETE = "DELETE FROM clases_por_laboratorio WHERE id = ?";
    final String GETALL = "SELECT * FROM laboratorios.clases_por_laboratorio";
    final String GETONE = "SELECT * FROM laboratorios.clases_por_laboratorio WHERE id = ?";    
    private Connection conn;

    public Dt_clases_por_laboratorio(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Clases_por_laboratorio c) throws DAO_exception {
       PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, c.getId_clase());
            stat.setLong(2, c.getId_laboratorio());
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
    public void modificar(Clases_por_laboratorio c) throws DAO_exception {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setLong(1, c.getId());
            stat.setLong(2, c.getId_clase());
            stat.setLong(3, c.getId_laboratorio());
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
    public void eliminar(Clases_por_laboratorio c) throws DAO_exception {
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
    
    private Clases_por_laboratorio convertir_clases_por_laboratorio(ResultSet rs) throws SQLException{
        Long id = rs.getLong("id");
        Long id_clase = rs.getLong("id_clase");
        Long id_laboratorio = rs.getLong("id_laboratorio");
        
        Clases_por_laboratorio clases_por_laboratorio = new Clases_por_laboratorio(id_clase, id_laboratorio);
        clases_por_laboratorio.setId(id);
        return clases_por_laboratorio;
    }

    @Override
    public List<Clases_por_laboratorio> obtenerTodos() throws DAO_exception {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Clases_por_laboratorio> c = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){
                c.add(convertir_clases_por_laboratorio(rs));
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
    public Clases_por_laboratorio obtener(Long id) throws DAO_exception {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Clases_por_laboratorio c = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                c = convertir_clases_por_laboratorio(rs);
                
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
