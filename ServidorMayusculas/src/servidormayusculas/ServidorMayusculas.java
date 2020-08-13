/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidormayusculas;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Mayusculas implements Runnable {

    private Socket socket;

    public Mayusculas(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            Scanner entrada = new Scanner(socket.getInputStream());
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Conectado: " + socket);
            while (entrada.hasNextLine()) {
                String cadena = entrada.nextLine();
                if (cadena.equals("list")) {
                    System.out.println("Pie de lista");
                    salida.println("Aaaaaaah perro , pediste lista");
                    
                }
                System.out.println(cadena);
                cadena = cadena.toUpperCase();
                salida.println(cadena);
                System.out.println(cadena);
                //salida.println(entrada.nextLine().toUpperCase());
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                socket.close();
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
            System.out.println("Conexion cerrada: " + socket);
        }
    }
}

public class ServidorMayusculas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            ServerSocket listener = new ServerSocket(9090);
            while (true) {
                service.execute(new Mayusculas(listener.accept()));
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
