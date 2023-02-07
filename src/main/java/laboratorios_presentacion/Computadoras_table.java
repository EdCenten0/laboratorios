/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laboratorios_presentacion;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import laboratorios_DAO.DAO_exception;
import laboratorios_entities.Computadoras;
import laboratorios_interface_DAO.DAOManager;

/**
 *
 * @author cchav
 */
public class Computadoras_table extends javax.swing.JFrame {
    
    private DAOManager managerP;
    private ComputadorasTableModel model;
    private ComputadorasComboModel modelC;
    private Computadoras computadora;
    private boolean editable;

    public ComputadorasComboModel getModelC() {
        return modelC;
    }

    public void setModelC(ComputadorasComboModel modelC) throws DAO_exception {
        this.modelC = modelC;
        lab_combo.setModel(modelC);
        
    }
    
    

    public Computadoras getComputadora() {
        return computadora;
    }

    public void setComputadora(Computadoras computadora) {
        this.computadora = computadora;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        this.procesador.setEditable(editable);
        this.almacenamiento.setEditable(editable);
        this.ram.setEditable(editable);
       
        
    }
    
    public void loadData(){
        if(this.computadora != null){
            procesador.setText(this.computadora.getProcesador_computadora());
            ram.setText(this.computadora.getRam_computadora());
            almacenamiento.setText(this.computadora.getAlmacenamiento_computadora());
        }else{
            procesador.setText("");
            ram.setText("");
            almacenamiento.setText("");
        }
        
        this.procesador.requestFocus();
    }
    
    public void saveData(){
        if(this.computadora == null){
            this.computadora = new Computadoras();
        }
        
        this.computadora.setProcesador_computadora(procesador.getText());
        this.computadora.setAlmacenamiento_computadora(almacenamiento.getText());
        this.computadora.setRam_computadora(ram.getText());
        
        
    }
    
    private Computadoras getComputadoraSeleccionado() throws DAO_exception{
        Long id = (Long) table.getValueAt(table.getSelectedRow(), 0);
        return managerP.getComputadoras_interface().obtener(id);
    }
    
    private void llenarComboEditar() throws DAO_exception{
        List<Computadoras> computadorasCombo = managerP.getComputadoras_interface().obtenerTodos();
        this.lab_combo.removeAllItems();
        
        for(int i = 0; i < computadorasCombo.size(); i++){
            if(computadorasCombo.get(i).getId_laboratorio() == null){
                lab_combo.addItem(new Computadoras(computadorasCombo.get(i).getProcesador_computadora(), computadorasCombo.get(i).getRam_computadora(), computadorasCombo.get(i).getAlmacenamiento_computadora()));
            }else{
                lab_combo.addItem(new Computadoras(computadorasCombo.get(i).getProcesador_computadora(), computadorasCombo.get(i).getRam_computadora(), computadorasCombo.get(i).getAlmacenamiento_computadora(), computadorasCombo.get(i).getId_laboratorio(), computadorasCombo.get(i).getNombre_laboratorio()));
            }
            
        }
    }
    
    
    
    public Computadoras_table(DAOManager manager) throws DAO_exception {
        initComponents();
        this.setLocationRelativeTo(null);
        this.managerP = manager;
        this.model = new ComputadorasTableModel(managerP.getComputadoras_interface());
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ram = new javax.swing.JTextField();
        almacenamiento = new javax.swing.JTextField();
        procesador = new javax.swing.JTextField();
        nuevo = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        lab_combo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(46, 46, 46));
        jLabel1.setText("Almacenamiento:");
        panel_principal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(46, 46, 46));
        jLabel2.setText("Ram:");
        panel_principal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(46, 46, 46));
        jLabel3.setText("Laboratorio:");
        panel_principal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(46, 46, 46));
        jLabel4.setText("Procesador:");
        panel_principal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        ram.setEditable(false);
        ram.setBackground(new java.awt.Color(204, 204, 204));
        ram.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        ram.setForeground(new java.awt.Color(46, 46, 46));
        panel_principal.add(ram, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 130, -1));

        almacenamiento.setEditable(false);
        almacenamiento.setBackground(new java.awt.Color(204, 204, 204));
        almacenamiento.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        almacenamiento.setForeground(new java.awt.Color(46, 46, 46));
        almacenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                almacenamientoActionPerformed(evt);
            }
        });
        panel_principal.add(almacenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, -1));

        procesador.setEditable(false);
        procesador.setBackground(new java.awt.Color(204, 204, 204));
        procesador.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        procesador.setForeground(new java.awt.Color(46, 46, 46));
        panel_principal.add(procesador, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 130, -1));

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
        panel_principal.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        borrar.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        borrar.setText("Borrar");
        borrar.setEnabled(false);
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        panel_principal.add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        guardar.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        guardar.setText("Guardar");
        guardar.setEnabled(false);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        panel_principal.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        cancelar.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setEnabled(false);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        panel_principal.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));
        panel_principal.add(lab_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 190, -1));

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
        // TODO add your handling code here:
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btn_minMouseClicked

    private void btn_minKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_minKeyPressed
        this.setState(Frame.ICONIFIED);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_minKeyPressed

    private void btn_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_exitMouseClicked

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // TODO add your handling code here:
        this.setComputadora(null);
        this.loadData();
        this.setEditable(true);
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
    }//GEN-LAST:event_nuevoActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        lab_combo.removeAllItems();
        
        try {
            // TODO add your handling code here:

            Computadoras computadora = getComputadoraSeleccionado();
            Long indice = getComputadoraSeleccionado().getId_laboratorio();
            this.setComputadora(computadora);
            this.setEditable(true);
            this.loadData();
            this.guardar.setEnabled(true);
            this.cancelar.setEnabled(true);
            llenarComboEditar();
            this.lab_combo.setSelectedItem(new Computadoras(indice));
        } catch (DAO_exception ex) {
            Logger.getLogger(Clases_table.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_editarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(rootPane, "Seguro que quieres borrar las clase?","Borrar Clase", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            try {
                Computadoras computadora = getComputadoraSeleccionado();
                managerP.getComputadoras_interface().eliminar(computadora);
                model.updateModel();
                model.fireTableDataChanged();
            } catch (DAO_exception ex) {
                Logger.getLogger(Clases_table.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_borrarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here

        saveData();
        Computadoras computadora = getComputadora();

        if(computadora.getId() == null){
            try {
                managerP.getComputadoras_interface().insertar(computadora);
            } catch (DAO_exception ex) {
                Logger.getLogger(Clases_table.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                managerP.getComputadoras_interface().modificar(computadora);
            } catch (DAO_exception ex) {
                Logger.getLogger(Clases_table.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.loadData();
        this.procesador.setText("");
        this.ram.setText("");
        this.almacenamiento.setText("");
//        this.lab_combo.set
        editar.setEnabled(false);
        cancelar.setEnabled(false);
        guardar.setEnabled(false);
        borrar.setEnabled(false);
        setEditable(false);

        try {
            model.updateModel();
            model.fireTableDataChanged();
        } catch (DAO_exception ex) {
            Logger.getLogger(Clases_table.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_guardarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        this.loadData();
        this.procesador.setText("");
        this.ram.setText("");
        this.almacenamiento.setText("");
        
        editar.setEnabled(false);
        cancelar.setEnabled(false);
        guardar.setEnabled(false);
        borrar.setEnabled(false);
        lab_combo.removeAllItems();
        setEditable(false);

    }//GEN-LAST:event_cancelarActionPerformed

    private void almacenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_almacenamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_almacenamientoActionPerformed

    private void editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_editarMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField almacenamiento;
    private javax.swing.JButton borrar;
    private javax.swing.JLabel btn_exit;
    private javax.swing.JLabel btn_min;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Computadoras> lab_combo;
    private javax.swing.JButton nuevo;
    private javax.swing.JPanel panel_inf;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JTextField procesador;
    private javax.swing.JTextField ram;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
