import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Robot {
    private static final Random random = new Random();
    private String name;
    private static final Set<String> userNames = new HashSet<>();
    
    public Robot(){
        reset();
    }
    String getName() {
        return name;
    }

    void reset() {
        String newName;
        do{
            newName = generateName();
        }while(userNames.contains(newName));
        userNames.add(newName);
        this.name = newName;
    }

    private String generateName(){
        char first = (char) ('A' + random.nextInt(26));
        char second = (char) ('A' + random.nextInt(26));
        int number = random.nextInt(1000); // 000 à 999
        return "" + first + second + String.format("%03d", number);
    }

}