public class PangramChecker {

    public boolean isPangram(String input) {
        int[] str = new int[26];  
    for (char c : input.toCharArray()) {
        if (Character.isAlphabetic(c)) {  
            char ch = Character.toLowerCase(c);
            str[ch - 'a']++;
        }
    }
    for (int i = 0; i < 26; i++) {
        if (str[i] == 0) {  
            return false;
        }
    }
    return true;
    }

}
