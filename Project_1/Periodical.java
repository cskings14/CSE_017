public class Periodical extends LibraryManager {
    
    private int month;

    private int issueNumber;


    public Periodical(String callNumber, String title, String publisher, int year, int copies, int month, int issueNumber) {
        super(callNumber, title, publisher, year, copies);
        this.month = month;
        this.issueNumber = issueNumber;
    }

    public int getMonth() {
        return month;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMonth: " + month + "\nIssue Number: " + issueNumber;
    }


}
