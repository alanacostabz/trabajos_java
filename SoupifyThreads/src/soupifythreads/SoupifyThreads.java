/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soupifythreads;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author bryan
 */
public class SoupifyThreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String archivo_base = "book";
        int inicio = 1016547817;
         int total = 500;
        Instant ini = Instant.now();
           HashMap<String, ArrayList> map_libros = generaMapa(archivo_base, inicio, total);
           Instant fin = Instant.now();
        System.out.println("Tiempo: " + Duration.between(ini, fin));
     
        //DespliegaMapa(map_libros);
        DespliegaAutores(map_libros);

        /* String archivo = "ebook1016547817.html";
        LibroWCat libro = generaLibro(archivo);*/
        //System.out.println(libro.autor);
    }

    public static HashMap<String, ArrayList> generaMapa(String base, int inicio, int total) {
        HashMap<String, ArrayList> mapa = new HashMap<>();
        try {
            ExecutorService service = Executors.newFixedThreadPool(4);
            String archivo_libro;
            for (int i = inicio; i < inicio+total; i++) {
                archivo_libro = base + i + ".html";
             //   System.out.println(archivo_libro);
                genBook t = new genBook(mapa, archivo_libro);
                service.execute(t);
            }
            //service.shutdown();
            if (service.awaitTermination(6000, TimeUnit.MILLISECONDS)) {

            } else {
                service.shutdownNow();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return mapa;
        /* try {
            String archivo_libro;
            for (int i = inicio; i < inicio + total; i++) {
                archivo_libro = base + i + ".html";
               LibroWCat libro = generaLibro(archivo_libro);
            
                ArrayList<LibroWCat> ArrayLibros = mapa.get(libro.autor);
                if (ArrayLibros != null) {
                    ArrayLibros.add(libro);
                } else{
                ArrayLibros = new ArrayList<LibroWCat>();
                ArrayLibros.add(libro);
                mapa.put(libro.autor, ArrayLibros);
            }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }*/

    }

    public static void DespliegaAutores(HashMap<String, ArrayList> map) {
        int total = 0;
        int num_ejemplares;
        for (HashMap.Entry<String, ArrayList> entrada : map.entrySet()) {
            num_ejemplares = entrada.getValue().size();
            System.out.println(entrada.getKey() + ":" + num_ejemplares);
            total = total + num_ejemplares;
        }
        System.out.println("------------------------");
        System.out.println("total ejemplares:" + total);
        System.out.println("total autores :" + map.size());
        System.out.println("-----");

    }

    /*   public static void DespliegaMapa(HashMap<String, ArrayList> map) {
        for (HashMap.Entry<String, ArrayList> valor : map.entrySet()) {
            ArrayList<LibroWCat> lista_libros = valor.getValue();
            for (LibroWCat libro : lista_libros) {
                System.out.println("Titulo:" + libro.titulo);
                System.out.println("Autor:" + libro.autor);
                System.out.println("----------------------");

            }
        }
    }*/

 /*  public static LibroWCat generaLibro(String nombre_archivo) {
        LibroWCat ejemplar = null;
        String t = "", a = "", p = "", i = "", o = "", n = "", d = "";
        try {
            File input = new File(nombre_archivo);
            Document doc;
            try {

                doc = Jsoup.parse(input, "UTF-8");
                Elements titulo = doc.getElementsByClass("title");
                t = titulo.text();
                //      System.out.println(t);

                try {
                    Elements autor = doc.getElementsByAttributeValue("title", "Search for more by this author");
                    a = autor.get(0).text();
                } catch (Exception exa) {
                    a = " ";
                }
                //   System.out.println(a);
                try {
                    Elements publisher = doc.getElementsByAttributeValue("id", "bib-publisher-cell");
                    p = publisher.text();
                } catch (Exception exp) {
                    p = " ";
                }
                //  System.out.println(p);
                try {
                    Element isbn = doc.getElementById("details-standardno");
                    i = isbn.text();
                    // System.out.println(i);
                } catch (Exception exp) {
                    p = " ";
                }
                try {
                    Element oclc = doc.getElementById("details-oclcno");
                    o = oclc.text();
                    //   System.out.println(o);
                } catch (Exception exp) {
                    p = " ";
                }
                try {
                    Element notes = doc.getElementById("details-notes");
                    n = notes.text();
                    //  System.out.println(n);
                } catch (Exception exp) {
                    p = " ";
                }
                try {
                    Element des = doc.getElementById("details-description");
                    d = des.text();
                    // System.out.println(d);
                } catch (Exception exp) {
                    p = " ";
                }
                //ejemplar = new lib--
            } catch (IOException ex) {

            }

        } catch (Exception ex) {

        }
        ejemplar = new LibroWCat(t, a, p, i, o, n, d);
        return ejemplar;
    }*/
}
