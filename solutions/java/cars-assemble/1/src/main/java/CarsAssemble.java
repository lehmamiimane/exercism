public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double rate = 0;
        if(speed < 5){
            rate = 1;
        } else if ( speed <9){
            rate = 0.9;
        } else if( speed <10){
            rate = 0.8;
        } else {
            rate = 0.77;
        }

        return rate * 221 * speed;
    }

    public int workingItemsPerMinute(int speed) {
        double prod = this.productionRatePerHour(speed);
        return (int) prod / 60;
    }
}
