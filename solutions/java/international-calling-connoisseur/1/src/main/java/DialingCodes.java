import java.util.Map;
import java.util.HashMap;

public class DialingCodes {
    private final Map<Integer, String> map = new HashMap<>();
    
    public Map<Integer, String> getCodes() {
       return map;
    }

    public void setDialingCode(Integer code, String country) {
        map.put(code, country);
    }

    public String getCountry(Integer code) {
        return map.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (map.containsKey(code)) {
        return;
    }
    if (map.containsValue(country)) {
        return;
    }
    map.put(code, country);
    }

    public Integer findDialingCode(String country) {
        return map.entrySet().stream()
            .filter(set -> set.getValue().equals(country))
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(null);
    }

    public void updateCountryDialingCode(Integer code, String country) {
        Integer cd = findDialingCode(country);
        if(cd != null){
            map.remove(cd);
        }
        map.put(code, country);
    }
}
