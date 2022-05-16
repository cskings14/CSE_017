public class Test {


    public static void main(String[] args) {
        // TODO Auto-generated method stub



        ArrayList<Integer> randomList = new ArrayList<Integer>(10_000);

        // In a test program, create an array list of 10,000 integers and fill it with random numbers between 1 and 9,999 inclusive. Name the array list randomList.

        for (int i = 0; i < 10_000; i++) {
            randomList.add((int) (Math.random() * 10_000) + 1);
        }

        ArrayList<Integer> sortedList = new ArrayList<Integer>(10_000);
        ArrayList<Integer> reversedList = new ArrayList<Integer>(10_000);

        sortedList = randomList.clone();
        reversedList = randomList.clone();

        Collections.sort(sortedList);
        Collections.reverse(reversedList);

        
        
        

        selectionSort(randomList);
        System.out.println("Selection Sort" + "\n" + " Random Iterations: " + itertaions[0]);
        iterations[0] = 0;

        selectionSort(sortedList);
        System.out.println("Selection Sort" + "\n" + " Sorted Iterations: " + itertaions[0]);
        iterations[0] = 0;

        selectionSort(reversedList);
        System.out.println("Selection Sort" + "\n" + " Reversed Iterations: " + itertaions[0]);
        iterations[0] = 0;


        collections.shuffle(randomList);
        collections.sort(sortedList);
        collections.reverse(reversedList);

        insertionSort(randomList);
        System.out.println("Insertion Sort" + "\n" + " Random Iterations: " + itertaions[1]);
        iterations[1] = 0;

        insertionSort(sortedList);
        System.out.println("Insertion Sort" + "\n" + " Sorted Iterations: " + itertaions[1]);
        iterations[1] = 0;

        insertionSort(reversedList);
        System.out.println("Insertion Sort" + "\n" + " Reversed Iterations: " + itertaions[1]);
        iterations[1] = 0;


        collections.shuffle(randomList);
        collections.sort(sortedList);
        collections.reverse(reversedList);

        bubbleSort(randomList);
        System.out.println("Bubble Sort" + "\n" + " Random Iterations: " + itertaions[2]);
        iterations[2] = 0;

        bubbleSort(sortedList);
        System.out.println("Bubble Sort" + "\n" + " Sorted Iterations: " + itertaions[2]);
        iterations[2] = 0;

        bubbleSort(reversedList);
        System.out.println("Bubble Sort" + "\n" + " Reversed Iterations: " + itertaions[2]);
        iterations[2] = 0;

        

        



    }

    
}
