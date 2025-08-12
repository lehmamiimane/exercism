import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.Arrays;


class ParallelLetterFrequency {
    
    private final String[] texts;
    
    ParallelLetterFrequency(String[] texts) {
        this.texts = texts;
    }

    Map<Character, Integer> countLetters() {
        return Arrays.stream(texts).parallel()
            .flatMapToInt(String::chars)
            .mapToObj(c-> (char ) c)
            .map(Character::toLowerCase)
            .filter(Character::isLetter)
            .collect(Collectors.toConcurrentMap(
                c -> c,
                c -> 1,
                Integer::sum
            ));
            
    }

}
