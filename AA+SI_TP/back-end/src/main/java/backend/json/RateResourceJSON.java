package backend.json;

public class RateResourceJSON {
    private int rating;

    public RateResourceJSON() {
    }

    public RateResourceJSON(int rating) {
        this.rating = rating;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
