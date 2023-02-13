/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laboratorios_presentacion;

import java.awt.Frame;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import laboratorios_DAO.DAO_exception;
import laboratorios_entities.Clases;
import laboratorios_entities.Clases_por_laboratorio;
import laboratorios_entities.Laboratorios;
import laboratorios_interface_DAO.DAOManager;

/**
 *
 * @author cchav
 */
public class Clases_por_laboratorio_table extends javax.swing.JFrame {

    private DAOManager managerP;
    private ClasesPorLaboratorioTableModel model;
    private Clases_por_laboratorio clases_por_laboratorio;
    private boolean editable;

    public Clases_por_laboratorio getClases_por_laboratorio() {
        return clases_por_laboratorio;
    }

    public void setClases_por_laboratorio(Clases_por_laboratorio clases_por_laboratorio) {
        this.clases_por_laboratorio = clases_por_laboratorio;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    private void saveData(){
        if(this.clases_por_laboratorio == null){
            this.clases_por_laboratorio = new Clases_por_laboratorio();
        }
        
        Integer idGot = clases_combo.getSelectedIndex();
        Integer idGot2 = laboratorio_combo.getSelectedIndex();
        if(idGot != -1 && idGot2 != -1){
            this.clases_por_laboratorio.setId_laboratorio(laboratorio_combo.getItemAt(laboratorio_combo.getSelectedIndex()).getId());
            this.clases_por_laboratorio.setId_clase(clases_combo.getItemAt(clases_combo.getSelectedIndex()).getId());
        }else{
            JOptionPane.showMessageDialog(rootPane, "No puede dejar campos vacíos");
        }
        
    }
    
     private void llenarComboClase(boolean selected) throws DAO_exception{
        List<Clases> clasesList = managerP.getClases_interface().obtenerTodos();
        this.clases_combo.removeAllItems();
        
        if(selected){
            for(int i = 0; i < clasesList.size(); i++){
                clases_combo.addItem(new Clases(clasesList.get(i).getId(), clasesList.get(i).getCodigo_clase(), clasesList.get(i).getNombre_clase()));
            }
        }else{
            clases_combo.addItem(null);
            for(int i = 0; i < clasesList.size(); i++){
                clases_combo.addItem(new Clases(clasesList.get(i).getId(), clasesList.get(i).getCodigo_clase(), clasesList.get(i).getNombre_clase()));
            }
        }
    }
    
    private void llenarComboLaboratorio(boolean selected) throws DAO_exception{
        List<Laboratorios> laboratoriosList = managerP.getLaboratorios_interface().obtenerTodos();
        this.laboratorio_combo.removeAllItems();
        
        if(selected){
            for(int i = 0; i < laboratoriosList.size(); i++){
                laboratorio_combo.addItem(new Laboratorios(laboratoriosList.get(i).getId(), laboratoriosList.get(i).getNombre_laboratorio()));
            }
        }else{
            laboratorio_combo.addItem(null);
            for(int i = 0; i < laboratoriosList.size(); i++){
                laboratorio_combo.addItem(new Laboratorios(laboratoriosList.get(i).getId(), laboratoriosList.get(i).getNombre_laboratorio()));
            }
        }
    }
    
    private Clases_por_laboratorio getClases_por_laboratorioSeleccionado() throws DAO_exception{
        Long id = (Long) table.getValueAt(table.getSelectedRow(), 0);
        return managerP.getClases_por_laboratorio_interface().obtener(id);
    }
    
 
    public Clases_por_laboratorio_table(DAOManager manager) throws DAO_exception {
        initComponents();
        this.setLocationRelativeTo(null);
        this.managerP = manager;
        this.model = new ClasesPorLaboratorioTableModel(managerP.getClases_por_laboratorio_interface(),managerP.getClases_interface(),managerP.getLaboratorios_interface());
        this.model.updateModel();
        this.table.setModel(model);
        this.table.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = (table.getSelectedRow() != -1);
            this.editar.setEnabled(true);
            this.borrar.setEnabled(true);
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        panel_inf = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_min = new javax.swing.JLabel();
        btn_exit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nuevo = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        laboratorio_combo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        clases_combo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_principal.setBackground(new java.awt.Color(133, 184, 229));
        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_inf.setBackground(new java.awt.Color(60, 134, 161));
        panel_inf.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setBackground(new java.awt.Color(204, 204, 204));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        panel_inf.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 760, 290));

        panel_principal.add(panel_inf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 790, 320));

        btn_min.setBackground(new java.awt.Color(255, 0, 0));
        btn_min.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        btn_min.setForeground(new java.awt.Color(255, 153, 51));
        btn_min.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_min.setText("•");
        btn_min.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_minMouseClicked(evt);
            }
        });
        btn_min.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_minKeyPressed(evt);
            }
        });
        panel_principal.add(btn_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 20, 20));

        btn_exit.setBackground(new java.awt.Color(255, 0, 0));
        btn_exit.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        btn_exit.setForeground(new java.awt.Color(255, 51, 51));
        btn_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_exit.setText("•");
        btn_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exitMouseClicked(evt);
            }
        });
        panel_principal.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 20, 20));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(46, 46, 46));
        jLabel3.setText("Laboratorio:");
        panel_principal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        nuevo.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        panel_principal.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        editar.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        editar.setText("Editar");
        editar.setEnabled(false);
        editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarMouseClicked(evt);
            }
        });
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        panel_principal.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        borrar.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        borrar.setText("Borrar");
        borrar.setEnabled(false);
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        panel_principal.add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        guardar.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        guardar.setText("Guardar");
        guardar.setEnabled(false);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        panel_principal.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        cancelar.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setEnabled(false);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        panel_principal.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));
        panel_principal.add(laboratorio_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 190, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(46, 46, 46));
        jLabel4.setText("Clase:");
        panel_principal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));
        panel_principal.add(clases_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minMouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btn_minMouseClicked

    private void btn_minKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_minKeyPressed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btn_minKeyPressed

    private void btn_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_exitMouseClicked

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        this.setClases_por_laboratorio(null);
        guardar.setEnabled(true);
        cancelar.setEnabled(true);

        try {
            llenarComboClase(false);
            llenarComboLaboratorio(false);
        } catch (DAO_exception ex) {
            Logger.getLogger(Clases_por_profesor_table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nuevoActionPerformed

    private void editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseClicked

    }//GEN-LAST:event_editarMouseClicked

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        clases_combo.removeAllItems();
        laboratorio_combo.removeAllItems();
        try {
            Clases_por_laboratorio clases_por_laboratorio = new Clases_por_laboratorio();
            clases_por_laboratorio.setId(getClases_por_laboratorioSeleccionado().getId());
            clases_por_laboratorio.setId_clase(getClases_por_laboratorioSeleccionado().getId_clase());
            clases_por_laboratorio.setId_laboratorio(getClases_por_laboratorioSeleccionado().getId_laboratorio());
            this.setClases_por_laboratorio(clases_por_laboratorio);
            this.guardar.setEnabled(true);
            this.cancelar.setEnabled(true);
            llenarComboClase(false);
            llenarComboLaboratorio(false);
            this.clases_combo.setSelectedItem(new Clases(clases_por_laboratorio.getId_clase()));
            this.laboratorio_combo.setSelectedItem(new Laboratorios(clases_por_laboratorio.getId_laboratorio()));

        } catch (DAO_exception ex) {
            Logger.getLogger(Clases_table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed

        if(JOptionPane.showConfirmDialog(rootPane, "Seguro que quieres borrar las clase?","Borrar Clase", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            try {
                Clases_por_laboratorio clases_por_laboratorio = getClases_por_laboratorioSeleccionado();
                managerP.getClases_por_laboratorio_interface().eliminar(clases_por_laboratorio);
                model.updateModel();
                model.fireTableDataChanged();
            } catch (DAO_exception ex) {
                Logger.getLogger(Clases_table.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_borrarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        saveData();
        Clases_por_laboratorio clases_por_laboratorio = getClases_por_laboratorio();

        if(clases_por_laboratorio.getId() == null){
            try {
                managerP.getClases_por_laboratorio_interface().insertar(clases_por_laboratorio);
            } catch (DAO_exception ex) {
                Logger.getLogger(Clases_por_profesor_table.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                managerP.getClases_por_laboratorio_interface().modificar(clases_por_laboratorio);
            } catch (DAO_exception ex) {
                Logger.getLogger(Clases_por_profesor_table.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        editar.setEnabled(false);
        cancelar.setEnabled(false);
        guardar.setEnabled(false);
        borrar.setEnabled(false);
        try {
            model.updateModel();
            model.fireTableDataChanged();
        } catch (DAO_exception ex) {
            Logger.getLogger(Clases_table.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.clases_combo.removeAllItems();
        this.laboratorio_combo.removeAllItems();
    }//GEN-LAST:event_guardarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        //        this.loadData();
        //        this.procesador.setText("");
        //        this.ram.setText("");
        //        this.almacenamiento.setText("");

        editar.setEnabled(false);
        cancelar.setEnabled(false);
        guardar.setEnabled(false);
        borrar.setEnabled(false);
        laboratorio_combo.removeAllItems();
        clases_combo.removeAllItems();
        setEditable(false);
    }//GEN-LAST:event_cancelarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private javax.swing.JLabel btn_exit;
    private javax.swing.JLabel btn_min;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<Clases> clases_combo;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Laboratorios> laboratorio_combo;
    private javax.swing.JButton nuevo;
    private javax.swing.JPanel panel_inf;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
