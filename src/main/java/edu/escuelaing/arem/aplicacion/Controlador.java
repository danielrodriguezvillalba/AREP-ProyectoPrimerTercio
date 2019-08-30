package edu.escuelaing.arem.aplicacion;

/**
 * Hello world!
 *
 */
public class Controlador 
{
    private static AppServer servidor;
    public static void main( String[] args )
    {
        servidor = new AppServer();
        servidor.inicializar();
    }
}
