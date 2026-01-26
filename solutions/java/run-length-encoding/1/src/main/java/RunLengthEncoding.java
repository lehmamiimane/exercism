class RunLengthEncoding {

    public String encode(String input) {
        if (input == null || input.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                if (count == 1) {
                    result.append(input.charAt(i - 1));
                } else {
                    result.append(count).append(input.charAt(i - 1));
                }
                count = 1;
            }
        }

        // Ajout du dernier groupe
        if (count == 1) {
            result.append(input.charAt(input.length() - 1));
        } else {
            result.append(count).append(input.charAt(input.length() - 1));
        }

        return result.toString();
    }

    public String decode(String input) {
        if (input == null || input.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        StringBuilder countBuilder = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                countBuilder.append(c);
            } else {
                int count = countBuilder.length() > 0 ? Integer.parseInt(countBuilder.toString()) : 1;
                result.append(String.valueOf(c).repeat(count));
                countBuilder.setLength(0); // reset
            }
        }

        return result.toString();
    }

}