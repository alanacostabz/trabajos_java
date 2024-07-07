/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloadurlthreaded;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class getWebPage implements Runnable {

    String webpage;
    String archivo_salida;
    
    public getWebPage(String pagina, String archivo) {
        webpage = pagina;
        archivo_salida = archivo;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(webpage);
            BufferedWriter writer;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                writer = new BufferedWriter(new FileWriter(archivo_salida));
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                }
                writer.close();
                System.out.println("Archivo: " + archivo_salida + " descargado");
            }
        } catch (MalformedURLException mue) {
            System.out.println("URL malformado");
        } catch (IOException ie) {
            System.out.println("Error de I/O");
        }
    }
    
    public static void DescargaPaginasEjecutar(int inicio, int total, String link_base, String archivo_base){
        int libro;
        String url;
        String archivo;
        
        ExecutorService servicio =  Executors.newFixedThreadPool(2);
        for(int i = 0;  i<total; i++)
        {
            libro = inicio + i;
            url = link_base + libro;
            archivo = archivo_base + libro + ".html";
            getWebPage hilo = new getWebPage(url, archivo);
          servicio.execute(hilo);
            
        }
        servicio.shutdown();
} 
}
    
    



