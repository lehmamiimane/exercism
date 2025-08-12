import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

class ListOps {

    static <T> List<T> append(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>(list1);
        result.addAll(list2);

        return result;
    }

    static <T> List<T> concat(List<List<T>> listOfLists) {
        return listOfLists.stream().flatMap(List::stream).toList();
    }

    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).toList();
    }

    static <T> int size(List<T> list) {
        return (int) list.stream().count();
    }

    static <T, U> List<U> map(List<T> list, Function<T, U> transform) {
        return list.stream().map(transform).toList();
    }

    static <T> List<T> reverse(List<T> list) {
        List<T> result = new ArrayList<>(list);
        Collections.reverse(result);
        return result;
    }

    static <T, U> U foldLeft(List<T> list, U initial, BiFunction<U, T, U> f) {
        U result = initial;
    for (T element : list) {
        result = f.apply(result, element);
    }
    return result;
    }

    static <T, U> U foldRight(List<T> list, U initial, BiFunction<T, U, U> f) {
        U result = initial;
    ListIterator<T> it = list.listIterator(list.size());
    while (it.hasPrevious()) {
        T element = it.previous();
        result = f.apply(element, result);
    }
    return result;
    }

    private ListOps() {
        // No instances.
    }

}
