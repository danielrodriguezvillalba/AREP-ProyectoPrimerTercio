package edu.escuelaing.arem.handlers.impl;

import edu.escuelaing.arem.handlers.Handler;
import java.lang.reflect.Method;

/**
 *
 * @author 2115253
 */
public class methodHandler implements Handler {
    private Method metodo;

    
    public methodHandler(Method metodo){
        this.metodo=metodo;
    }

    
    public String procesar(){
        try{
            //metodos estaticos sin parametros 
             return (String) metodo.invoke(null,null);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        } 
    }
    

    @Override
    public String procesarConParametros(Object[] para) {
         try{
            //metodos estaticos sin parametros 
            System.out.println("paraaaaaaaams");
             return (String) metodo.invoke(null,para);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        } 
    }
}