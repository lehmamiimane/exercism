import java.util.*;
class School {
   private final Map<Integer, List<String>> map = new TreeMap<>();
    private final Set<String> enrolledStudents = new HashSet<>();

    boolean add(String student, int grade) {
        if (enrolledStudents.contains(student)) {
            return false; 
        }

        map.putIfAbsent(grade, new ArrayList<>());
        map.get(grade).add(student);
        Collections.sort(map.get(grade));

        enrolledStudents.add(student);
        return true;
    }

    List<String> roster() {
        return map.values().stream()
                  .flatMap(List::stream)
                  .toList();
    }

    List<String> grade(int grade) {
        return List.copyOf(map.getOrDefault(grade, List.of()));
    }
}
