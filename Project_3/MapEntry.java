public class MapEntry<K,V> {

    private K key;

    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKeyt(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public String toString() {
        return key + ": " + value;
    }
    


    
}
