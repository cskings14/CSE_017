import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Airplane {
    

    private char[][] seatMap;

    public Airplane() {
        int rows = 9;
        int columns = 8;
        seatMap = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seatMap[i][j] = '.';
            }
        }
    }


    public Airplane(String filename){
        int rows = 9;
        int columns = 8;
        seatMap = new char[rows][columns];
    }

    public void readMap(String filename) {
        // read the seat map from the file 
        try{
        File file = new File(filename);
        Scanner readFile = new Scanner(file);

        for (int i = 0; i < seatMap.length; i++) {
            for (int j = 0; j < seatMap[i].length; j++) {
                seatMap[i][j] = readFile.next().charAt(0);
            }
        }
        readFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }


    }

    private boolean checkSeat(String seatNumber) throws InvalidSeatException {
        // check if the seat is available
       // throws an exception if the seat is not available

       if (seatNumber.matches("[1-9][A-H]")){
           return true;
       }
       else{
           throw new InvalidSeatException("Invalid seat #");
       }
        
    }

    public boolean reserveSeat(String seatNumber) throws InvalidSeatException{
        //throwsInvalidSeatException if the seat is not available
        //returns true if the seat is reserved
        //returns false if the seat is not available
        char rowNum = seatNumber.charAt(0);
        char columnNum = seatNumber.charAt(1);
        int row = rowNum - '1';
        int col = columnNum - 'A';

        if (checkSeat(seatNumber)){
            if (seatMap[row][col] == '.'){
                seatMap[row][col] = 'X';
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public boolean freeSeat(String seatNumber) throws InvalidSeatException{
        //throwsInvalidSeatException if the seat is not available
        //returns true if the seat is reserved
        //returns false if the seat is not available
        char rowNum = seatNumber.charAt(0);
        char columnNum = seatNumber.charAt(1);
        int row = rowNum - '1';
        int col = columnNum - 'A';

        if (checkSeat(seatNumber)){
            if (seatMap[row][col] == 'X'){
                seatMap[row][col] = '.';
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public void saveMap(String filename) {
        // save the seat map to the file
        File file = new File(filename);
        try{
            PrintWriter writeFile = new PrintWriter(file);
            for (int i = 0; i < seatMap.length; i++) {
                for (int j = 0; j < seatMap[i].length; j++) {
                    writeFile.print(seatMap[i][j]);
                }
                writeFile.println();
            }
            writeFile.close();

        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public String toString() {
        // return a string representation of the seat map
        String map = "A\tB\tC\tD\tE\tF\tG\tH\n";
        
        for (int i = 0; i < seatMap.length; i++) {
            for (int j = 0; j < seatMap[i].length; j++) {
                map += seatMap[i][j] +"\t";
            }
            map += "\n";
        }
        return map;
    }

    public static void main(String[] args){

        Airplane a = new Airplane();

        System.out.println(a);

    }
}
