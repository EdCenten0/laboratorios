/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package laboratorios_interface_DAO;

/**
 *
 * @author cchav
 */
public interface DAOManager {
    Clases_interface getClases_interface();
    
    Computadoras_interface getComputadoras_interface();
    
    Laboratorios_interface getLaboratorios_interface();
    
    Profesores_interface getProfesores_interface();
    
    Clases_por_laboratorio_interface getClases_por_laboratorio_interface();
    
    Clases_por_profesor_interface getClases_por_profesor_interface();
}
