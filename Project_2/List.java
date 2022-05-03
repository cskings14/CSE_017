public interface List {
    
    public abstract boolean add(E value);

    public abstract int size();

    public abstract ListIterator<E> listIterator();

    public abstract ListIterator<E> listIterator(int index);

}
