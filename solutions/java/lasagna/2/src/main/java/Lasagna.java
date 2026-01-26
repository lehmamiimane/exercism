public class Lasagna {


    public int expectedMinutesInOven() {
        return 40;
    }

     public int remainingMinutesInOven(int minute){
         return this.expectedMinutesInOven() - minute;
     }
     public int preparationTimeInMinutes(int layers){
         return 2*layers;
     }
    public int totalTimeInMinutes(int layers, int minutes){
        return minutes + this.preparationTimeInMinutes(layers);
    }
}
