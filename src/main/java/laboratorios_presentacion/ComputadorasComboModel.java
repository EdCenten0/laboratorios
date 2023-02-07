/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_presentacion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import laboratorios_DAO.DAO_exception;
import laboratorios_entities.Computadoras;
import laboratorios_interface_DAO.Computadoras_interface;


/**
 *
 * @author cchav
 */
class ComputadorasComboModel extends DefaultComboBoxModel<Computadoras>{
    private Computadoras_interface computadorasDAO;
    private List<String> nombreLaboratorios = new ArrayList<>();

    
    
}
