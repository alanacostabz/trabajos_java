/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientemayusculas;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class ClienteMayusculas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Socket socket = new Socket(args[0],9090);
            System.out.println("Escribe algo: ");
             String cadena = "";
            Scanner scanner = new Scanner(System.in);
            Scanner entrada = new Scanner(socket.getInputStream());
            PrintWriter salida = new PrintWriter(socket.getOutputStream(),true);
            while (scanner.hasNextLine()) {
                String datos = "";
               
                while ((datos = entrada.nextLine()).equals(true)) {
                    cadena= cadena + datos;
                }
                salida.println(scanner.nextLine());
                System.out.println(entrada.nextLine());
            }
            System.out.println(cadena);
        } catch (IOException e){
            System.out.println(e);
        }
    }
    
}
