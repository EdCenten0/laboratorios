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
import laboratorios_entities.Clases_por_laboratorio;
import laboratorios_entities.Laboratorios;
import laboratorios_interface_DAO.Clases_interface;
import laboratorios_interface_DAO.Clases_por_laboratorio_interface;
import laboratorios_interface_DAO.Laboratorios_interface;

/**
 *
 * @author cchav
 */
class ClasesPorLaboratorioTableModel extends AbstractTableModel{

    private Clases_por_laboratorio_interface clasesPorLaboratorioDAO;
    private Clases_interface clasesDAO;
    private Laboratorios_interface laboratorios_DAO;
    private List<Clases_por_laboratorio> datos = new ArrayList<>();
    private List<Clases> clases = new ArrayList<>();
    private List<Laboratorios> laboratorios = new ArrayList<>();
    
    public void updateModel() throws DAO_exception{
        this.datos = clasesPorLaboratorioDAO.obtenerTodos();
        this.clases = clasesDAO.obtenerTodos();
        this.laboratorios = laboratorios_DAO.obtenerTodos();
    }

    public ClasesPorLaboratorioTableModel(Clases_por_laboratorio_interface clasesPorLaboratorioDAO, Clases_interface clasesDAO, Laboratorios_interface laboratorios_DAO) {
        this.clasesPorLaboratorioDAO = clasesPorLaboratorioDAO;
        this.clasesDAO = clasesDAO;
        this.laboratorios_DAO = laboratorios_DAO;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Clase";
            case 2: return "Laboratorio";
            default: return "";
        }
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clases_por_laboratorio preguntado = this.datos.get(rowIndex);     
       switch(columnIndex){
           case 0: return preguntado.getId();
           case 1: 
               int i = 0;
               Clases preguntadoClases = new Clases();

               while(this.clases.get(i).getId() != preguntado.getId_clase() || this.clases.get(i).getId() == preguntado.getId_clase()){
                    if(this.clases.get(i).getId() == preguntado.getId_clase()){
                      preguntadoClases.setNombre_clase(this.clases.get(i).getNombre_clase());
                      preguntadoClases.setCodigo_clase(this.clases.get(i).getCodigo_clase());
                      break;
                    }else{
                       i++;
                        }   
                    }
               return preguntadoClases.getNombre_clase().concat(" -- ".concat(preguntadoClases.getCodigo_clase()));
           case 2: 
               int j = 0;
               Laboratorios preguntadoLaboratorios = new Laboratorios();
               while(this.laboratorios.get(j).getId() != preguntado.getId_laboratorio()|| this.laboratorios.get(j).getId() == preguntado.getId_laboratorio()){
                    if(this.laboratorios.get(j).getId() == preguntado.getId_laboratorio()){
                    preguntadoLaboratorios.setNombre_laboratorio(this.laboratorios.get(j).getNombre_laboratorio());
                    
                    break;
                }else{
                    j++;
                }
                }
               
               return preguntadoLaboratorios.getNombre_laboratorio();
           default: return "Error en la tabla";
       }
    }
    
    
}
