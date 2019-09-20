/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.aplicacion;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SocketHandler;

/**
 *
 * @author 2115253
 */
public class Controlador {
    
    private static ExecutorService pool = Executors.newFixedThreadPool(10);
    
    public static void main( String[] args ) throws Exception
    {
        AppServer ap=new AppServer();
        ap.inicializar();   
        pool.submit(ap);
    }
    
}
