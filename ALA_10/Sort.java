import java.util.ArrayList;
public class Sort {
    


    public static int[] itertaions = new int[6];
    // iterations[0] = is iterations for selection sort
    // iterations[1] = is iterations for insertion sort
    // iterations[2] = is iterations for bubble sort
    // iterations[3] = is iterations for merge sort
    // iterations[4] = is iterations for quick sort
    // iterations[5] = is iterations for heap sort


    
    public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
        itertaions[0] = 0;
        int minIndex;
        E min;

        for (int i = 0; i < list.size()-1; i++){
            itertaions[0]++;
            minIndex = i;
            min = list.get(i);
            for (int j = i + 1; j < list.size(); j++){
                itertaions[0]++;
                if (list.get(j).compareTo(min) < 0){
                    minIndex = j;
                    min = list.get(j);
                }
            }
            if (minIndex != i){
                E temp = list.get(i);
                list.set(i, min);
                list.set(minIndex, temp);
            }
        }
    }

    public static <E extends Comparable<E>> void insertionSort(ArrayList<E> list){
        itertaions[1] = 0;
        E temp;
        for (int i = 1; i < list.size(); i++){
            itertaions[1]++;
            for (int j = i; j > 0; j--){
                itertaions[1]++;
                if (list.get(j).compareTo(list.get(j-1)) < 0){
                    temp = list.get(j);
                    list.set(j, list.get(j-1));
                    list.set(j-1, temp);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list){
        itertaions[2] = 0;
        E temp;
        for (int i = 0; i < list.size()-1; i++){
            itertaions[2]++;
            for (int j = 0; j < list.size()-1-i; j++){
                itertaions[2]++;
                if (list.get(j).compareTo(list.get(j+1)) > 0){
                    temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list){
        itertaions[3] = 0;
        ArrayList<E> temp = new ArrayList<>();
        mergeSort(list, temp, 0, list.size()-1);
    }

    private static <E extends Comparable<E>> void mergeSort(ArrayList<E> list, ArrayList<E> temp, int left, int right){
        itertaions[3]++;
        if (left < right){
            int middle = (left + right) / 2;
            mergeSort(list, temp, left, middle);
            mergeSort(list, temp, middle+1, right);
            merge(list, temp, left, middle, right);
        }
    }

    private static <E extends Comparable<E>> void merge(ArrayList<E> list, ArrayList<E> temp, int left, int middle, int right){
        itertaions[3]++;
        int i = left;
        int j = middle + 1;
        int k = left;
        while (i <= middle && j <= right){
            itertaions[3]++;
            if (list.get(i).compareTo(list.get(j)) < 0){
                temp.set(k, list.get(i));
                i++;
            }
            else{
                temp.set(k, list.get(j));
                j++;
            }
            k++;
        }
        while (i <= middle){
            itertaions[3]++;
            temp.set(k, list.get(i));
            i++;
            k++;
        }
        while (j <= right){
            itertaions[3]++;
            temp.set(k, list.get(j));
            j++;
            k++;
        }
        for (int l = left; l <= right; l++){
            itertaions[3]++;
            list.set(l, temp.get(l));
        }
    }

    public static <E extends Comparable<E>> void quickSort(ArrayList<E> list){
        itertaions[4] = 0;
        quickSort(list, 0, list.size()-1);
    }

    private static <E extends Comparable<E>> void quickSort(ArrayList<E> list, int left, int right){
        itertaions[4]++;
        if (left < right){
            int middle = partition(list, left, right);
            quickSort(list, left, middle-1);
            quickSort(list, middle+1, right);
        }
    }

    private static <E extends Comparable<E>> int partition(ArrayList<E> list, int left, int right){
        itertaions[4]++;
        E pivot = list.get(right);
        int i = left;
        for (int j = left; j < right; j++){
            itertaions[4]++;
            if (list.get(j).compareTo(pivot) < 0){
                E temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
            }
        }
        E temp = list.get(i);
        list.set(i, list.get(right));
        list.set(right, temp);
        return i;
    }

    public static <E extends Comparable<E>> void heapSort(ArrayList<E> list){
        itertaions[5] = 0;
        heapSort(list, list.size());
    }

    private static <E extends Comparable<E>> void heapSort(ArrayList<E> list, int n){
        itertaions[5]++;
        for (int i = n/2-1; i >= 0; i--){
            itertaions[5]++;
            heapify(list, n, i);
        }
        for (int i = n-1; i >= 0; i--){
            itertaions[5]++;
            E temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);
            heapify(list, i, 0);
        }
    }
    // make method to heapify

    private static <E extends Comparable<E>> void heapify(ArrayList<E> list, int n, int i){
        itertaions[5]++;
        int largest = i;

        int left = 2*i+1;
        int right = 2*i+2;

        if (left < n && list.get(left).compareTo(list.get(largest)) > 0){
            largest = left;
        }

        if (right < n && list.get(right).compareTo(list.get(largest)) > 0){
            largest = right;
        }

        if (largest != i){
            E temp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, temp);
            heapify(list, n, largest);
        }

        


    }
    
       

}
