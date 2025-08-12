public class Lasagna {

    // TODO: define the 'expectedMinutesInOven()' method

    public int expectedMinutesInOven() {
        return 40;
    }

    // TODO: define the 'remainingMinutesInOven()' method
     public int remainingMinutesInOven(int minute){
         return this.expectedMinutesInOven() - minute;
     }
    // TODO: define the 'preparationTimeInMinutes()' method
     public int preparationTimeInMinutes(int layers){
         return 2*layers;
     }
    // TODO: define the 'totalTimeInMinutes()' method
    public int totalTimeInMinutes(int layers, int minutes){
        return minutes + this.preparationTimeInMinutes(layers);
    }
}
