/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package local.conexion;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Daniel Mendoza
 */
public class Conexion {
    
    
    public Connection Conectar(){
        Connection cn=null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/modulo";
            cn = DriverManager.getConnection(url,"root","");
            System.out.println("Estado: Conectado");
        }
        catch(Exception ex){

           JOptionPane.showMessageDialog(null,"Ha ocurrido un error al conectar con la base de datos: "+ex.getMessage());
        }
        
        return cn;
    }
}
