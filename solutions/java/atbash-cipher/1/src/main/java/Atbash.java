class Atbash {

  String encode(String input) {
        StringBuilder sb = new StringBuilder();
        int currentBatchCharCnt = 0;

        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                c = Character.toLowerCase(c);
                sb.append(transformCharacter(c));
                currentBatchCharCnt++;

                // Ajoute un espace tous les 5 caractères
                if (currentBatchCharCnt == 5) {
                    sb.append(' ');
                    currentBatchCharCnt = 0;
                }
            }
        }

        // Supprime l'espace final si nécessaire
        return sb.toString().trim();
    }

    // Décode un message Atbash (même logique que encode)
    String decode(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(transformCharacter(Character.toLowerCase(c)));
            }
        }

        return result.toString();
    }

    // Transforme un caractère : miroir pour les lettres, inchangé pour les chiffres
    private char transformCharacter(char c) {
        if (Character.isDigit(c)) {
            return c;
        }
        return (char) ('z' - (c - 'a'));
    }

}
