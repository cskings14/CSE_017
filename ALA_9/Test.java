import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Test {
    public static void main(String[] args){
        HashMap<String, String> hm = new HashMap<String, String>(50000);
        BST<String> bst = new BST<>();
        LinkedList<String> list = new LinkedList<>();
        ArrayList<String> words = new ArrayList<>();

        File f = new File("dictionary.txt");

        try{

            Scanner sc = new Scanner(f);

            while(sc.hasNext()){
                String read = sc.nextLine();
                String[] split = read.split("\\|");
                words.add(split[0]);
                hm.put(split[0], split[1]);


            }
            sc.close();


        } catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
        // System.out.println(words.toString());

        java.util.Collections.shuffle(words);
        for (String temp: words){
            bst.insert(temp);
            list.insert(temp);
        }
        
        int totalBST = 0;
        int totalLL = 0;
        int totalHashMap = 0;

        for (int i = 0; i < 1000; i++){
            int index = (int)(MAth.random() * words.size());
            String searchWord = words.get(index);

            hashMap.get(searchWord);
            int hmITer = hashMap.iterations;
            llIter = list.contains(searchWord);
            bstIter = bst.contains(searchWord);


            totalBST += bst.contains(searchWord);
            totalLL += list.contains(searchWord);
            totalHashMap += hmIter;






            if (i % 50 == 0){
                System.out.printf("%-20s\t%-10d\t%-10d\t%-10d\n", searchWord, llIter, bstItter, hmITer );
            }
            // calculate the average iterationss for each structure 
            
    }

    System.out.printf("%-20s\t%-10d\t%-10d\t%-10d\n", "Average", totalLL/1000, totalBST/1000, totalHashMap/1000);
        System.out.println("Maximum number of collisions" + hashMap.collisions());


    



    }
}
