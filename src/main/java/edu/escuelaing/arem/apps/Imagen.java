/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.apps;

import edu.escuelaing.arem.anotaciones.WebAnnotation;
import edu.escuelaing.arem.anotaciones.WebAnnotation.Web;

/**
 *
 * @author danie
 */
public class Imagen {
    
    @Web("media")
    public static String dibuje() {
        return "<!DOCTYPE html>"
                +"<html>"
                +"<head>"
                +"<title>McClaren Imagen</title>"
                +"</head>"
                +"<body>"
                +"<div align=center><img src=./imgPrue.png /> </div>"
		+"</body>"
                +"</html>";
    }
}
