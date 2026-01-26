import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Anagram {
    private String word;
    public Anagram(String word) {
     this.word = word;
    }

    public List<String> match(List<String> candidates) {
        List<String> result = new ArrayList<>();
        String sortedWord = sorted(word.toLowerCase());
        for(String candidate : candidates){
            if(!candidate.equalsIgnoreCase(word)){
                if(sortedWord.equals(sorted(candidate.toLowerCase()))){
                    result.add(candidate);
                }
            }
        }
        return result;
    }

    private String sorted(String stc){
        List<Character> chars = new ArrayList<>();
        for(char c : stc.toCharArray()){
            chars.add(c);
        }
        Collections.sort(chars);
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            sb.append(c);
        }
        return sb.toString();
    }

}