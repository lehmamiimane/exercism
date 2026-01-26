public class JedliksToyCar {
   private int distance = 0;  // Tracks the total distance driven
    private int battery = 100; // Tracks the battery level (0 to 100%)
    
    // Static method to create a new JedliksToyCar instance
    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    // Method to display the distance driven
    public String distanceDisplay() {
        return "Driven " + distance + " meters";
    }

    // Method to display the battery status
    public String batteryDisplay() {
        if (battery <= 0) {
            return "Battery empty";
        }
        return "Battery at " + battery + "%";
    }

    // Method to drive the car (drives 20 meters and drains 1% battery)
    public void drive() {
        if (battery > 0) {
            distance += 20;   // Drive 20 meters
            battery -= 1;     // Drain 1% battery
        }
    }
}
