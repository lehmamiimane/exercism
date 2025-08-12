import java.util.Map;

class SqueakyClean {
    static String clean(String identifier) {

        Map<Character, Character> leetMap = Map.of(
                '4', 'a',
                '3', 'e',
                '0', 'o',
                '1', 'l',
                '7', 't',
                '5', 's'
        );
        StringBuilder result = new StringBuilder();
        boolean toUpper = false;
        for (int i = 0; i < identifier.length(); i++) {
            char c = identifier.charAt(i);
            if (c == ' ') {
                result.append('_');
                toUpper = false;
            } else if (c == '-') {
                toUpper = true;
            } else if (leetMap.containsKey(c)) {
                char mapped = leetMap.get(c);
                result.append(toUpper ? Character.toUpperCase(mapped) : mapped);
                toUpper = false;
            } else if (Character.isLetter(c)) {
                result.append(toUpper ? Character.toUpperCase(c) : c);
                toUpper = false;
            }
        }
        return result.toString();
    }
}