class RaindropConverter {

    String convert(int number) {
        StringBuilder str = new StringBuilder();

        if(number%3==0) str.append("Pling");
        if(number%5==0) str.append("Plang");
        if(number%7==0) str.append("Plong");

        if(str.isEmpty()) return String.valueOf(number);

        return str.toString();

    }

}
