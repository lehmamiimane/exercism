import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Transpose {
    public String transpose(String input) {
        if (input == null || input.isEmpty()) {
        return input;
    }

    String[] lines = input.split("\n");
    int maxLen = Arrays.stream(lines).mapToInt(String::length).max().orElse(0);

    StringBuilder result = new StringBuilder();

    for (int col = 0; col < maxLen; col++) {
        int lastNonSpaceRow = lines.length - 1;

        while (lastNonSpaceRow >= 0 && col >= lines[lastNonSpaceRow].length()) {
            lastNonSpaceRow--;
        }

        for (int row = 0; row <= lastNonSpaceRow; row++) {
            if (col < lines[row].length()) {
                result.append(lines[row].charAt(col));
            } else {
                result.append(' ');
            }
        }

        if (col < maxLen - 1) {
            result.append('\n');
        }
    }

    return result.toString();
    }
}
