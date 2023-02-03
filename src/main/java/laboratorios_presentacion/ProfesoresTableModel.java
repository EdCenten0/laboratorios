/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_presentacion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import laboratorios_DAO.DAO_exception;
import laboratorios_entities.Profesores;
import laboratorios_interface_DAO.Profesores_interface;

/**
 *
 * @author cchav
 */
class ProfesoresTableModel extends AbstractTableModel{
    
    private Profesores_interface profesoresDAO;
    private List<Profesores> datos = new ArrayList<>();

    public ProfesoresTableModel(Profesores_interface profesoresDAO) {
        this.profesoresDAO = profesoresDAO;
    }
    
    public void updateModel() throws DAO_exception{   
        this.datos = profesoresDAO.obtenerTodos();
    }

    @Override
    public String getColumnName(int column) {
       switch(column){
           case 0: return "ID";
           case 1: return "Nombre";
           case 2: return "Apellido";
           case 3: return "Codigo";
           default: return "";
       }
    }
    
    
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Profesores preguntado = this.datos.get(rowIndex);
        switch(columnIndex){
            case 0: return preguntado.getId();
            case 1: return preguntado.getNombre_profesor();
            case 2: return preguntado.getApellido_profesor();
            case 3: return preguntado.getCodigo_profesor();
            default: return "";
            
        }
    }
    
}
