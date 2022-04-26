import java.util.Scanner;
// import exceptions.InvalidInputException;
import java.io.FileReader;
import java.io.FileNotFoundException;
// import file
import java.io.File;
import java.util.Arrays;






public class Test {
    
    public static void printMedia(Media[] list, int count) {
        // print count number of media objects

        for (int i = 0; i < count; i++) {
            System.out.println(list[i]);
        }



    }

    public static int findGenre(Media[] list, String genre) {
        // Return the number of media objects in the list that have the given genre
        // If no media object in the list has the given genre, return 0
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].getGenre().equals(genre)) {
                count++;
            }
        }
        return count;
    }

    public static int findMedia(Media[] list, String title, int count) {
        // Return the index of the media object in the list that has the given title
        // If no media object in the list has the given title, return -1
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (list[i].getTitle().equals(title)) {
                index = i;
            }
        }
        return index;
    }

    public boolean checkRating(String rating, String type) {
        

        try{
        if (type.equals("movie")) {
            if (rating.equals("G") || rating.equals("PG") || rating.equals("PG-13") || rating.equals("R") || rating.equals("NC-17")) {
                return true;
            }
        } else if (type.equals("show")) {
            if (rating.equals("TV-Y") || rating.equals("TV-Y7") || rating.equals("TV-G") || rating.equals("TV-PG") || rating.equals("TV-14") || rating.equals("TV-MA")) {
                return true;
            }
        }


    } catch (InvalidRatingException e) {
        System.out.println("Invalid Rating");
        return false;
    }
        return false;

    }

    public static void sortRating (Media[] list, int count){
        // Sort the list of media objects by rating in ascending order
        // If two media objects have the same rating, sort them by title in ascending order

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - 1; j++) {
                if (list[j].ratingNumber() > list[j + 1].ratingNumber()) {
                    Media temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                } else if (list[j].ratingNumber() == list[j + 1].ratingNumber()) {
                    if (list[j].getTitle().compareTo(list[j + 1].getTitle()) > 0) {
                        Media temp = list[j];
                        list[j] = list[j + 1];
                        list[j + 1] = temp;
                    }
                }
            }
        }
        
       




    }


    public static void main(String[] args) {
        
        Media[] mediaList = new Media[50];

        File file = new File("media.txt");
        try {
            int i = 0;
            Scanner s = new Scanner(file);
            while(s.hasNextLine()){
                
                String line = s.nextLine();
                String[] tokens = line.split("\\|");
                tokens[tokens.length-1] = (int)(tokens[tokens.length-1]);
                
                
                if (tokens[0].equals("movie")) {
                    mediaList[i] = new Movie(tokens[1], tokens[2], tokens[3], tokens[4]);
                } else if (tokens[0].equals("show")) {
                    mediaList[i] = new Show(tokens[1], tokens[2], tokens[3], tokens[4]);
                }
            }
            i++;
            s.close();
        }
        catch(Exception e){
            System.out.println("File not found");
        }


        boolean test = true;
        while (test){

            System.out.println("Enter a number to choose an option: ");
            System.out.println("1. View the list of media");
            System.out.println("2. search media by title");
            System.out.println("3. Add a new mida");
            System.out.println("4. remove an existing media");
            System.out.println("5. Sort the list of media by genre");
            System.out.println("6. Exit");

            Scanner input = new Scanner(System.in);

            int choice = input.nextInt();

            if (choice == 1){
                printMedia(Medialist);
            }
            else if (choice == 2){
                System.out.println("Enter the title of the media you want to search for: ");
                String title = input.next();
                
                int index = findMedia(mediaList, title, mediaList.length);
                if (index == -1){
                    System.out.println("Media not found");
                }
                else{
                    System.out.println(mediaList[index]);
                }
            }
            else if (choice == 3){
                System.out.println("Enter the type of media you want to add: ");
                System.out.println("1. Movie");
                System.out.println("2. Show");
                int type = input.nextInt();

                if (type == 1){
                    if (findMedia(mediaList, title, mediaList.length) == -1){
                        System.out.println("Enter the title of the movie: ");
                        String title = input.next();
                        System.out.println("Enter the genre of the movie: ");
                        String genre = input.next();
                        System.out.println("Enter the rating of the movie: ");
                        String rating = input.next();
                        System.out.println("Enter the length of the movie: ");
                        int duration = input.nextInt();
                        mediaList[medialist.length] = new Movie(title, genre, rating, duration);
                    }
                    else {
                        System.out.println("Movie already exists");
                        
                    }

                }
                else if (type == 2){
                    if (findMedia(mediaList, title, mediaList.length) == -1){
                        System.out.println("Enter the title of the show: ");
                        String title = input.next();
                        System.out.println("Enter the genre of the show: ");
                        String genre = input.next();
                        System.out.println("Enter the rating of the show: ");
                        String rating = input.next();
                        System.out.println("Enter the number of seasons in the show: ");
                        int seasons = input.nextInt();
                        mediaList[medialist.length] = new Show(title, genre, rating, seasons);
                    }
                    else {
                        System.out.println("Show already exists");
                        
                    }

                }
                else{
                    System.out.println("Invalid input");
                }

                
               
            }
            else if (choice == 4){
                System.out.println("Enter the title of the media you want to remove: ");
                String title = input.next();
                int index = findMedia(mediaList, title, mediaList.length);
                if (index == -1){
                    System.out.println("Media not found");
                }
                else{
                    mediaList[index] = null;
                }
            }
            else if (choice == 5){
                sortRating(mediaList, mediaList.length);
                printMedia(mediaList, mediaList.length);
            }
            else if (choice == 6){
                test = false;
            }
            else{
                System.out.println("Invalid input");
            }
            
            
               
        }



}

}
