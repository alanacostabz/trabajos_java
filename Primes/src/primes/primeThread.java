/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primes;

import java.util.HashSet;

/**
 *
 * 
 */
public class primeThread implements Runnable {
    
    long inicio;
    long fin;
    HashSet<Long> primeSet = new HashSet<>();
    
    public primeThread(  HashSet<Long> primeSet, long inicio, long fin){
    this.inicio = inicio;
    this.fin = fin;
    this.primeSet = primeSet;
}
    

    @Override
    public void run() {
      boolean prime;
        for (long n = inicio; n < fin; n++) {
            prime = true;
            for (long j = inicio; j < n; j++) {
                if (n % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primeSet.add(n);
            }

        }
    }
    
}
