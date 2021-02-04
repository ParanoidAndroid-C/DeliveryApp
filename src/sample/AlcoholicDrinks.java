package sample;

public class AlcoholicDrinks extends Drinks {
    private double alPer;

    public double getAlPer() {
        return alPer;
    }

    public void setAlPer(double alPer) {
        this.alPer = alPer;
    }

    public AlcoholicDrinks(String name, int calories, Double price, Double ratings, int mls, double alPer) {
        super(name, calories, price, ratings, mls);
        this.alPer = alPer;
    }

    public String toString() {
        return getName() + "\n" + "Size: " + getMls() + "ml   " + "Calories: " + getCalories()
                + "   Alcohol percentage: " + String.format("%.2f", alPer) + "% " + "  Ratings: "
                + String.format("%.2f", getRating()) + "/5" + "\n" + "Price: " + String.format("%.2f$", getPrice());
    }
}
