/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web.controladores;

import javax.servlet.ServletException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import web.modelo.ModeloDeposito;


/**
 *
 * @author Daniel
 */
public class ControladorIngresoDeposito extends SimpleFormController {

    private ControladorDao depositoDao;
    int numOrigen;
    int numDestino;
    int monto;

    public void setDepositoDao(ControladorDao depositoDao) {
        this.depositoDao = depositoDao;
    }

    @Override
    public ModelAndView onSubmit(Object command) throws ServletException {

        ModeloDeposito pago = (ModeloDeposito) command;
        
        try{
            numOrigen = Integer.parseInt(pago.getNumeroCuentaOrigen());
            //numDestino = Integer.parseInt(pago.getNumeroCuentaOrigen());
            //monto = Integer.parseInt(pago.getMontoDeposito());
            
        }catch(NumberFormatException ex){
        
            
        }
        depositoDao.save(pago,numOrigen);
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}

