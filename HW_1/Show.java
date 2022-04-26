public class Show extends Media {

    private int seasons;

    
    
    public Show() {
        super();
    }

    public Show(String title, String genre, String rating, int seasons) {
        super(title, genre, rating);
        this.seasons = seasons;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + "\nGenre: " + getGenre() + "\nRating: " + getRating() + "\nSeasons: " + seasons;
    }


    
}
