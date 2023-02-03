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
import laboratorios_entities.Computadoras;

import laboratorios_interface_DAO.Computadoras_interface;

/**
 *
 * @author cchav
 */
public class Dt_computadoras implements Computadoras_interface{
    
    final String INSERT = "INSERT INTO computadoras (procesador_computadora, ram_computadora, almacenamiento_computadora, id_laboratorio) VALUES (?, ?, ?, ?)";
    final String UPDATE = "UPDATE computadoras SET procesador_computadora = ?, ram_computadora = ?, almacenamiento_computadora = ?, id_laboratorio = ? WHERE id = ?";
    final String DELETE = "DELETE FROM computadoras WHERE id = ?";
    final String GETALL = "SELECT * FROM laboratorios.computadoras LEFT JOIN laboratorios.laboratorios ON computadoras.id_laboratorio = laboratorios.laboratorios.id;";
    final String GETONE = "SELECT * FROM laboratorios.computadoras LEFT JOIN laboratorios.laboratorios ON computadoras.id_laboratorio = laboratorios.laboratorios.id WHERE computadoras.id = ?";  
    
    private Connection conn;
    
    public Dt_computadoras(Connection connection){
        this.conn = connection;
    }

    @Override
    public void insertar(Computadoras c) throws DAO_exception{
        PreparedStatement stat = null;
        
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, c.getProcesador_computadora());
            stat.setString(2, c.getRam_computadora());
            stat.setString(3, c.getAlmacenamiento_computadora());
            stat.setLong(4, c.getLaboratorio_id());
            
            
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
                    throw new DAO_exception("Error al cerrar conexion", e);
                }
            }
        }
    }

    @Override
    public void modificar(Computadoras c) throws DAO_exception{
       PreparedStatement stat = null;
       
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, c.getProcesador_computadora());
            stat.setString(2, c.getRam_computadora());
            stat.setString(3, c.getAlmacenamiento_computadora());
            stat.setLong(4, c.getLaboratorio_id());
            stat.setLong(5, c.getId());
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
    public void eliminar(Computadoras c) throws DAO_exception{
       PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, c.getId());
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
                    throw new DAO_exception("Error al cerrar la base de datos");
                }
            }
        }
    }

    @Override
    public List<Computadoras> obtenerTodos() throws DAO_exception {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Computadoras> c = new ArrayList<>();
        
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){
                
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
    public Computadoras obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
