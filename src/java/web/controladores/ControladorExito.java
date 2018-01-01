/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Daniel Mendoza
 */
public class ControladorExito {
 
    @RequestMapping("exito.htm")
    public ModelAndView exito(){
    
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("exito");
        return mav;
        
    }
}
