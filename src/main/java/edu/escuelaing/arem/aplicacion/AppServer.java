package edu.escuelaing.arem.aplicacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;

public class AppServer {

    private static ListaURLHandler handler;
    public static void main(String[] args) throws IOException {
        handler = new ListaURLHandler();
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
        boolean flag = false;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine.contains("/apps"));
            if (inputLine.contains("/apps")) {
                inputLin = inputLine;
            }
            if (!in.ready()) {
                break;
            }
        }
        
        if (inputLin == null) {
            String[] temp;
            temp = inputLin.split(" ");
            System.out.println(temp[1]);
            File f = new File(temp[1].substring(1));
            BufferedReader entrada;
            String flagg = "";
            try {
                entrada = new BufferedReader(new FileReader(f));
                while (entrada.ready()) {
                    flagg += entrada.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Banderaaaaaa");
        } else {
            handler.dirigir(inputLin);
        }
        outputLine = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Servidor</title>\n"
                + "</head>"
                + "</html>" + inputLine;

        out.println(outputLine);
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
