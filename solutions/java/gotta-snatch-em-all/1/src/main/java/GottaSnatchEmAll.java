import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
         return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        boolean check = false; 
        if(!collection.contains(card)){
            collection.add(card);
            check = true;
        }
        return check;
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
         boolean iHaveSomethingTheyDont = myCollection.stream().anyMatch(card -> !theirCollection.contains(card));
         boolean theyHaveSomethingIDont = theirCollection.stream().anyMatch(card -> !myCollection.contains(card));
         return iHaveSomethingTheyDont && theyHaveSomethingIDont;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
         return collections == null || collections.isEmpty()
        ? new HashSet<>()
        : collections.stream()
            .skip(1)
            .reduce(new HashSet<>(collections.get(0)), (a, b) -> {
                a.retainAll(b);
                return a;
            });
    }

    static Set<String> allCards(List<Set<String>> collections) {
        return collections.stream()
            .flatMap(Set::stream)
            .collect(Collectors.toSet());
    }
}
