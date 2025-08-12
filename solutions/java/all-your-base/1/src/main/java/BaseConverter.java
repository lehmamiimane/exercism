import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseConverter {
    private final int number;

    public BaseConverter(int originalBase, int[] originalDigits) {
        if (originalBase < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }

        if (originalDigits.length == 0) {
            this.number = 0;
            return;
        }

        boolean allZeros = true;
        for (int digit : originalDigits) {
            if (digit < 0) {
                throw new IllegalArgumentException("Digits may not be negative.");
            }
            if (digit >= originalBase) {
                throw new IllegalArgumentException("All digits must be strictly less than the base.");
            }
            if (digit != 0) allZeros = false;
        }

        if (allZeros) {
            this.number = 0;
            return;
        }

        // Ignore leading zeros
        int start = 0;
        while (start < originalDigits.length && originalDigits[start] == 0) {
            start++;
        }

        int num = 0;
        for (int i = start; i < originalDigits.length; i++) {
            num = num * originalBase + originalDigits[i];
        }

        this.number = num;
    }

    int[] convertToBase(int newBase) {

        if (newBase < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }
        if(number == 0) return new int[]{0};

        int value = number;
        List<Integer> res = new ArrayList<>();
        
        while(value > 0){
            res.add(value%newBase);
            value/=newBase;
        }

        Collections.reverse(res);
        return res.stream().mapToInt(i->i).toArray();
    }

}