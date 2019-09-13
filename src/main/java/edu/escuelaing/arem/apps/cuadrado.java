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
                + "<form action=\"/apps/cuadrado/eleve\">"
                + "Numero a calcular su cuadrado:<br>"
                + "<input type=int name= value value=0>"
                + "<input type=submit>"
                + "</form>"
                + "</body>"
                + "</html>");
    }
    @Web("division")
    public static String calcDiv() {
        return ("<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Calcular la division</title>\n"
                + "</head>"
                + "<body>"
                + "<form action=\"/apps/cuadrado/divida\" method=\"get\">"
                + "Numero a calcular la division entre 2:<br>"
                + "<input type=\"int\" name= \"value\" value=0>"
                + "<input type=\"submit\">"
                + "</form>"
                + "</body>"
                + "</html>");
    }
    
    @Web("eleve")
    public static String sumar(String n1) {
        int num = Integer.parseInt(n1);
        return "<!DOCTYPE html>"
                +"<html>" + 
                "<head/>" + 
                "<body>" + 
                "<h2> El numero al cuadrado es : "
                + Integer.toString((int) Math.pow(num, 2))
                + "</h2>" + "</body>" + "</html>";
    }
    
    @Web("divida")
    public static String divida(String n1) {
        int num = Integer.parseInt(n1);
        return "<!DOCTYPE html>"
                +"<html>" + 
                "<head/>" + 
                "<body>" + 
                "<h2> El numero dado dividido en 2 es : "
                + Integer.toString(num/2)
                + "</h2>" + "</body>" + "</html>";
    }
}
