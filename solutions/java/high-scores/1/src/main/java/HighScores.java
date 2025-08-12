import java.util.*;

class HighScores {
    private final List<Integer> highScores;
    
    public HighScores(List<Integer> highScores) {
        this.highScores = new ArrayList<>(highScores);
    }

    List<Integer> scores() {
        return new ArrayList<>(highScores); 
    }

    Integer latest() {
        return highScores.get(highScores.size() - 1);
    }

    Integer personalBest() {
        return Collections.max(highScores);
    }

    List<Integer> personalTopThree() {
        return highScores.stream()
                         .sorted(Comparator.reverseOrder())
                         .limit(3)
                         .toList();
    }

}
