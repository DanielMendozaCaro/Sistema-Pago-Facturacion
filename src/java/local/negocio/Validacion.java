/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package local.negocio;

/**
 *
 * @author Daniel Mendoza
 */
public class Validacion {
    int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    
    public void validarBlanco(String user, String pass){
    
        if(user.equals("") || pass.equals("")){
            val = 1;
        }
        else{
            val = 0;
        }
    }   
}
