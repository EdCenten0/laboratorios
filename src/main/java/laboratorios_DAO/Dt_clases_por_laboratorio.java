/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    final String GETALL = "SELECT id, codigo_clase, nombre_clase, cantidad_estudiantes_clase, cantidad_creditos FROM clases";
    final String GETONE = "SELECT id, codigo_clase, nombre_clase, cantidad_estudiantes_clase, cantidad_creditos WHERE id = ?";    
    private Connection conn;

    @Override
    public void insertar(Clases c) throws DAO_exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(Clases c) throws DAO_exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Clases c) throws DAO_exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Clases> obtenerTodos() throws DAO_exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Clases obtener(Clases id) throws DAO_exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


   
    
    
}
