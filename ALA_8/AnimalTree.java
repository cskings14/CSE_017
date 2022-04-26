import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class AnimalTree {



    public static void main(String[] args) {
        
        BST<String> animalBST = new BST<>();
        Heap<String> animalHeap = new Heap<>();
        ArrayList<String> animaAL = new ArrayList<>();

        readFile(animalAL, "animals.txt");

        testAdd(animalBST, animalHeap, animalAL);
        testContains(animalBST, animalHeap, animalAL);
        testRemove(animalBST, animalHeap, animalAL);

        System.out.println("BST Height: " + animalBST.height());
        System.out.println("Heap Height: " + animalHeap.height());

        System.out.println("BST isBalanced? " + animalBST.isBalanced());
        System.out.println("Heap isBalanced? " + animalHeap.isBalanced());

        animalBST.clear();
        animalHeap.clear();
        java.util.Collections.sort(animalAL);

        for (int i = 0; i < animalAL.size(); i++) {
            String name = animalAL.get(i);
            bstIterations = animalBST.add(name);
            heapIterations = animalHeap.add(name);
            
        }

        System.out.println("BST Height: " + animalBST.height());
        System.out.println("Heap Height: " + animalHeap.height());

        System.out.println("BST isBalanced? " + animalBST.isBalanced());
        System.out.println("Heap isBalanced? " + animalHeap.isBalanced());


    }

    public static void readFile(ArrayList<String> al, String fileName) {
        try {
            Scanner in = new Scanner(new File(fileName));
            while (in.hasNext()) {
                al.add(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
    }
    
    public static void testAdd(BST<String> bst, Heap<String> heap, ArrayList<String> al) {
        int totalBST = 0, totalHeap = 0;
        int count = 0;
        int bstIterations;
        int heapIterations;
        System.out.println("Test Add");
        System.out.printf("%-30s\t%-10s\t%-10s\n", "animal name", "BST", "Heap");
        for (int i = 0; i < al.size(); i++) {
            String name = al.get(i);
            bstIterations = bst.add(name);
            heapIterations = heap.add(name);
            if (i % 24 == 0){
                count++;
                System.out.printf("%-30s\t%-10d\t%-10d\n", name, bstIterations, heapIterations);
                totalBST += bstIterations;
                totalHeap += heapIterations;

            }
        }
        System.out.printf("%-30s\t%-10d\t%-10d\n", totalBST/count, totalHeap/count);
    }



    public static void testContains(BST<String> bst, Heap<String> heap, ArrayList<String> al) {
        int totalBST = 0, totalHeap = 0;
        
        int bstIterations;
        int heapIterations;
        System.out.println("Test Contains");
        System.out.printf("%-30s\t%-10s\t%-10s\n", "animal name", "BST", "Heap");
        for (int i = 0; i < 20; i++) {
            int index = (int) (Math.random() * al.size());
            String name = al.get(i);
            bstIterations = bst.contains(name);
            heapIterations = heap.contains(name);
            
                
            System.out.printf("%-30s\t%-10d\t%-10d\n", name, bstIterations, heapIterations);
            totalBST += bstIterations;
            totalHeap += heapIterations;

            
        }
        System.out.printf("%-30s\t%-10d\t%-10d\n", totalBST/20, totalHeap/20);
    }


    public static void testRemove(BST<String> bst, Heap<String> heap, ArrayList<String> al) {
        int totalBST = 0, totalHeap = 0;
        
        int bstIterations;
        int heapIterations;
        System.out.println("Test Remove");
        System.out.printf("%-30s\t%-10s\t%-10s\n", "animal name", "BST", "Heap");

        for (int i = 0; i < 20; i++) {
            int index = (int) (Math.random() * al.size());
            String name = al.get(i);
            bstIterations = bst.remove(name);
            heapIterations = heap.remove(name);
            
                
            System.out.printf("%-30s\t%-10d\t%-10d\n", name, bstIterations, heapIterations);
            totalBST += bstIterations;
            totalHeap += heapIterations;

            
        }
        System.out.printf("%-30s\t%-10d\t%-10d\n", totalBST/20, totalHeap/20);
    }
}
