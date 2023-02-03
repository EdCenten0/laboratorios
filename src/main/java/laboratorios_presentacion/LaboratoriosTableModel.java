/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_presentacion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import laboratorios_DAO.DAO_exception;
import laboratorios_entities.Laboratorios;
import laboratorios_interface_DAO.Laboratorios_interface;

/**
 *
 * @author cchav
 */
class LaboratoriosTableModel extends AbstractTableModel {
    
    private Laboratorios_interface laboratoriosDAO;
    
    private List<Laboratorios> datos = new ArrayList<>();
    
    public void updateModel() throws DAO_exception{
        this.datos = laboratoriosDAO.obtenerTodos();
        
    }

    public LaboratoriosTableModel(Laboratorios_interface laboratorio) {
        this.laboratoriosDAO = laboratorio;
        
    }
    

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Nombre del laboratorio";
            default: return "Error";
        }
    }
    
    

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex == -1){
            System.out.println("Hola");
        }
       Laboratorios preguntado = this.datos.get(rowIndex);
        switch(columnIndex){
            case 0: return preguntado.getId();
            case 1: return preguntado.getNombre_laboratorio();
            default: return "";
        }
    }
    
    
}
