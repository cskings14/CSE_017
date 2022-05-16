public class TreeMap<K, V> {

    private TreeNode root;
    private int size;
    private Comparator<K> comp;


    public treeMap(Comparator<K> c) {
        this.comp = c;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public V get(K key){
        TreeNode node = root;
        while (node != null) {
            int cmp = comp.compare(key, node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;

    }

    public boolean add(K key, V val) {
        if (root == null) {
            root = new TreeNode(key, val);
            size++;
            return true;
        }
        TreeNode node = root;
        while (node != null) {
            int cmp = comp.compare(key, node.key);
            if (cmp < 0) {
                if (node.left == null) {
                    node.left = new TreeNode(key, val);
                    size++;
                    return true;
                }
                node = node.left;
            } else if (cmp > 0) {
                if (node.right == null) {
                    node.right = new TreeNode(key, val);
                    size++;
                    return true;
                }
                node = node.right;
            } else {
                return false;
            }
        }
    }

    public boolean remove(K key) {
        TreeNode node = root;
        TreeNode parent = null;
        while (node != null) {
            int cmp = comp.compare(key, node.key);
            if (cmp < 0) {
                parent = node;
                node = node.left;
            } else if (cmp > 0) {
                parent = node;
                node = node.right;
            } else {
                if (node.left == null) {
                    changeChild(parent, node, node.right);
                } else if (node.right == null) {
                    changeChild(parent, node, node.left);
                } else {
                    TreeNode successor = node.right;
                    while (successor.left != null) {
                        successor = successor.left;
                    }
                    node.key = successor.key;
                    node.value = successor.value;
                    changeChild(parent, successor, successor.right);
                }
            }
        }
    }

    public void inOrder() {
        inOrder(root);

    }

    public void preorder(){
        preorder(root);
    }

    public void postorder(){
        postorder(root);
    }

    





    
}
