/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.apps;

import edu.escuelaing.arem.anotaciones.WebAnnotation.Web;
import static java.lang.System.out;



/**
 *
 * @author 2115253
 */
public class Cuadrado {    
    
    @Web("media")
    public static String calcCuadrado(){
        return "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Pruebaaaaa</title>\n"
                + "</head>"
                + "</html>" ;
        
    }
}
