/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.handlers;

import edu.escuelaing.arem.aplicacion.AppServer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2115253
 */
public class MediaHandler implements Handler{

    @Override
    public void procesar(int numero) {
        try {
            Class prueba = Class.forName("edu.escuelaing.arem.apps.Media");
            Class[] argTypes = new Class [] {Integer.class};
            //Pide metodos de nombre main con parametros representados en un arreglo de clases
            Method cuadr = prueba.getDeclaredMethod("calcCuadrado", argTypes);
            int args = 5;
            //si es estatico el metodo el primer campo es nulo, el segundo son los argumentos que usara ese metodo
            cuadr.invoke(null, args);
            System.out.println(cuadr);
            
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
    }
    
}
