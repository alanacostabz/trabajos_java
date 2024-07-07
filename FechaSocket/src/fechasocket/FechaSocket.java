/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fechasocket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class FechaSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try  (Socket socket = new Socket(args[0], 9000)){
        Scanner input = new Scanner(socket.getInputStream());
            System.out.println("Respuesta: " + input.nextLine());
    } catch (IOException e){
            System.out.println(e);
    }
    
}
}
