public class HashMapLP<K, V> implements Map<K, V> {

    // hash table with liner probing
    // the methods: rehash, clear, get, put, toList, toString
    private int size;
	private double loadFactor;
	private static int collisions = 0;
	private LinkedList<MapEntry<K,V>>[] hashTable;

    public HashMapLP(int c, double lf ){
        this.capacity = c;
        this.loadFactor = lf;
        this.hashTable = new LinkedList[capacity];
        this.size = 0;
    }

    public HashMapLP(int c){
        this(c, 0.9);
    }



    public get(K key){
        int hashCode = key.hashCode();
        int index = hash(hashCode);
        LinkedList<MapEntry<K,V>> list = hashTable[index];
        if(list == null)
            return null;
        for(MapEntry<K,V> entry: list){
            if(entry.getKey().equals(key))
                return entry.getValue();
        }
        return null;
    }

    public put(K key, V val){
        int hashCode = key.hashCode();
        int index = hash(hashCode);
        LinkedList<MapEntry<K,V>> list = hashTable[index];
        if(list == null){
            list = new LinkedList<MapEntry<K,V>>();
            hashTable[index] = list;
        }
        for(MapEntry<K,V> entry: list){
            if(entry.getKey().equals(key)){
                entry.setValue(val);
                return;
            }
        }
        list.add(new MapEntry<K,V>(key, val));
        size++;
        if(size > loadFactor * capacity)
            rehash();
    }

    public toList(){
        ArrayList<MapEntry<K,V>> list = new ArrayList<MapEntry<K,V>>();
        for(int i=0; i< hashTable.length; i++){
            if(hashTable[i] != null){
                LinkedList<MapEntry<K,V>> ll = hashTable[i];
                for(MapEntry<K,V> entry: ll)
                    list.add(entry);
            }
        }
        return list;
    }

    public toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0; i< hashTable.length; i++){
            if(hashTable[i] != null){
                LinkedList<MapEntry<K,V>> ll = hashTable[i];
                for(MapEntry<K,V> entry: ll)
                    sb.append(entry.toString() + " ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public clear(){
        hashTable = new LinkedList[capacity];
        size = 0;
    }

    public rehash(){
        LinkedList<MapEntry<K,V>>[] oldTable = hashTable;
        hashTable = new LinkedList[capacity * 2];
        for(int i=0; i< oldTable.length; i++){
            if(oldTable[i] != null){
                LinkedList<MapEntry<K,V>> ll = oldTable[i];
                for(MapEntry<K,V> entry: ll)
                    put(entry.getKey(), entry.getValue());
            }
        }
    }

    

    
}
