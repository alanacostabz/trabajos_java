/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidormayusculas;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author bryan
 */
public class ServidorMayusculas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            ServerSocket listener = new ServerSocket(9090);
            System.out.println("Servidor corriendo!!!");
            while (true) {
                service.execute(new Mayusculas(listener.accept()));
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    private static class Mayusculas implements Runnable {

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
                    // salida.println(entrada.nextLine().toUpperCase());
                    String cadena = entrada.nextLine();
                    String[] partes = cadena.split(" ");

                    if (partes[0].equals("list")) {
                        /*System.out.println("Pide lista");
                        salida.println("Pediste lista");*/
                        cadena = ListaDirectorio(partes[1]);
                        salida.println(cadena);
                        System.out.println("--------");
                        System.out.println(cadena);
                        System.out.println("--------");
                        
                    }
                    
                    if (partes[0].equals("GET")) {
                        OutputStream out = socket.getOutputStream();
                        String archivo = partes[1];
                        byte[] buffer = obtenerArchivo(archivo);
                        System.out.println("Enviado archivo " + archivo);
                        out.write(buffer,0,buffer.length);
                        out.flush();
                        
                    }

                    /* cadena = cadena.toUpperCase();
                    salida.println(cadena);
                    System.out.println(cadena);*/
                }

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    socket.close();
                } catch (IOException IOE) {
                    System.out.println(IOE);
                }
                System.out.println("Conexion cerrada: " + socket);
            }
        }

    }

    public static String ListaDirectorio(String folder) {
        String cadena = "" ;
        
        File dir = new File(folder);
        File[] filesList = dir.listFiles();
       // String listaDir = "";
       int i = 0;
        for (File file : filesList) {
            if (file.isFile()) {
              //  System.out.println(file.getName());
              
              //  listaDir = file.getName();
                //   System.out.println("");
               //cadena += file.getName() ;
               cadena = cadena +"\n" + file.getName();  
               //cadena +=  "\n" ;
                
          
              

            }
        }
        
        return  cadena;
    }
   public static byte[] obtenerArchivo(String archivo) throws FileNotFoundException, IOException{
        File mi_archivo = new File(archivo);
        byte[] mi_buffer = new byte[(int) mi_archivo.length()];
       FileInputStream fis = new FileInputStream(mi_archivo);
       BufferedInputStream bi = new BufferedInputStream(fis);
       bi.read(mi_buffer,0,mi_buffer.length);
       bi.close();
       return mi_buffer;
    }
    }

