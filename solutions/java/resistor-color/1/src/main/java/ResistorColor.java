class ResistorColor {
    

    
    int colorCode(String color) {
       color = color.toLowerCase();
    for(int i = 0; i<10; i++){
        if(colors()[i].equals(color)){
            return i;
        }
    }
 throw new IllegalArgumentException("Invalid color: " + color);
    }

    String[] colors() {
        return new String[] {
        "black", "brown", "red", "orange", "yellow", 
        "green", "blue", "violet", "grey", "white"
    };
    }
}
