import java.util.*;
import java.util.stream.*;

class SumOfMultiples {
    private final int number;
    private final int[] set;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        

        return Arrays.stream(set)
            .flatMap(base -> IntStream.range(1, number)
                    .map(i -> i*base)
                    .takeWhile(n -> n < number)
                    ).distinct().sum();
}

}