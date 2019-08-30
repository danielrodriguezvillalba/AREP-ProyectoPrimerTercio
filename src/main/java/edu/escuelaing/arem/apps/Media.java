/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.apps;

import edu.escuelaing.arem.anotaciones.WebAnnotation.Web;



/**
 *
 * @author 2115253
 */
public class Media {
    
    public static void main( String[] args )
    {
        System.out.println("Calculaaa la mediaaaa");
    }
    
    
    @Web("media")
    public static void calMedia(){
        System.out.println("Calculaaa la mediaaaa");
    }
}
