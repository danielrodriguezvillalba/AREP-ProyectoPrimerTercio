package edu.escuelaing.arem.aplicacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
                System.out.println(inputLine);
                if (ina[1].contains("/apps")) {
                    sal = handler.dirigir(ina[1]).getBytes();
                    out.println(AppServer.interprete(handler.dirigir(ina[1])));
                    OutputStream outputSteam = clientSocket.getOutputStream();
                    outputSteam.write(sal);
                    outputSteam.flush();
                } else if (ina[1].contains(".png")) {
                    handleImage(ina[1], clientSocket.getOutputStream(), out);
                } else if (ina[1].contains(".ico")) {
                    out.print("HTTP/1.1 404 NOT FOUND\r\n");

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

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static void handleImage(String element, OutputStream clientOutput, PrintWriter out) throws IOException {
        try {
            BufferedImage image = ImageIO
                    .read(new File(System.getProperty("user.dir") + element));
            ByteArrayOutputStream ArrBytes = new ByteArrayOutputStream();
            DataOutputStream writeimg = new DataOutputStream(clientOutput);
            ImageIO.write(image, "jpg", ArrBytes);
            writeimg.writeBytes("HTTP/1.1 200 OK \r\n");
            writeimg.writeBytes("Content-Type: image/jpg \r\n");
            writeimg.writeBytes("Content-Length: " + ArrBytes.toByteArray().length + "\r\n");
            writeimg.writeBytes("\r\n");
            writeimg.write(ArrBytes.toByteArray());
            System.out.println(System.getProperty("user.dir") + "\\recursos\\imagenes\\" + element);
        } catch (IOException e) {

        }

    }

}
