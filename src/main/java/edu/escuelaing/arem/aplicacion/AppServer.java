package edu.escuelaing.arem.aplicacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;

public class AppServer {

    public static void main(String[] args) throws IOException {
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
        String inputLine, outputLine;
        boolean flag = false;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(in.readLine());
            if (inputLine.startsWith("GET")) {flag = true;}
            else{flag = false;}
            if (!in.ready()) {
                break;
            }
        }
        if(flag){
            System.out.println("Banderaaaaaa");
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
