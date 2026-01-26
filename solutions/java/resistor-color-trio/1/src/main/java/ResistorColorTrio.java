import java.util.Map;

class ResistorColorTrio {
     private static final Map<String, Integer> COLOR_MAP = Map.of(
        "black", 0, "brown", 1, "red", 2, "orange", 3,
        "yellow", 4, "green", 5, "blue", 6,
        "violet", 7, "grey", 8, "white", 9
    );

    public String label(String[] colors) {
        long value = (COLOR_MAP.get(colors[0]) * 10L + COLOR_MAP.get(colors[1])) 
               * (long) Math.pow(10, COLOR_MAP.get(colors[2]));

    String unit;
    double displayValue;

    if (value >= 1_000_000_000L) {
        unit = "gigaohms";
        displayValue = value / 1_000_000_000.0;
    } else if (value >= 1_000_000) {
        unit = "megaohms";
        displayValue = value / 1_000_000.0;
    } else if (value >= 1_000) {
        unit = "kiloohms";
        displayValue = value / 1_000.0;
    } else {
        unit = "ohms";
        displayValue = value;
    }

    return (displayValue == (int) displayValue)
        ? String.format("%d %s", (int) displayValue, unit)
        : String.format("%.1f %s", displayValue, unit);
    }
}
