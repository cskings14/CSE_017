import java.util.ArrayList;
// import collections 
import java.util.Collections;

public class Test {
    

    public static final int SIZE = 10_000;

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            list.add((int)(Math.random() * (SIZE-1))+1);


        }

        Sort.selectionSort(list);
        Collections.shuffle(list);

        Sort.insertionSort(list);
        Collections.shuffle(list);

        Sort.bubbleSort(list);
        Collections.shuffle(list);

        Sort.mergeSort(list);
        Collections.shuffle(list);

        Sort.quickSort(list);
        Collections.shuffle(list);

        Sort.heapSort(list);
        Collections.shuffle(list);

        System.out.println("data set size: " + SIZE);
        System.out.println("selection sort: " + Sort.itertaions[0]);
        System.out.println("insertion sort: " + Sort.itertaions[1]);
        System.out.println("bubble sort: " + Sort.itertaions[2]);
        System.out.println("merge sort: " + Sort.itertaions[3]);
        System.out.println("quick sort: " + Sort.itertaions[4]);
        System.out.println("heap sort: " + Sort.itertaions[5]);


    

    }
}
