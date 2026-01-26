import java.util.Objects;

class Clock {
    private int hours;
    private int minutes;

    Clock(int hours, int minutes) {
        int totalMinutes = hours * 60 + minutes;
        totalMinutes = ((totalMinutes % (24 * 60)) + (24 * 60)) % (24 * 60);
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    void add(int minutesToAdd) {
        int totMin = hours * 60 + minutes + minutesToAdd;
        totMin = ((totMin % (24 * 60)) + (24 * 60)) % (24 * 60);

        this.hours = totMin / 60;
        this.minutes = totMin % 60;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Clock)) return false;

        Clock other = (Clock) obj;
        return other.minutes == minutes && other.hours == hours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes);
    }

}

    