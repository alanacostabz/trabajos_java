package primes;

import java.util.HashSet;

/**
 *
 * @author dii
 */
class PrimeThread implements Runnable {

    long start, end;
    HashSet<Long> primeSet = new HashSet<>();

    public PrimeThread(HashSet<Long> primeset, long inicio, long fin) {
        this.start = inicio;
        this.end = fin;
        this.primeSet = primeset;
    }

    @Override
    public void run() {

        boolean prime;
        for (long n = start; n < end; n++) {
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
    }

}
