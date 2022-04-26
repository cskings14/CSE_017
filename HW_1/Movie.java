public class Movie extends Media {

    
    private int duration;
    public Movie() {
        super();
    }

    public Movie(String title, String genre, String rating, int duration) {
        super(title, genre, rating);
        this.duration = duration;
    
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    

    @Override
    public String toString() {
        return "Title: " + getTitle() + "\nGenre: " + getGenre() + "\nRating: " + getRating() + "\nDuration: " + duration;
    }


    
    
}
