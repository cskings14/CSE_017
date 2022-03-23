//import scanner
import java.util.Scanner;
public class SeatReservation {
    
    
    public static void main(String[] args){
        Airplane myAirplane = new Airplane();
        System.out.println(myAirplane);
        
        boolean  checker = true;
        while(checker){
            System.out.println("Enter 1 to Reserve a seat\nEnter 2 to free a seat\nEnter 3 to quit.");
            Scanner s = new Scanner(System.in);
            int choice = s.nextInt();
            if (choice > 0 && choice < 4){
            if (choice == 1){
                System.out.println("Input Valid Seat Number To Reserve");
                String seatNumber = s.nextLine();
                try{
                    myAirplane.reserveSeat(seatNumber);
                }
                catch(InvalidSeatException e){
                    System.out.println(e.getMessage());
                }
            }

            if (choice == 2){
                System.out.println("Input Valid Seat Number To Free");
                String seatNumber = s.nextLine();
                try{
                    myAirplane.freeSeat(seatNumber);
                }
                catch(InvalidSeatException e){
                    System.out.println(e.getMessage());
                }
            }
            if (choice == 3){
                myAirplane.saveMap("seatMap.txt");
                checker = false;
            }
        }
    }
        
        }
        
        





    }


    

