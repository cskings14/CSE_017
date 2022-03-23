import java.util.Comparator;

public class ComparatorByFirst <E1 extends Comparable<E1>, E2> implements Comparator<Pair<E1, E2>> {
    
    public int compare(Pair<E1, E2> p1, Pair<E1, E2> p2) {
        E1 first = p1.getE1();
        E1 second = p2.getE1();
        return first.compareTo(second);
    
    }
}
