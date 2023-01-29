/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package laboratorios_interface_DAO;

import java.util.List;
import laboratorios_DAO.DAO_exception;

/**
 *
 * @author cchav
 */
public interface DAO<T, K> {
    void insertar(T c) throws DAO_exception;
    
    void modificar(T c) throws DAO_exception;
    
    void eliminar(T c) throws DAO_exception;
    
    List<T> obtenerTodos() throws DAO_exception;
    
    T obtener(K id) throws DAO_exception;
}
