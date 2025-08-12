class RomanNumerals {
    private final int number;
    RomanNumerals(int number) {
        this.number = number;
    }

    String getRomanNumeral() {
         int num = this.number;
        StringBuilder result = new StringBuilder();

        int[] values =    {1000, 900, 500, 400, 100, 90,  50,  40,  10,   9,   5,   4,   1};
        String[] symbols ={"M",  "CM","D", "CD","C", "XC","L", "XL","X", "IX","V", "IV","I"};

        for(int i =0; i<values.length; i++){
            while(num>=values[i]){
                num-=values[i];
                result.append(symbols[i]);
            }
        }

        return result.toString();
    }
}
