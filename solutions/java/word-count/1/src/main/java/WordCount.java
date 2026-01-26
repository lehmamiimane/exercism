import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class WordCount {
    public Map<String, Integer> phrase(String input) {
       Map<String, Integer> wordCounts = new HashMap<>();

        
        Pattern wordPattern = Pattern.compile("[a-zA-Z0-9]+(?:'[a-zA-Z0-9]+)?");

        String normalized = input.toLowerCase();

        Matcher matcher = wordPattern.matcher(normalized);
        while (matcher.find()) {
            String word = matcher.group();
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        return wordCounts;
    }
}
