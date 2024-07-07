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
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author atellechea
 */
public class Primes {

    //primeThread a = new primeThread();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int hilos = 4;
        Instant inicio = Instant.now();
        HashSet<Long> hSet = findPrimes(Long.parseLong(args[0]));
        Instant fin = Instant.now();

        System.out.println("0-" + args[0] + " Hilos: " + 4);
        System.out.println("Tiempo de procesamiento:" + Duration.between(inicio, fin));
        System.out.println("Numeros primos encontrados: " + hSet.size());
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

    /*public static HashSet<Long> findPrimes(long numero_final, int hilos) {
        HashSet<Long> primeSet = new HashSet<>();
        ExecutorService service = Executors.newFixedThreadPool(hilos);
        long rango = numero_final / (long) hilos;
        long inicio = 1;
        long fin;
        for (int i = 0; i < hilos; i++) {
            fin = inicio + rango - 1;
           System.out.println(inicio + " - " + fin);
            primeThread pt = new primeThread(primeSet, inicio, fin);
            service.execute(pt);
            inicio = inicio + rango;
        }
        try {
            if (service.awaitTermination(10000, TimeUnit.MILLISECONDS)) {

            } else {
                service.shutdownNow();
            }

        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        return primeSet;
    }*/
}
