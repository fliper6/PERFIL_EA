package backend.json;

import backend.dao.Ratings;

public class RatingsJSON {
    private int idRatings;
    private int rating;
    private UserJSON idUser;

    public RatingsJSON(Ratings r) {
        this.idRatings = r.getIdRatings();
        this.rating = r.getRating();
        this.idUser = new UserJSON(r.getIdUser());
    }

    public int getIdRatings() {
        return idRatings;
    }

    public int getRating() {
        return rating;
    }

    public UserJSON getIdUser() {
        return idUser;
    }
}
