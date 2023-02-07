/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_presentacion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import laboratorios_DAO.DAO_exception;
import laboratorios_entities.Computadoras;
import laboratorios_interface_DAO.Computadoras_interface;

/**
 *
 * @author cchav
 */
class ComputadorasTableModel extends AbstractTableModel{

    
    private Computadoras_interface computadorasaDAO;
    private List<Computadoras> datos = new ArrayList<>();
    
    public void updateModel() throws DAO_exception{
        this.datos = computadorasaDAO.obtenerTodos();
    }

    public ComputadorasTableModel(Computadoras_interface computadorasaDAO) {
        this.computadorasaDAO = computadorasaDAO;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Procesador";
            case 2: return "RAM";
            case 3: return "Almacenamiento";
            case 4: return "ID del Laboratorio";
            case 5: return "Laboratorio";
            default: return "";
        }
    }
    
    
    
    
    @Override
    public int getRowCount() {
       return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Computadoras preguntado = this.datos.get(rowIndex);
        switch(columnIndex){
            case 0: return preguntado.getId();
            case 1: return preguntado.getProcesador_computadora();
            case 2: return preguntado.getRam_computadora();
            case 3: return preguntado.getAlmacenamiento_computadora();
            case 4: return preguntado.getId_laboratorio();
            case 5: return preguntado.getNombre_laboratorio();
            default: return "";
        }
    }
    
}
