public class DoublyLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public DoublyLinkedList(int capacity) {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean add(E item) {
        return add(size, item);
    }

    public boolean add(int index, E item) {
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        Node<E> newNode = new Node<E>(item);
        if (index == 0) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next.prev = newNode;
            newNode.prev = current;
            current.next = newNode;
        }
        size++;
        return true;
    }

    public E get(int index) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;


    
}

    public E set(int index, E item) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldItem = current.data;
        current.data = item;
        return oldItem;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean remove(Object o) {
        E item = (E) o;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public E remove(int index) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldItem = current.data;
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return oldItem;
    }

    public ListIterator<E> listIterator() {
        return new DoublyLinkedListIterator();
    }

    public ListIterator<E> listIterator(int index) {
        return new DoublyLinkedListIterator(index);
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException();

}



}
