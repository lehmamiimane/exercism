import java.util.HashSet;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        Set<Character> set = new HashSet<>();
        for(char c : phrase.toLowerCase().toCharArray()){
            if(Character.isLetter(c)){
                if(!set.add(c)){
                    return false;
                }
            }
        }
        return true;
    }

}
