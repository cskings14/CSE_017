public abstract class LibraryManager implements Comparable<LibraryManager>, Restorable {
    


    private String callNumber;

    private String title;

    private String publisher;

    private int year;

    private int copies;



    public LibraryManager(String callNumber, String title, String publisher, int year, int copies) {
        this.callNumber = callNumber;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.copies = copies;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getCopies() {
        return copies;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public boolean isRestorable() {

        if (this.getYear() - 20 > 2002) {
            return true;
        } 
        return false;
    }

    public String toString() {
        return "Call Number: " + this.getCallNumber() + "\nTitle: " + this.getTitle() + "\nPublisher: " + this.getPublisher() + "\nYear: " + this.getYear() + "\nCopies: " + this.getCopies();
    }


}
