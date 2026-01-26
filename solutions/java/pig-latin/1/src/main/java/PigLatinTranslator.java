class PigLatinTranslator {
    public String translate(String input) {
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(translateWord(word)).append(" ");
        }

        return result.toString().trim();
    }

    private String translateWord(String word) {
        // Rule 1: Starts with vowel sound or "xr"/"yt"
        if (word.matches("^(xr|yt|[aeiou]).*")) {
            return word + "ay";
        }

        // Rule 3: Word starts with consonant(s) + "qu"
        if (word.matches("^([^aeiou]*qu).*")) {
            int quIndex = word.indexOf("qu");
            return word.substring(quIndex + 2) + word.substring(0, quIndex + 2) + "ay";
        }

        // Rule 4: Consonants followed by 'y'
        int yIndex = word.indexOf('y');
        if (yIndex > 0 && allConsonantsBeforeY(word, yIndex)) {
            return word.substring(yIndex) + word.substring(0, yIndex) + "ay";
        }

        // Rule 2: Move leading consonants before first vowel
        int firstVowel = firstVowelIndex(word);
        return word.substring(firstVowel) + word.substring(0, firstVowel) + "ay";
    }

    private boolean allConsonantsBeforeY(String word, int yIndex) {
        for (int i = 0; i < yIndex; i++) {
            if (isVowel(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private int firstVowelIndex(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (isVowel(c) || (c == 'y' && i != 0)) {
                return i;
            }
        }
        return 0; // fallback
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(Character.toLowerCase(c)) >= 0;
    }
    
}