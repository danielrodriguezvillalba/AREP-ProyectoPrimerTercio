/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.aplicacion;

import edu.escuelaing.arem.handlers.Handler;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 2115253
 */
public class ListaURLHandler {
    private Map<String, Handler> mapa;
    
    public ListaURLHandler(){
        mapa = new HashMap<>();
    }
    
    public boolean busque(String busq){
        return mapa.containsKey(busq);
    }
    
    public void put(String key, Handler value){
        mapa.put(key, value);
    }
    
    public Handler get(String key){
        return mapa.get(key);
    }
    
    
}
