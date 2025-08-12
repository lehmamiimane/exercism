import java.util.*;

class Series {
     private final String digits;

    Series(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("series cannot be empty");
        }
        if (!string.matches("\\d+")) {
            throw new IllegalArgumentException("series must only contain digits");
        }
        this.digits = string;
    }

    List<String> slices(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("slice length cannot be negative or zero");
        }
        if (num > digits.length()) {
            throw new IllegalArgumentException("slice length cannot be greater than series length");
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i <= digits.length() - num; i++) {
            result.add(digits.substring(i, i + num));
        }
        return result;
    }
}
