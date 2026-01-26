class Bob {

        public String hey(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Fine. Be that way!";
        }

        input = input.trim();
        boolean isQuestion = input.endsWith("?");
        boolean hasLetters = input.chars().anyMatch(Character::isLetter);
        boolean isYelling = hasLetters && input.equals(input.toUpperCase());

        if (isYelling && isQuestion) {
            return "Calm down, I know what I'm doing!";
        } else if (isYelling) {
            return "Whoa, chill out!";
        } else if (isQuestion) {
            return "Sure.";
        } else {
            return "Whatever.";
        }
    }

}