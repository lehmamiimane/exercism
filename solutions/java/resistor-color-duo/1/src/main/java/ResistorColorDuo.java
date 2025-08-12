class ResistorColorDuo {
      private static final String[] COLORS = {
        "black", "brown", "red", "orange", "yellow", 
        "green", "blue", "violet", "grey", "white"
    };

    int value(String[] colors) {
        int firstDigit = getColorCode(colors[0].toLowerCase());
        int secondDigit = getColorCode(colors[1].toLowerCase());
        return firstDigit * 10 + secondDigit;
    }

    private int getColorCode(String color) {
        for (int i = 0; i < COLORS.length; i++) {
            if (COLORS[i].equals(color)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid color: " + color);
    }
}
