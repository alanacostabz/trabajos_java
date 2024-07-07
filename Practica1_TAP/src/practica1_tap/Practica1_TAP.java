/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_tap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Practica1_TAP {

    public static void main(String[] args) {
        String url = "https://www.gutenberg.org/ebooks/84";
        String archivo = "elibro84.html";
        //webReader(url, archivo);
      //  DownloadWebPage(url, archivo);
      int inicio = 200;
      int descarga = 1;
      DescargaPaginas(inicio, descarga);

    }

/* public static void webReader(String webPage, String archivo) {
        try {
            URL url = new URL(webPage);
            String texto;
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            File arc = new File("C:\\Users\\bryan\\Documents\\PROGRAMACION\\TAP\\" + archivo + ".html");
            FileWriter fw = new FileWriter(arc, true);
            while ((texto = br.readLine()) != null) {
                System.out.println(texto);
                fw.write(texto);

            }

            br.close();
            fw.close();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        
    }*/
    
    public static void DownloadWebPage(String webpage, String archivo_salida) {
       BufferedReader  br;
       BufferedWriter  writer;
        try{
            //Crear objeto url
            URL url = new URL(webpage);
            //crear objeto reader
            br  = new BufferedReader ( new InputStreamReader(url.openStream()));
            //archivo a descargar
            writer = new BufferedWriter(new FileWriter(archivo_salida));
            //leer cada linea hasta el final
            String line;
            while ((line = br.readLine())!= null) {
                writer.write(line);
            }
             br.close();
             writer.close();
             System.out.println("Archivo" + archivo_salida + " descargado");
             System.out.println("Creado  con éxito");
        } catch(MalformedURLException mue){
            System.out.println("URL malformado");
        } catch(IOException ie){
            System.out.println("Error de I/O");
        }
      
       
    }
   
    public static void DescargaPaginas(int inicio, int cuenta){
        String pagina, archivo;
        for (int i = cuenta; i < inicio; i++) {
            pagina = "https://www.worldcat.org/oclc"+i;
            archivo = "libro" + i + ".html";
            DownloadWebPage(pagina, archivo);
        }
    }
    
    
}
