package web.controladores;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import web.modelo.ModeloDeposito;



public class DepositoValidador implements Validator {

    @SuppressWarnings("unchecked")
    @Override
    public boolean supports(Class clazz) {
        return ModeloDeposito.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        ModeloDeposito depo = (ModeloDeposito) obj;
        
     /*   if (!StringUtils.hasLength(depo.getCodigoFactura())) {
            errors.rejectValue("codigoFactura", "required", "Campo requirido");
        } */
        
        if (!StringUtils.hasLength(depo.getNombreTitular())) {
            errors.rejectValue("nombreTitular", "required", "Campo requirido");
        }
        
        if (!StringUtils.hasLength(depo.getNumeroCuentaOrigen())) {
            errors.rejectValue("numeroCuentaOrigen", "required", "Campo requirido");
        } 
        
      /*  if (!StringUtils.hasLength(depo.getNumeroCuentaDestino())) {
            errors.rejectValue("numeroCuentaDestino", "required", "Campo requirido");
        } 
        
        if (!StringUtils.hasLength(depo.getMontoDeposito())) {
            errors.rejectValue("montoDeposito", "required", "Campo requirido");
        } */
        
        if (!StringUtils.hasLength(depo.getTipoDeposito())) {
            errors.rejectValue("tipoDeposito", "required", "Campo requirido");
        }
        
        if (!StringUtils.hasLength(depo.getEntidadBancaria())) {
            errors.rejectValue("entidadBancaria", "required", "Campo requirido");
        }
        
        
        //validar campos numericos
        int numO;
       /* int numD;
        int mont;
        int codD; */
        
        try{
            numO = Integer.parseInt(depo.getNumeroCuentaOrigen());
        }catch(NumberFormatException ex){
            errors.rejectValue("numeroCuentaOrigen", "required", "Solo numeros en este campo");
        } 
     /*   
        try{
            numD = Integer.parseInt(depo.getNumeroCuentaDestino());
        }catch(NumberFormatException ex){
            errors.rejectValue("numeroCuentaDestino", "required", "Solo numeros en este campo");
        }
        
        try{
            mont = Integer.parseInt(depo.getMontoDeposito());
        }catch(NumberFormatException ex){
            errors.rejectValue("montoDeposito", "required", "Solo numeros en este campo");
        }
        
        try{
            codD = Integer.parseInt(depo.getCodigoFactura());
        }catch(NumberFormatException ex){
            errors.rejectValue("codigoFactura", "required", "Solo numeros en este campo");
        } */
    } 
}
