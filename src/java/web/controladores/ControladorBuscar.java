/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web.controladores;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import web.modelo.ModeloFactura;

/**
 *
 * @author Daniel
 */
public class ControladorBuscar extends SimpleFormController {

    private ControladorDao depositoDao;
   

    public void setDepositoDao(ControladorDao depositoDao) {
        this.depositoDao = depositoDao;
    }

    @Override
    public ModelAndView onSubmit(Object command) throws ServletException {

        ModeloFactura factu = (ModeloFactura) command;
        Map<String, Object> modelo = new HashMap<String, Object>();
        modelo.put("datos", depositoDao.findById(factu.getCod_factura()));
        modelo.put("titulo", "Registros");
        
        
        if(depositoDao.paso == 1){
            return new ModelAndView("index");
        }
        
       return new ModelAndView("resultado", modelo);
    }
}
