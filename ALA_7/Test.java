import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {


    public static void main(String[] args){
        ArrayList<String> animalAL = new ArrayList<String>();
        LinkedList<String> animalLL = new LinkedList<String>();
        readFile(animalAl, animalLL, "animals.txt");
        testContains(anamalAL, animalLL);
        testAdd(animalAL, animalLL);
        testRemove(animalAL, animalLL);
        

    }

    public static void readFile(ArrayList<String> al, LinkedList<String> ll, String fileName){
        try{
            Scanner input = new Scanner(new File(fileName));
            while(input.hasNextLine()){
                String name = input.nextLine();
                al.add(name);
                ll.add(name);
            }
            input.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
    }

    public static void testContains(ArrayList<String> al, LinkedList<String> ll){
        int totalIterAL = 0, totalIterLL = 0;
        System.out.printf("%-30s\t%-15s\t%-15s\n", "animal name", "Iterations(AL)", "Iterations(LL)");
       for (int i = 0; i < 20; i++) {
            int randomIndex = (int) (Math.random() * al.size());
            String randomName = al.get(randomIndex);
            int iterAl = al.contains(randomName);
            int iterLL = ll.contains(randomName);
            System.out.printf("%-30s\t%-15d\t%-15d\n", iterAl, iterLL);
            totalIterAL += iterAl;
            totalIterLL += iterLL;
       }
       System.out.printf("%-30s\t%-15d\t%-15d\n", "average", totalIterAL/20, totalIterLL/20);

    }
}
