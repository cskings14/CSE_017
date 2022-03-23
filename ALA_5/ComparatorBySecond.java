import java.util.Comparator;

//
// 
public class ComparatorBySecond <E1, E2 extends Comparable<E2>> implements Comparator<Pair<E1, E2>> {
    
    public int compare(Pair<E1, E2> p1, Pair<E1, E2> p2) {
        E2 first = p1.getE2();
        E2 second = p2.getE2();
        return first.compareTo(second);
    
    }
}

