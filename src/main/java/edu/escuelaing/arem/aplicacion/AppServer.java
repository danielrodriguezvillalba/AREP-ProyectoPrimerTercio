package edu.escuelaing.arem.aplicacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.escuelaing.arem.anotaciones.WebAnnotation.Web;
import edu.escuelaing.arem.handlers.Handler;
import edu.escuelaing.arem.handlers.impl.methodHandler;
import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;
import static java.lang.System.out;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class AppServer {

    private static ListaURLHandler handler;

    public void inicializar() throws IOException {
        handler = new ListaURLHandler();
        boolean continu = true;

        do {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(getPort());
            } catch (IOException e) {
                System.err.println("Could not listen on port: 35000.");
                System.exit(1);
            }
            Socket clientSocket = null;
            try {
                out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String inputLine, outputLine, inputLin = null;
            byte[] sal = null;
            boolean flag = false;
            inputLine = in.readLine();
            try {
                OutputStream outputSteam = clientSocket.getOutputStream();
                String[] ina = inputLine.split(" ");
                String[] clas = inputLine.split("/");
                if (ina[1].contains("/apps")) {
                    if (!handler.busque(ina[1])) {
                        Class<?> c = Class.forName("edu.escuelaing.arep.apps" + clas[1] );
                        for (Method metodo : c.getMethods()) {
                            System.out.println(c.getMethods().length);
                            if (metodo.isAnnotationPresent(Web.class)) {
                                System.out.println("entra2");
                                Handler metod = new methodHandler(metodo);
                                handler.put("/app/" + c.getSimpleName() + "/" + metodo.getAnnotation(Web.class).value(), metod);
                            }

                        }
                    } else {
                        outputSteam.write(imprima(handler.dirigir(ina[1])).getBytes());
                    }

                    //outputSteam.flush();
                } else if (ina[1].contains(".png")) {
                    imagen(ina[1], clientSocket.getOutputStream(), out);
                } else if (ina[1].contains(".ico")) {
                    outputSteam.write(("HTTP/1.1 404 Not Found \r\n"
                            + "Content-Type: text/html; charset=\"utf-8\" \r\n"
                            + "\r\n"
                            + "<!DOCTYPE html>"
                            + "<html>"
                            + "<head>"
                            + "<meta charset=UTF-8>"
                            + "<title>Recurso no encontrado</title>"
                            + "</head>"
                            + "<body>"
                            + "Recurso no encontrado"
                            + "</body>"
                            + "</html>").getBytes());

                } else {
                    outputSteam.write(("HTTP/1.1 404 Not Found \r\n"
                            + "Content-Type: text/html; charset=\"utf-8\" \r\n"
                            + "\r\n"
                            + "<!DOCTYPE html>"
                            + "<html>"
                            + "<head>"
                            + "<meta charset=UTF-8>"
                            + "<title>Recurso no encontrado</title>"
                            + "</head>"
                            + "<body>"
                            + "Recurso no encontrado."
                            + "</body>"
                            + "</html>").getBytes());
                }

            } catch (NullPointerException e) {
                out.print("No existe lo que pide que esta buscando");
            } catch (ClassNotFoundException ex) {
                out.print("No existe la clase que esta buscando");
            } finally {
                out.close();
                in.close();
                clientSocket.close();
                serverSocket.close();
            }

        } while (continu);

    }

    private String imprima(String param) {
        return "HTTP/1.1 200 OK \r\n"
                + "Content-Type: text/html; charset=\"utf-8\" \r\n"
                + "\r\n"
                + param;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static void imagen(String element, OutputStream clientOutput, PrintWriter out) throws IOException {
        try {
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + element));
            ByteArrayOutputStream ArrBytes = new ByteArrayOutputStream();
            DataOutputStream writeimg = new DataOutputStream(clientOutput);
            String imagen = "HTTP/1.1 404 Not Found \r\n"
                    + "Content-Type: text/html; charset=\"utf-8\" \r\n"
                    + "\r\n";
            //out.write(imagen.getBytes());
            ImageIO.write(image, "PNG", ArrBytes);
            writeimg.writeBytes("HTTP/1.1 200 OK \r\n");
            writeimg.writeBytes("Content-Type: image/png \r\n");
            writeimg.writeBytes("\r\n");
            writeimg.write(ArrBytes.toByteArray());
            System.out.println(System.getProperty("user.dir") + "/resources/imagenes/" + element);
        } catch (IOException e) {
        }

    }

}
