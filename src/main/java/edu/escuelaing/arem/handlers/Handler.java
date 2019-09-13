/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.handlers;

/**
 *
 * @author 2115253
 */
public interface Handler {
    
    public String procesar();
    
    public String procesarConParametros(Object[] para);
    
}
