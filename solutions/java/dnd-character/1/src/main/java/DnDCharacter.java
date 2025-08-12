import java.util.List;
import java.util.Random;
import java.util.*;

class DnDCharacter {
    private static final Random RANDOM = new Random();

    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;

    public DnDCharacter() {
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.constitution = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());
    }

    List<Integer> rollDice() {
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            rolls.add(RANDOM.nextInt(6) + 1);
        }
        return rolls;
    }

     int ability(List<Integer> scores) {
        List<Integer> copy = new ArrayList<>(scores);
        copy.remove(Collections.min(copy)); 
        int sum = 0;
        for (int score : copy) {
            sum += score;
        }
        return sum;
    }

    public int modifier(int score) {
        return (int) Math.floor((score - 10) / 2.0);
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getHitpoints() {
        return 10 + modifier(constitution);
    }
}
