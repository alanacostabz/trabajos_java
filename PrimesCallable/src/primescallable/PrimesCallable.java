/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primescallable;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author bryan
 */
public class PrimesCallable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int hilos = 4;
        Instant inicio = Instant.now();
        HashSet<Long> hSet = findPrimes(Long.parseLong(args[0]), hilos);
        Instant fin = Instant.now();

        System.out.println("0-" + args[0] + " Hilos: " + hilos);
        System.out.println("Tiempo de procesamiento:" + Duration.between(inicio, fin));
        System.out.println("Numeros primos encontrados: " + hSet.size());
        //System.out.println(hSet);
    }

    public static HashSet<Long> findPrimes(long numeros, int hilos) {

        HashSet<Long> primes = new HashSet<>();
        ExecutorService service = Executors.newFixedThreadPool(hilos);
        List<Future<HashSet>> lista = new ArrayList<>();
        long rango = numeros / (long) hilos;
        long inicio = 2;
        long fin;
        for (int i = 0; i < hilos; i++) {
            fin = inicio + rango;
            System.out.println(inicio + " - " + fin);
            Callable<HashSet> tarea = (Callable<HashSet>) new primeCall(inicio, fin);
            Future<HashSet> futuro = service.submit(tarea);
            lista.add(futuro);
            inicio = inicio + rango;
        }
        for (Future<HashSet> fut : lista) {
            try {
                HashSet set = fut.get();
                boolean bresult = primes.addAll(set);
                System.out.println(" " + bresult);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
            }

        }
          
        service.shutdown();
        return primes;

    }

}

class primeCall implements Callable {
long inicio;
long fin;   
    public primeCall(long inicio, long fin) {
        this.inicio = inicio;
        this.fin = fin;
    
}
    
    // checar gen book y estudiar para examen
    @Override
    public HashSet<Long> call() throws Exception {
        HashSet<Long> primeSet = new HashSet<>();
        boolean prime;
        for (long n = inicio; n < fin; n++) {
            prime = true;
            for (long j = 2; j < n; j++) {
                if (n % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primeSet.add(n);
            }

        }
        return primeSet;
    }
}
