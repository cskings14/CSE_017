//import arraylist from java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;

public class TestComp {
    

    public static void main(String[] args) {
        ArrayList<Pair<String, String>> states = new ArrayList<>(50);

        File stateFile = new File("states.txt");


        try{
            Scanner s = new Scanner(stateFile);
            while(s.hasNextLine()){
                String line = s.nextLine();
                String[] tokens = line.split("\\|");

                Pair<String, String> p = new Pair<>(tokens[0], tokens[1]);

                states.add(p);

            }
            s.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
        // printList(states);
        //new Scanner(System.in).nextInt(); // anonymous reference
        // states.sort(new ComparatorByFirst<String, String>());
        // printList(states);
        // states.sort(new ComparatorBySecond<String, String>());
        // printList(states);


        
        ArrayList<Pair<String, String>> trees = new ArrayList<>(50);

        File treeFile = new File("trees.txt");
        
        try{
            Scanner s = new Scanner(treeFile);
            while(s.hasNextLine()){
                String line = s.nextLine();
                String[] tokens = line.split("\\|");

                Pair<String, String> p = new Pair<>(tokens[0], tokens[1]);

                trees.add(p);

            }
            s.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
        // printList(trees);
        //new Scanner(System.in).nextInt(); // anonymous reference
        // trees.sort(new ComparatorByFirst<String, String>());
        // printList(trees);
        // trees.sort(new ComparatorBySecond<String, String>());
        // printList(trees);



        Scanner input = new Scanner(System.in);

        int operation = 0;
        do {
            printMenu();
            operation = Integer.parseInt(input.nextLine());
            switch (operation){

                case 1: // view states
                    printList(states);
                    break;
                case 2: // search for a state
                    System.out.println("Enter a state: ");
                    String state = input.nextLine();
                    Pair<String, String> p = new Pair<>(state, "");
                    int index = states.indexOf(p);
                    if (index == -1){
                        System.out.println("State not found");
                    } else {
                        System.out.println("State found at index " + index);
                    }
                    break;
                case 3: // sort states by name
                    states.sort(new ComparatorByFirst<String, String>());
                    printList(states);
                    break;
                case 4: // sort states by captitol
                    states.sort(new ComparatorBySecond<String, String>());
                    printList(states);
                    break;
                case 5: // view trees\
                    printList(trees);
                    break;
                case 6: // search for a tree
                    System.out.println("Enter a tree: ");
                    String tree = input.nextLine();
                    Pair<String, String> p2 = new Pair<>(tree, "");
                    int index2 = trees.indexOf(p2);
                    if (index2 == -1){
                        System.out.println("Tree not found");
                    } else {
                        System.out.println("Tree found at index " + index2);
                    }
                    break;
                case 7: // sort trees by name
                    trees.sort(new ComparatorByFirst<String, String>());
                    printList(trees);
                    break;
                case 8: // sort trees by height
                    trees.sort(new ComparatorBySecond<String, String>());
                    printList(trees);
                    break;
                

            } 
            





        }
        while (operation != 9);
    


    }

    public static void printMenu(){
        System.out.println("Select an operation:");
        System.out.println("1: View the list of states");
        System.out.println("2: Search for a state");
        System.out.println("3: Sort states by name");
        System.out.println("4: Sort states by capital");
        System.out.println("5: View the list of trees");
        System.out.println("6: Search for a tree");
        System.out.println("7: Sort trees by name");
        System.out.println("8: Sort trees by height");
        System.out.println("9: Exit");

    }


    public static <E1, E2> int search(ArrayList<Pair<E1, E2>> list, E1 key) {
        // binary search
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getE1().equals(key)) {
                return i;
            }
        }
        return -1;
    }

// e1 just makes it a generic type. It is not the return type
    public static <E1, E2> void printList(ArrayList<Pair<E1, E2>> list) {
        for (Pair<E1, E2> temp : list) {
            System.out.println(temp);
        }
    }

}
