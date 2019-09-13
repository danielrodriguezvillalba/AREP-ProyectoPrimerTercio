/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.apps;

import edu.escuelaing.arem.anotaciones.Web;
import static java.lang.System.out;

/**
 *
 * @author 2115253
 */
public class cuadrado {

    @Web("cuadrado")
    public static String calcCuadrado() {
        return ("<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Calcular el cuadrado</title>\n"
                + "</head>"
                + "<body>"
                + "<form action=\"/apps/cuadrado\">"
                + "Numero a calcular cuadrado:<br>"
                + "<input type=int name= value value=0>"
                + "<input type=submit>"
                + "</form>"
                + "</body>"
                + "</html>");
    }
    @Web("media")
    public static String calcMedia() {
        return ("<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Calcular el cuadrado</title>\n"
                + "</head>"
                + "<body>"
                + "<form action=\"/apps/cuadrado/sumar\" method=\"get\">"
                + "Numero a calcular para prueba de la media:<br>"
                + "<input type=\"int\" name= \"value\" value=0>"
                + "<input type=\"submit\">"
                + "</form>"
                + "</body>"
                + "</html>");
    }
    
    @Web("sumar")
    public static String sumar(String n1) {
        
        return "<!DOCTYPE html>"
                +"<html>" + 
                "<head/>" + 
                "<body>" + 
                "<h2> La suma es: "
                + Integer.toString(Integer.parseInt(n1)) 
                + "</h2>" + "</body>" + "</html>";
    }
}
