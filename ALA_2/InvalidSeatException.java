public class InvalidSeatException extends Exception {
    public InvalidSeatException() {
        super("Invalid seat #");
    }
    


    public InvalidSeatException(String message) {
        super(message);
    }



}
