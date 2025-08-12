import java.util.*;

class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> res = new HashMap<>();
        for (Map.Entry<Integer, List<String>> entry : old.entrySet()) {
            for (String s : entry.getValue()) {
                res.put(s.toLowerCase(), entry.getKey());
            }
        }
        return res;
    }
}
