/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketfecha;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author bryan
 */
public class SocketFecha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try(ServerSocket listener = new ServerSocket(9000) ){
            System.out.println("El servidor de fecha esta corriendo");
            while (true) {
                try(Socket socket = listener.accept()){
                    PrintWriter salida;
                    salida = new PrintWriter (socket.getOutputStream(), true);
                    salida.println(new Date().toString());
                    System.out.println("servido!");
                }
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }
    
}
