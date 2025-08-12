import java.util.Map;

class RnaTranscription {
    private final Map<Character,Character> map = Map.of('G','C','C','G','T','A','A','U');
    String transcribe(String dnaStrand) {
        char[] dnaStrandChar = dnaStrand.toCharArray();
        StringBuilder str = new StringBuilder();
        for(char c : dnaStrandChar){
            str.append(map.get(c));
        }
        return str.toString();
    }

}
