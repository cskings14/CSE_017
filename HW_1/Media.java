public class Media {
    

    private String title;
    private String genre;
    private String rating;

    public Media() {
        this.title = "";
        this.genre = "";
        this.rating = "";
    }

    public Media(String title, String genre, String rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String toString() {
        return "Title: " + getTitle() + "\nGenre: " + getGenre() + "\nRating: " + getRating();
    }

    public int ratingNumber(){
        if (getRating().equals("G")){
            return 1;
        } else if (getRating().equals("PG")){
            return 2;
        } else if (getRating().equals("PG-13")){
            return 3;
        } else if (getRating().equals("R")){
            return 5;
        } else if (getRating().equals("PG-14")){
            return 4;
        } else {
            return 0;
        }
    }



}
