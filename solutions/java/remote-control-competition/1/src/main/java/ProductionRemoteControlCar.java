import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar>{

    private int units = 0;
    private int numberOfVictories;
    
    public ProductionRemoteControlCar() {
        this(0, 0);
    }

    public ProductionRemoteControlCar(int units, int numberOfVictories) {
        this.units = units;
        this.numberOfVictories = numberOfVictories;
    }

    public void drive() {
        units += 10;
    }

    public int getDistanceTravelled() {
        return units;
    }

    public int getNumberOfVictories() {
        return this.numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar other) {
        return Integer.compare(other.numberOfVictories, this.numberOfVictories); // tri décroissant
    }
}
