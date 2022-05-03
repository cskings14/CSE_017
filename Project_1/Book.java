public class Book extends LibraryManager {


    private String author;

    private int ibsn;


    public Book(String callNumber, String title, String publisher, int year, int copies, String author, int ibsn) {
        super(callNumber, title, publisher, year, copies);
        this.author = author;
        this.ibsn = ibsn;
    }

    public String getAuthor() {
        return author;
    }

    public int getIbsn() {
        return ibsn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIbsn(int ibsn) {
        this.ibsn = ibsn;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAuthor: " + author + "\nIBSN: " + ibsn;
    }

    
}
