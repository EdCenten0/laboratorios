/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorios_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import laboratorios_interface_DAO.DAOManager;
import laboratorios_interface_DAO.MySQL_DAO_manager;
import laboratorios_presentacion.Principal;
/**
 *
 * @author cchav
 */
public class Main {
    public static void main(String[] args) throws SQLException {
//      
        System.out.println("Hola");
        
        DAOManager manager = new MySQL_DAO_manager("localhost", "root", "1234", "laboratorios");
        Principal p = new Principal(manager);
        p.setManager(manager);
        p.setVisible(true);
        
        
    }
    
}
