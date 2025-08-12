class PhoneNumber {
     private final String number;

    public PhoneNumber(String input) {
        if (input.matches(".*[a-zA-Z].*")) {
            throw new IllegalArgumentException("letters not permitted");
        }

        
        if (!input.matches("^\\+?[\\d\\s().-]*$")) {
            throw new IllegalArgumentException("punctuations not permitted");
        }

        String cleaned = input.replaceAll("\\D", "");

        if (cleaned.length() < 10) {
            throw new IllegalArgumentException("must not be fewer than 10 digits");
        }

        if (cleaned.length() > 11) {
            throw new IllegalArgumentException("must not be greater than 11 digits");
        }

        if (cleaned.length() == 11) {
            if (!cleaned.startsWith("1")) {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
            cleaned = cleaned.substring(1);
        }

        char areaCodeFirst = cleaned.charAt(0);
        char exchangeCodeFirst = cleaned.charAt(3);

        if (areaCodeFirst == '0') {
            throw new IllegalArgumentException("area code cannot start with zero");
        }
        if (areaCodeFirst == '1') {
            throw new IllegalArgumentException("area code cannot start with one");
        }
        if (exchangeCodeFirst == '0') {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        }
        if (exchangeCodeFirst == '1') {
            throw new IllegalArgumentException("exchange code cannot start with one");
        }

        this.number = cleaned;
    }

    public String getNumber() {
        return number;
    }

}