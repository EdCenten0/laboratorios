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
import laboratorios_entities.Clases_por_profesor;
import laboratorios_entities.Profesores;
import laboratorios_interface_DAO.Clases_interface;
import laboratorios_interface_DAO.Clases_por_profesor_interface;
import laboratorios_interface_DAO.Profesores_interface;

/**
 *
 * @author cchav
 */
class ClasesPorProfesorTableModel extends AbstractTableModel {

    private Clases_por_profesor_interface clasesPorProfesorDAO;
    private Profesores_interface profesoresDAO;
    private Clases_interface clasesDAO;
    private List<Clases_por_profesor> datos = new ArrayList<>();
    private List<Profesores> profesores = new ArrayList<>();
    private List<Clases> clases = new ArrayList<>();
    
    
    public void updateModel() throws DAO_exception{
        this.datos = clasesPorProfesorDAO.obtenerTodos();
        this.clases = clasesDAO.obtenerTodos();
        this.profesores = profesoresDAO.obtenerTodos();
    }

    public ClasesPorProfesorTableModel(Clases_por_profesor_interface clasesPorProfesorDAO, Profesores_interface profesoresDAO, Clases_interface clasesDAO) {
        this.clasesPorProfesorDAO = clasesPorProfesorDAO;
        this.profesoresDAO = profesoresDAO;
        this.clasesDAO = clasesDAO;
    }

    

    @Override
    public String getColumnName(int column) {
       switch(column){
           case 0: return "ID";
           case 1: return "Clase";
           case 2: return "Profesor";
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
       Clases_por_profesor preguntado = this.datos.get(rowIndex);
       Profesores preguntadoProfesores = new Profesores();
       Clases preguntadoClases = new Clases();
       int i = 0;
       
       do{
           if(this.clases.get(i).getId() == preguntado.getId_clase()){
              preguntadoClases.setNombre_clase(this.clases.get(i).getNombre_clase());
              preguntadoClases.setCodigo_clase(this.clases.get(i).getCodigo_clase());
              break;
           }else{
               i++;
           }
       }while(this.clases.get(i).getId() != preguntado.getId_clase());
       
       do{
           if(this.profesores.get(i).getId() == preguntado.getId_profesor()){
              preguntadoProfesores.setNombre_profesor(this.profesores.get(i).getNombre_profesor());
              preguntadoProfesores.setApellido_profesor(this.profesores.get(i).getApellido_profesor());
              preguntadoProfesores.setCodigo_profesor(this.profesores.get(i).getCodigo_profesor());
              break;
           }else{
               i++;
           }
       }while(this.profesores.get(i).getId() != preguntado.getId_profesor());
       
       switch(columnIndex){
           case 0: return preguntado.getId();
           case 1: return preguntadoClases.getNombre_clase().concat(" -- ".concat(preguntadoClases.getCodigo_clase()));
           case 2: return preguntadoProfesores.getNombre_profesor().concat(" ").concat(preguntadoProfesores.getApellido_profesor().concat(" -- ").concat(preguntadoProfesores.getCodigo_profesor()));
           default: return "Error en la tabla";
       }
    }
    
}
