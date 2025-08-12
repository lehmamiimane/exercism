import java.util.ArrayList;
import java.util.List;

class Proverb {
    private final String[] words;
    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        if (words.length == 0) return "";
        
         List<String> lines = new ArrayList<>();
        for(int i = 0; i < words.length - 1; i++){
            lines.add(String.format("For want of a %s the %s was lost.", words[i], words[i + 1]));
        }
        lines.add(String.format("And all for the want of a %s.", words[0]));

        return String.join("\n", lines);
    }

}
