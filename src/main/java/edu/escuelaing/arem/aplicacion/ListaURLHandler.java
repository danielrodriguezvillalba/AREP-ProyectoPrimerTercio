/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.aplicacion;

import edu.escuelaing.arem.handlers.Handler;
import edu.escuelaing.arem.handlers.MediaHandler;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 2115253
 */
public class ListaURLHandler {
    private Map<String, Handler> mapa;
    private Handler mediaHandler = new MediaHandler();
    
    public ListaURLHandler(){
        mapa = new HashMap<>();
        mapa.put("apps/media", mediaHandler);
    }
    
       
}
