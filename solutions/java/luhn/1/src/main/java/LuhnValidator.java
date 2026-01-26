class LuhnValidator {

    boolean isValid(String candidate) {
        // Supprimer les espaces
        String sanitized = candidate.replace(" ", "");

        // Vérifier si la chaîne est invalide (longueur <= 1 ou contient un caractère non numérique)
        if (sanitized.length() <= 1 || !sanitized.matches("\\d+")) {
            return false;
        }

        int sum = 0;
        boolean doubleDigit = false;

        // Parcourir les chiffres de droite à gauche
        for (int i = sanitized.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(sanitized.charAt(i));
            if (doubleDigit) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
            doubleDigit = !doubleDigit; // alterner pour doubler un chiffre sur deux
        }

        return sum % 10 == 0;

    }

}
