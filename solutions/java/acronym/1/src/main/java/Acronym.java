class Acronym {
    private final String acronym;

    Acronym(String phrase) {
        phrase = phrase.replaceAll("[^\\p{IsAlphabetic}\\s-]", "");
        phrase = phrase.replace("-", " "); 

        String[] words = phrase.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)));
            }
        }

        this.acronym = result.toString();
    }

    String get() {
        return acronym;
    }

}
