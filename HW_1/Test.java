import java.util.Scanner;

public class Test {
    
    public static void printMedia(Media[] list, int type) {
        // The values of type may be 0, 1, or 2 and correspond to all media, movies only, and shows only respectively
        // Print the title, genre, and rating of each media object in the list
        // If type is 0, print all media
        // If type is 1, print only movies
        // If type is 2, print only shows

        for (int i = 0; i < list.length; i++) {
            if (type == 0) {
                System.out.println(list[i]);
            } else if (type == 1) {
                if (list[i] instanceof Movie) {
                    System.out.println(list[i]);
                }
            } else if (type == 2) {
                if (list[i] instanceof Show) {
                    System.out.println(list[i]);
                }
            }
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

    public static void sortRating (Media[] list){
        // Sort the list of media objects by rating in ascending order
        // If two media objects have the same rating, sort them by title in ascending order

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - 1; j++) {
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
        
        Media[] Medialist = new Media[10];
        Medialist[0] = new Movie("The Matrix", "Sci-Fi", "R", 120);
        Medialist[1] = new Movie("The Matrix Reloaded", "Sci-Fi", "R", 120);
        Medialist[2] = new Movie("The Matrix Revolutions", "Sci-Fi", "R", 120);
        Medialist[3] = new Show("Game of Thrones", "Fantasy", "PG-13", 8);
        Medialist[4] = new Show("Breaking Bad", "Drama", "R", 5);
        Medialist[5] = new Show("The Big Bang Theory", "Comedy", "PG-13", 6);
        Medialist[6] = new Show("The Walking Dead", "Drama", "R", 10);
        Medialist[7] = new Show("The Big Bang Theory", "Comedy", "PG-13", 6);
        Medialist[8] = new Movie("The Matrix", "Sci-Fi", "R", 120);
        Medialist[9] = new Movie("The Matrix Reloaded", "Sci-Fi", "R", 120);


        boolean test = true;
        while (test){

            System.out.println("Enter a number to choose an option: ");
            System.out.println("1. Print all media");
            System.out.println("2. Print all movies");
            System.out.println("3. Print all shows");
            System.out.println("4. Find genre");
            System.out.println("5. Sort by rating");
            System.out.println("6. Exit");

            Scanner input = new Scanner(System.in);

            int choice = input.nextInt();

            if (choice == 1){
                printMedia(Medialist, 0);
            } else if (choice == 2){
                printMedia(Medialist, 1);
            } else if (choice == 3){
                printMedia(Medialist, 2);
            } else if (choice == 4){
                System.out.println("Enter a genre: ");
                Scanner input2 = new Scanner(System.in);
                String genre = input2.nextLine();
                System.out.println(findGenre(Medialist, genre));
            } else if (choice == 5){
                sortRating(Medialist);
                printMedia(Medialist, 0);
            } else if (choice == 6){
                test = false;
            } else {
                System.out.println("Invalid input");
            }
        }


}

}
