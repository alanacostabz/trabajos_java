/*
PARA USARSE CON SERVIDOR MAYUSCULAS Y SERVERLIST
*/
package clientemayusculas;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Elliot's
 */
public class ClienteMayusculas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try{
        Socket socket = new Socket(args[0],9090);//ip de server
            System.out.println("Escribe algo");
            Scanner scanner = new Scanner(System.in);
            Scanner entrada= new Scanner(socket.getInputStream());
            PrintWriter salida = new PrintWriter(socket.getOutputStream(),true);
            
            while(scanner.hasNextLine()){
                salida.println(scanner.nextLine());
                System.out.println(entrada.nextLine());
            }
        } catch (IOException ioe){System.out.println(ioe);} 
    }
    
}
