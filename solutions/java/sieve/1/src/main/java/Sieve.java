import java.util.*;

class Sieve {
     private final int maxPrime;

    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<>();
        if (maxPrime < 2) {
            return primes; 
        }

        boolean[] isPrime = new boolean[maxPrime + 1];
        Arrays.fill(isPrime, true);
        isPrime[0]=isPrime[1]=false;

        for(int p = 2; p *p <= maxPrime; p++){
            if(isPrime[p]){
                for(int multi = p*p; multi <= maxPrime; multi += p){
                    isPrime[multi] = false;
                }
            }
        }

        for (int i = 2; i <= maxPrime; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
