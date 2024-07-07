/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primes;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author federicocirettgalan
 */
public class Primes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Instant inicio = Instant.now();
        HashSet<Long> hSet = Findprimes(Long.parseLong(args[0]), 10);
        Instant fin = Instant.now();
        //System.out.println("0-"+args[0]+" Hilos:1");
        System.out.println("Tiempo de procesamiento:" + Duration.between(inicio, fin));
        System.out.println("Numeros primos encontrados:" + (hSet.size()+1));
        //System.out.println(hSet);
    }

    public static HashSet<Long> findPrimes(long numero) {
        HashSet<Long> primeSet = new HashSet<>();
        boolean prime;
        for (long n = 2; n < numero; n++) {
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

    public static HashSet<Long> Findprimes(long numero_final, int hilos) {
        HashSet<Long> Primeset = new HashSet<>();
        ExecutorService servicio = Executors.newFixedThreadPool(hilos);
        long rango = numero_final / (long) hilos;
        long inicio = 0;

        long fin;

        for (int i = 0; i < hilos; i++) {
            fin = inicio + rango - 1;
            System.out.println(inicio + "-" + fin);
            PrimeThread pt = new PrimeThread(Primeset, inicio, fin);
            servicio.execute(pt);
            inicio = inicio + rango;

        }
        try {
                if (servicio.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                    
                } else {
                    servicio.shutdown();
                }
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        return Primeset;
    }

}
