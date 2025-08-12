import java.util.*;

class Allergies {
private final int score;

    Allergies(int score) {
        this.score = score;
    }

    boolean isAllergicTo(Allergen allergen) {
        return (score & allergen.getScore()) != 0;
    }

    List<Allergen> getList() {
        List<Allergen> result = new ArrayList<>();
        for (Allergen allergen : Allergen.values()) {
            if (isAllergicTo(allergen)) {
                result.add(allergen);
            }
        }
        return result;
    }
}
