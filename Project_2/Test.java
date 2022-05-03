// import fle
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Test {
   
    
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<String>();
        DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
        LinkedList<String> ll = new LinkedList<String>();

        readFromFile(list, "countries.txt");
        readFromFile(dll, "countries.txt");
        readFromFile(ll, "countries.txt");

        list.printListForward();
        dll.printListForward();
        ll.printListForward();

        list.printListBackward();
        dll.printListBackward();
        ll.printListBackward();

        

        


    }


    public static void readFromFile(List<String> list, String filename){
        File file = new File(filename);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line);
                dll.add(line);
                ll.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
    }



    public static <E> void printListForward(List<E> list){
        //use listIterator to print list forwards
        ListIterator<E> it = list.listIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

    public static <E> void printListBackwards(List<E> list){
        //use listIterator to print list backwards
        ListIterator<E> it = list.listIterator(list.size());
        while(it.hasPrevious()){
            System.out.println(it.previous());
        }
    }



}




