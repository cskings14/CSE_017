// import comparable
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test {
    
    public static void main(String[] args){

    LibraryManager[] library = new LibraryManager[10];

    File file = new File("title.txt");

    try {
        Scanner sc = new Scanner(file);
        int count = 0;
        while (sc.hasNext()) {
            // if (count % 5 == 0) {
            //     try{
            //         int num = Integer.parseInt(sc.nextLine());
            //         int case1 = sc.nextInt();
            //     } catch (NumberFormatException e){
            //         System.out.println("Not a number");
            //         String case1 = sc.nextLine();
            //     }
            // }
            // else{
            // String read = sc.nextLine();
            
            // }
            // count++;
            String cn = sc.nextLine();
            String title = sc.nextLine();
            String publisher = sc.nextLine();
            int year = sc.nextInt();
            int copies = sc.nextInt();
            if (cn.substring(0,1).equals("P")){
                int month = sc.nextInt();
                int issueNumber = sc.nextInt();
                Library[count] = new Periodical(cn, title, publisher, year, copies, month, issueNumber);
            }
            else{
                String author = sc.nextLine();
                int ibsn = sc.nextInt();
                Library[count] = new Book(cn, title, publisher, year, copies, author, ibsn);
            }
            count++;
            
        }
        sc.close();

    } catch (FileNotFoundException e) {
        System.out.println("File not found");
        System.exit(0);
    }

    for (int i = 0; i < library.length; i++){
        System.out.println(library[i].toString());
    }

}

}
