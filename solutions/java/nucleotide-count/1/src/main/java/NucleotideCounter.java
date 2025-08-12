import java.util.*;

class NucleotideCounter {
    private final String sequence;

     NucleotideCounter(String sequence) {
        if (sequence != null) {
            for (char c : sequence.toCharArray()) {
                if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
                    throw new IllegalArgumentException("Invalid nucleotide: " + c);
                }
            }
        }
        this.sequence = sequence;
    }

    Map<Character, Integer> nucleotideCounts() {
        Map<Character, Integer> map = new HashMap<>();
map.put('A', 0);
map.put('C', 0);
map.put('G', 0);
map.put('T', 0);
        if (sequence == null || sequence.isEmpty()) {
            return map;
        }
        
        for(char c : sequence.toCharArray()){map.put(c, map.getOrDefault(c,0) + 1);
        }

        return map;
    }

}