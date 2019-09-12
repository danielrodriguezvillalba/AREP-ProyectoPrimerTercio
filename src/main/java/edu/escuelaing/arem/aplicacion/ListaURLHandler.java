/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.aplicacion;

import edu.escuelaing.arem.handlers.Handler;
import edu.escuelaing.arem.handlers.impl.CuadradoHandler;
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
    
    public String dirigir(String busq) {
        if(mapa.containsKey(busq)){
            Handler llave = mapa.get(busq);
            System.out.println("Lleegaaa");
            return llave.procesar();
        }
        return null;
    }
}
