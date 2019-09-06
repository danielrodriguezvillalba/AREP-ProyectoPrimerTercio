/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.handlers.impl;

import edu.escuelaing.arem.aplicacion.AppServer;
import edu.escuelaing.arem.handlers.Handler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class ImageHandler implements Handler{

    @Override
    public String procesar() {
        try {
            Class prueba = Class.forName("edu.escuelaing.arem.apps.Imagen");
            Class[] argTypes = new Class [] {Integer.class};
            //Pide metodos de nombre main con parametros representados en un arreglo de clases
            Method img = prueba.getDeclaredMethod("dibuje", null);
            //si es estatico el metodo el primer campo es nulo, el segundo son los argumentos que usara ese metodo
            return (String) img.invoke(null, null);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(AppServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(AppServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AppServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(AppServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AppServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
