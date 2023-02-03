/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_presentacion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import laboratorios_DAO.DAO_exception;
import laboratorios_entities.Clases;
import laboratorios_interface_DAO.Clases_interface;

/**
 *
 * @author cchav
 */
class ClasesTableModel extends AbstractTableModel{

    private Clases_interface clasesDAO;
    
    private List<Clases> datos = new ArrayList<>();

    public ClasesTableModel(Clases_interface clasesDAO) {
        this.clasesDAO = clasesDAO;
    }
    
    public void updateModel() throws DAO_exception{
        this.datos = clasesDAO.obtenerTodos();
        
    }

    @Override
    public String getColumnName(int column) {
       switch(column){
           case 0 : return "ID";
           case 1: return "Codigo";
           case 2: return "Nombre";
           case 3: return "Cantidad de estudiantes";
           case 4: return "Creditos";
           default: return  "";
       }
    }
    
    
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clases preguntado = this.datos.get(rowIndex);
        switch(columnIndex){
            case 0: return preguntado.getId();
            case 1: return preguntado.getCodigo_clase();
            case 2: return preguntado.getNombre_clase();
            case 3: return preguntado.getCantidad_estudiantes_clase();
            case 4: return preguntado.getCantidad_creditos();
            default: return "";
        }
    }
    
}
