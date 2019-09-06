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
public class HtmlHandler implements Handler{

    @Override
    public String procesar() {
        return "<!DOCTYPE html>"
                +"<html>"
                +"<head>"
                +"<title>casdasdae</title>"
                +"</head>"
                +"<body>"
                +"${value}"
                +"Cuadrardqwem,m,mq"
                +"</body>"
                +"</html>";
    }
    
}
