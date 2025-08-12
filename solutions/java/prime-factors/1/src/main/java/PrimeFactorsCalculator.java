import java.util.*;

class PrimeFactorsCalculator {

    List<Long> calculatePrimeFactorsOf(long number) {
       List<Long> factors = new ArrayList<>();
    for (long i = 2; i * i <= number; i++) {
        while (number % i == 0) {
            factors.add(i);
            number /= i;
        }
    }
    if (number > 1) {
        factors.add(number);
    }
    return factors;
    }

}