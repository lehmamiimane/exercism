class RotationalCipher {
    private final int shiftKey;
    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey % 26;
    }

    String rotate(String data) {
        
        StringBuilder str = new StringBuilder();
        for(char c : data.toCharArray()){
            if(Character.isLowerCase(c)){
                char shifted = (char) ('a' + (c - 'a' +shiftKey)%26);
                str.append(shifted);
            } else if(Character.isUpperCase(c)){
                char shifted = (char) ('A' + (c - 'A' +shiftKey)%26);
                str.append(shifted);
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }

}
