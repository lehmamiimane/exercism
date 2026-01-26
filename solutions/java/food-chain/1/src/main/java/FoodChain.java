import java.util.*;


class FoodChain {

 private static final String[] ANIMALS = {
        "fly",
        "spider",
        "bird",
        "cat",
        "dog",
        "goat",
        "cow",
        "horse"
    };

    private static final String[] COMMENTS = {
        "",
        "It wriggled and jiggled and tickled inside her.",
        "How absurd to swallow a bird!",
        "Imagine that, to swallow a cat!",
        "What a hog, to swallow a dog!",
        "Just opened her throat and swallowed a goat!",
        "I don't know how she swallowed a cow!",
        "She's dead, of course!"
    };

    private static final String FINAL_LINE = "I don't know why she swallowed the fly. Perhaps she'll die.";

    public String verse(int verse) {
        StringBuilder sb = new StringBuilder();
        int idx = verse - 1;

        sb.append("I know an old lady who swallowed a ").append(ANIMALS[idx]).append(".\n");

        if (!COMMENTS[idx].isEmpty()) {
            sb.append(COMMENTS[idx]).append("\n");
        }

        if (idx == ANIMALS.length - 1) {
            return sb.toString().trim(); // horse verse: no final line
        }

        for (int i = idx; i > 0; i--) {
            sb.append("She swallowed the ")
              .append(ANIMALS[i])
              .append(" to catch the ")
              .append(ANIMALS[i - 1]);

            if (i - 1 == 1) {
                sb.append(" that wriggled and jiggled and tickled inside her");
            }
            sb.append(".\n");
        }

        sb.append(FINAL_LINE);
        return sb.toString();
    }

    public String verses(int startVerse, int endVerse) {
        StringBuilder sb = new StringBuilder();
        for (int i = startVerse; i <= endVerse; i++) {
            sb.append(verse(i));
            if (i < endVerse) {
                sb.append("\n\n");
            }
        }
        return sb.toString();
    }

}