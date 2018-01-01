/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package local.datos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import local.conexion.Conexion;

/**
 *
 * @author Daniel Mendoza
 */
public class Datos {
    private ResultSet resultado, resultbusqueda;
    Conexion conexion = new Conexion();
    int cod;
    String email;
    String rut;
    Date now = new Date(System.currentTimeMillis());
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    String fecha = date.format(now);

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public void MostrarClientes(JTable tabla){
        try{   
            Statement sql = conexion.Conectar().createStatement();
            resultado=sql.executeQuery("Select * from cliente");
            DefaultTableModel dtm=new DefaultTableModel();
                dtm.addColumn("Rut");
                dtm.addColumn("Nombres");
                dtm.addColumn("Apellidos");
                dtm.addColumn("Razon social");
                dtm.addColumn("Tipo");
                dtm.addColumn("Giro comercial");
                dtm.addColumn("Ciudad");
                dtm.addColumn("Comuna");
                dtm.addColumn("Domicilio");
                dtm.addColumn("Fax");
                dtm.addColumn("Telefono");
                dtm.addColumn("Correo");

            tabla.setModel(dtm);
                while(resultado.next()){
                Object vector[]=new Object[12];
                    for(int i=0;i<12;i++)
                    vector[i]=resultado.getObject(i+1);
                    dtm.addRow(vector);
                }
            }
        catch(SQLException ex){
            ex.getMessage();
        }
    }
    
    
    public void BuscarCliente(JTable tabla, String nom){
        try{   
            Statement sql = conexion.Conectar().createStatement();
            resultado=sql.executeQuery("Select * from cliente where nombre='"+nom+"'");
            DefaultTableModel dtm=new DefaultTableModel();
                dtm.addColumn("Rut");
                dtm.addColumn("Nombres");
                dtm.addColumn("Apellidos");
                dtm.addColumn("Razon social");
                dtm.addColumn("Tipo");
                dtm.addColumn("Giro comercial");
                dtm.addColumn("Ciudad");
                dtm.addColumn("Comuna");
                dtm.addColumn("Domicilio");
                dtm.addColumn("Fax");
                dtm.addColumn("Telefono");
                dtm.addColumn("Correo");

            tabla.setModel(dtm);
                while(resultado.next()){
                Object vector[]=new Object[12];
                    for(int i=0;i<12;i++)
                    vector[i]=resultado.getObject(i+1);
                    dtm.addRow(vector);
                }
            }
        catch(SQLException ex){
            ex.getMessage();
        }
    }
    
    
    public int GenerarCodigo(){
        try{

            Statement sql=conexion.Conectar().createStatement();
            ResultSet codigo=sql.executeQuery("SELECT max(cod_factura) from facturas_emitidas");
                while(codigo.next()){
                    cod = codigo.getInt(1);
                }

         }catch(SQLException ex){
            ex.printStackTrace();
         }
    
        return cod;
        
    }
    
    
        public void Servicio(JTable grilla, String tipo)
    {
         try
        {
            Statement sql=conexion.Conectar().createStatement();
            resultado =sql.executeQuery("SELECT codigo, descripcion, valor_hora FROM servicios WHERE tipo='"+tipo+"'");

            DefaultTableModel dtm= new DefaultTableModel();
            dtm.addColumn("Codigo");
            dtm.addColumn("Descripcion");
            dtm.addColumn("Valor hora");


            while(resultado.next())
            {

                Object vector[]=new Object[3];

                for(int i=0;i<3;i++)
                {
                    vector[i]=resultado.getObject(i+1);
        
                }
                dtm.addRow(vector);
                grilla.setModel(dtm);
            }
        }
        catch(SQLException ex)
        {
            ex.getMessage();
        }

    }
        
    public void NuevaFactura(int cod, String rut, double monto){
        try{
            Statement sql=conexion.Conectar().createStatement();

            sql.executeUpdate("INSERT INTO FACTURAS_EMITIDAS VALUES ("+ cod + ", '"+ rut +"','"+fecha+"',"+monto+",0)");
            JOptionPane.showMessageDialog(null, 
                        "La factura ha sido generada con exito.","Facturacion",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex){
            ex.getMessage();
        }

    }
    
    
    public int ValidarUsuario(String user, String pass){
        int valor=0;
        try{
         //1. LLamar a la Conexion (Crear el statement
         Statement sql=conexion.Conectar().createStatement();
         resultado = sql.executeQuery("SELECT COUNT(*) FROM usuarios WHERE usuario='"+user+"' AND contraseña='"+pass+"'");
            while(resultado.next()){
             valor=resultado.getInt(1);
            }
        }
        catch(SQLException ex){
         ex.getMessage();
         System.out.println("Existen Errores!!");
        }
        
        return valor;
    }
    
    public void Facturas(JTable tabla, int est){
        try{   
            Statement sql = conexion.Conectar().createStatement();
            resultado=sql.executeQuery("Select cod_factura, rutcliente, fechaemision, monto from facturas_emitidas where estado="+est+"");
            DefaultTableModel dtm=new DefaultTableModel();
                dtm.addColumn("Codigo");
                dtm.addColumn("Rut cliente");
                dtm.addColumn("Fecha emision");
                dtm.addColumn("Monto");
      

            tabla.setModel(dtm);
                while(resultado.next()){
                Object vector[]=new Object[4];
                    for(int i=0;i<4;i++)
                    vector[i]=resultado.getObject(i+1);
                    dtm.addRow(vector);
                }
            }
        catch(SQLException ex){
            ex.getMessage();
        }
    }
    
    public void FacturasTodas(JTable tabla){
        try{   
            Statement sql = conexion.Conectar().createStatement();
            resultado=sql.executeQuery("Select * from facturas_emitidas");
            DefaultTableModel dtm=new DefaultTableModel();
                dtm.addColumn("Codigo");
                dtm.addColumn("Rut cliente");
                dtm.addColumn("Fecha emision");
                dtm.addColumn("Monto");
                dtm.addColumn("Estado");

            tabla.setModel(dtm);
                while(resultado.next()){
                Object vector[]=new Object[5];
                    for(int i=0;i<5;i++)
                    vector[i]=resultado.getObject(i+1);
                    dtm.addRow(vector);
                }
            }
        catch(SQLException ex){
            ex.getMessage();
        }
    }
    
     public void Anular(int cod){
        try{
            Statement sql=conexion.Conectar().createStatement();

            sql.executeUpdate("update FACTURAS_EMITIDAS set estado=2 where cod_factura="+cod);
            JOptionPane.showMessageDialog(null, 
                        "La factura ha sido anulada con exito.","Facturacion",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex){
            ex.getMessage();
        }

    }
     
    public void BuscarEmail(String rut){
        try{   
            Statement sql = conexion.Conectar().createStatement();
            resultado=sql.executeQuery("Select correo from cliente where rutcliente='"+rut+"'");

            while(resultado.next()){
                    email = resultado.getString("correo");
                }
            }
        catch(SQLException ex){
            ex.getMessage();
        }
    }
    
    public void Deposito(JTable tabla){
        try{   
            Statement sql = conexion.Conectar().createStatement();
            resultado=sql.executeQuery("Select * from deposito");
            DefaultTableModel dtm=new DefaultTableModel();
                dtm.addColumn("Fecha pago");
                dtm.addColumn("Numero factura");
                dtm.addColumn("Nombre titular");
                dtm.addColumn("Numero Cta. origen");
                dtm.addColumn("Numero Cta. Secoper");
                dtm.addColumn("Monto");
                dtm.addColumn("Tipo");
                dtm.addColumn("Banco");

            tabla.setModel(dtm);
                while(resultado.next()){
                Object vector[]=new Object[8];
                    for(int i=0;i<8;i++)
                    vector[i]=resultado.getObject(i+1);
                    dtm.addRow(vector);
                }
            }
        catch(SQLException ex){
            ex.getMessage();
        }
    }
}
