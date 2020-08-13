/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soupifycallable;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author dii
 */
public class SoupifyCallable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
       Instant inicio = Instant.now();
       HashMap <String, ArrayList> mapa = genMapa("book", 1016547817, 500, 19);
       Instant fin = Instant.now();
       DespliegaAutores(mapa);
        System.out.println(Duration.between(inicio, fin));
       
       
    }
    
    public static HashMap<String,ArrayList> genMapa(String archivo_base, int inicio, int total, int hilos) throws InterruptedException, ExecutionException{
        HashMap<String,ArrayList> mapa = new HashMap<>();
        try {
            String archivo_libro;
            List<Future> lista = new ArrayList<>();
            ExecutorService service = Executors.newCachedThreadPool();
            for (int i = inicio; i < inicio+total; i++) {
                archivo_libro = archivo_base+i+".html";
                System.out.println(archivo_libro);
                Callable<LibroWCat> tarea = new genLibro(mapa, archivo_libro);
                Future<LibroWCat> futuro = service.submit(tarea);
                lista.add(futuro);
            }
            
            for (Future fut: lista) {
                try {
                    LibroWCat libro = (LibroWCat) fut.get();
                    synchronized(SoupifyCallable.class){
                        ArrayList<LibroWCat> ArrayLibros = mapa.get(libro.autor);
                        if (ArrayLibros != null) {
                            ArrayLibros.add(libro);
                            
                        }else{
                            ArrayLibros = new ArrayList<>();
                            ArrayLibros.add(libro);
                            mapa.put(libro.autor, ArrayLibros);
                                    
                        }
                    }
                    service.shutdown();
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            }
        } catch (Exception e) {
        }
        
        
        
        return mapa;
        
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
            
}
