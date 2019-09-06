package edu.escuelaing.arem.aplicacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppServer {

    private static ListaURLHandler handler;

    public static void main(String[] args) throws IOException {
        handler = new ListaURLHandler();
        boolean continu = true;

        do {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(35000);
            } catch (IOException e) {
                System.err.println("Could not listen on port: 35000.");
                System.exit(1);
            }
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
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
                String[] ina = inputLine.split(" ");
                if (inputLine.contains("/apps")) {
                    sal = handler.dirigir(ina[1]).getBytes();
                    out.println(AppServer.interprete(handler.dirigir(ina[1])));
                    OutputStream outputSteam = clientSocket.getOutputStream();
                    outputSteam.write(sal);
                    outputSteam.flush();
                } else if (inputLine.contains(".png")) {
                    String path = Paths.get("").toAbsolutePath().toString();
                    Path filePath = Paths.get(path, ina[1]);
                    sal = Files.readAllBytes(filePath);
                    out.println(AppServer.interprete(handler.dirigir(ina[1])));
                    OutputStream outputSteam = clientSocket.getOutputStream();
                    outputSteam.write(sal);
                    outputSteam.flush();
                }

                out.close();
                in.close();
                clientSocket.close();
                serverSocket.close();
            } catch (NullPointerException e) {
                System.out.println("No existe la clase que esta buscando");
            }

        } while (continu);

    }

    public static String interprete(String resultado) {
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: " + resultado
                + "\nServer: DanielAREP\r\n"
                + "Status: 200\r\n";
    }

    public static byte[] leerImagen(String direction) {
        byte[] finalData = new byte[]{};

        try {
            File graphicResource = new File(direction);

            System.out.println(graphicResource.getPath());
            FileInputStream inputImage = new FileInputStream((graphicResource.getPath()));
            finalData = new byte[(int) graphicResource.length()];
            inputImage.read(finalData);

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
            System.err.println("Error en la lectura de el archivo");
        }

        return finalData;

    }
}
