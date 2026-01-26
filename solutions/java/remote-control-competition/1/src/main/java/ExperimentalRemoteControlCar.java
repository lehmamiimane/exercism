import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class ExperimentalRemoteControlCar implements RemoteControlCar {
    private int units = 0;

    public void drive() {
        units += 20;
    }

    public int getDistanceTravelled() {
        return units;
    }
}



