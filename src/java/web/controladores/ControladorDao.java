/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web.controladores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import org.springframework.web.servlet.ModelAndView;
import web.modelo.ModeloDeposito;
import web.modelo.ModeloFactura;


/**
 *
 * @author Daniel
 */
public class ControladorDao {
        
     private DataSource dataSource;
     ModeloFactura fac = new ModeloFactura();
     Date now = new Date(System.currentTimeMillis());
     SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
     SimpleDateFormat date1 = new SimpleDateFormat("dd-MM-yyyy");
     String fecha;
     int cod;
     int mont;
     int paso=0;
     
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
/*
    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        this.paso = paso;
    } */
    
    public void save(ModeloDeposito deposito,int numOrigen) {
        fecha = date.format(now).toString();
        PreparedStatement realizarDeposito;
        try {

                realizarDeposito = getConnection().prepareStatement(
                        "INSERT INTO deposito VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                realizarDeposito.setString(1, fecha);
                realizarDeposito.setInt(2, cod);
                realizarDeposito.setString(3, deposito.getNombreTitular());
                realizarDeposito.setInt(4, numOrigen);
                realizarDeposito.setInt(5, 123123123);
                realizarDeposito.setDouble(6, mont);
                realizarDeposito.setString(7, deposito.getTipoDeposito());
                realizarDeposito.setString(8, deposito.getEntidadBancaria());
  
            realizarDeposito.executeUpdate();
            
            
            realizarDeposito = getConnection().prepareStatement(
                        "update facturas_emitidas set estado=1 where cod_factura=?");
            realizarDeposito.setInt(1, cod);
            realizarDeposito.executeUpdate();
            
            closeConnection();
        } catch (SQLException se) {
            System.err.println("Se ha producido un error de BD.");
            System.err.println(se.getMessage());
        }
    }
    
    protected void closeConnection() throws SQLException {
        dataSource.getConnection().close();
    }
    
    
    
    public ModeloFactura findById(int codigo) {
        ResultSet result = null;
        ModeloFactura factu = null;

        try {
            factu = new ModeloFactura();
            String query = "SELECT * FROM facturas_emitidas WHERE estado=0 and cod_factura = ?";

            
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setInt(1, codigo);
            result = stmt.executeQuery();

            
            if (!result.next()) {
                throw new SQLException();    
            }

            paso=0;
            
            fecha = result.getString("fechaemision");
            factu.setCod_factura(result.getInt("cod_factura"));
            factu.setRutcliente(result.getString("rutcliente"));
            factu.setFechaemision(fecha = date1.format(now));
            factu.setMonto(result.getInt("monto"));
            System.out.println("Bandera rut " + factu.getRutcliente());
            cod = result.getInt("cod_factura");
            mont = result.getInt("monto");
            result.close();
            stmt.close();
            closeConnection();

        } catch (SQLException se) {
           // System.err.println("Se ha producido un error de BD.");
            //System.err.println(se.getMessage()); 
            paso = 1;     
            return factu;
        }

        return factu;
    }
}


