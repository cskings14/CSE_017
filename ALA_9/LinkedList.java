import java.lang.Exception;
import java.lang.Iterable;
public class LinkedList<E> {
    
 // Data members
 private Node head, tail;
 int size;
  // Inner class Node
 private class Node{
 E value;
 Node next;
 Node(E initialValue){
 value = initialValue; next = null;
 }
 }
  // Constructor
 public LinkedList() {
 head = tail = null;
 size = 0;
 }


// Adding an item to the list
public boolean addFirst(E item) {
Node newNode = new Node(item);
if(head == null) { head = tail = newNode; }
else { newNode.next = head;
 head = newNode;
}
size++; return true;
}
public boolean addLast(E item) {
Node newNode = new Node(item);
if(head == null) { head = tail = newNode; }
else { tail.next = newNode; tail = newNode; }
size++; return true;
}
public boolean add(E item) {
return addFirst(item);
}

public E getFirst() {
    if (head == null)
    throw new NoSuchElementException();
    return head.value;
    }
    public E getLast() {
    if (head == null)
    throw new NoSuchElementException();
    return tail.value;
    }

    public boolean removeFirst() {
        if (head == null) throw new NoSuchElementException();
        head = head.next;
        if(head == null) tail=null;
        size--; return true;
        }
        public boolean removeLast() {
        if (head == null) throw new NoSuchElementException();
        if(size == 1) return removeFirst();
        Node current = head;
        Node previous = null;
        while(current.next != null) {
        previous = current; current = current.next;
        }
        previous.next = null; tail = previous;
        size--; return true;
        }



        public String toString() {
            String output = "[";
            Node node = head;
            while(node != null) {
            output += node.value + " ";
            node = node.next;
            }
            output += "]";
            return output;
            }
            // clear, check if empty, and size of the list
            public void clear() { head = tail = null; size = 0; }
            public boolean isEmpty() { return (size == 0); }
            public int size() { return size; }

        // Implementing an iterator for the list
public Iterator<E> iterator(){
    return new LinkedListIterator();
   }

   private class LinkedListIterator implements Iterator<E>{
   private Node current = head;
   public boolean hasNext() {
   return (current != null);
   }
   public E next() {
   if(current == null)
    throw new NoSuchElementException();
   E value = current.value;
   current = current.next; return value;
   }
   }

   public int contains(Object o){
    int iterations = 0;
    Iterator<E> iter = iterator();
    while (iter.hasNext()) {
        if (iter.next().equals(o)){
            return iterations;
        }
}
return iterations;
}



    public int remove(Object o){
        int iterations = 0;
        Node current = head;
        Node previous = null;

        while(current != null) {
            if(current.value.equals(o)){
                if(previous == null){
                    head = head.next;
                }
                else{
                    previous.next = current.next;
                }
                if(current == tail){
                    tail = previous;
                }
                size--;
                return iterations;
            }
            previous = current;
            current = current.next;
            iterations++;
        }
        return iterations;

    }

    public int add(int index, E item){
        if (index > size || index < 0)
        throw new IndexOutOfBoundsException();
        if (index == 0) 
         addFirst(item);

        if (index == size) 
         addLast(item);

        int count = 0;
        Node current = head;
        Node previous = null;

        while(count < index){
            count++;
            previous = current;
            current = current.next;

        }
        Node newNode = new Node(item);
        previous.next = newNode;
        newNode.next = current;
        size++;
        return count;


    }
 



}
