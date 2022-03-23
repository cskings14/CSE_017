import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;  // Import the File class
public class Recurse {
    



    public static void findWord(String path, String word){
        File file = new File(path);

        if (file.exists()){
            if (file.isDirectory() && file.canRead()){
                File[] fileList = file.listFiles();

                for (int i = 0; i < fileList.length; i++){
                    findWord(fileList[i].getAbsolutePath(), word);
                }
        }
    }
        else if (file.isFile()){ // count number of times word is found in a file
            int count = 0; // count 

            try {
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()){
                    String line = sc.nextLine();
                    int index = line.indexOf(word, 0);
                    while (index != -1){
                        count++;
                        index = line.indexOf(word, index + 1);
                    }
                
                
                    sc.close();
                }
            }
            catch(FileNotFoundException e){
                System.out.println("File not found");
            }
            if (count != 0){
                System.out.println("word appears in " + file.getName() + " " + count + "times");
            }

    }
    else{
        System.out.println("File not found");
    }
    

}


public static long getSize(String path){
    File file = new File(path);
    long size = 0;
    
    if (file.isFile()){
        size = file.length();
    }
    else if (file.isDirectory()){
        File[] fileList = file.listFiles();
        if (fileList != null){
            for (int i = 0; i < fileList.length; i++){
                if (fileList[i].isFile()){
                    size += fileList[i].length();

                }
                else if (fileList[i].isDirectory()){
                    size += getSize(fileList[i].getAbsolutePath());
                }
                else{
                    System.out.println("File not found");
                }
            }
        }
    
}
return size;
}


public static void main(String[] args) {

    // String path = "C:\\Users\\spart\\OneDrive\\Desktop\\cse017\\test.txt";
    // String word = "Person";
    // findWord(path, word);
    
    // System.out.println(getSize(path));


    Scanner s = new Scanner(System.in);
    System.out.println("Enter a file path: ");
    String path1 = s.nextLine();
    System.out.println("Enter a word: ");
    String word1 = s.nextLine();
    findWord(path1, word1);
    System.out.println(getSize(path1));
    long size = getSize(path1);


    if (size > 1_000_000_000){
        size = size / 1_000_000_000;
        System.out.println("Size: " + size + "GB");
    }
    else if (size > 1_000_000){
        size = size / 1_000_000;
        System.out.println("Size: " + size + "MB");
    }
    else if (size > 1_000){
        size = size / 1_000;
        System.out.println("Size: " + size + "KB");
    }
    else{
        System.out.println("Size: " + size + "B");
    }

    System.out.println();
}

    
}
