package sample;

public class DeliveryPerson extends People{
    private double rating;
    private int ratingCnt;

    public double getRating() { return rating; }
    public int getRatingCnt() { return ratingCnt; }
    public void setRating(double rating) { this.rating = rating; }
    public void setRatingCnt(int ratingCnt) { this.ratingCnt = ratingCnt; }

    public DeliveryPerson(String username, double rating, int ratingCnt) {
        super(username);
        this.rating = rating;
        this.ratingCnt = ratingCnt;
    }

    public String toString() {
        return getUsername() +"," + rating + ',' + ratingCnt;
    }
}
