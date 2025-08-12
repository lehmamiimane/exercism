import java.util.*;
import java.util.Collections;

class BinarySearch {
    private final List<Integer> items;

    BinarySearch(List<Integer> items) {
        this.items = new ArrayList<>(items); // copie modifiable
        Collections.sort(this.items);
    }

    int indexOf(int item) throws ValueNotFoundException {
        int left = 0;
        int right = items.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int midValue = items.get(middle);

            if (midValue == item) {
                return middle;
            }

            if (midValue > item) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        throw new ValueNotFoundException("Value not in array");
    }
}
