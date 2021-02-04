package sample;

import java.util.ArrayList;

public class Desserts extends Food {
    private double sweetness;

    public double getSweetness() { return sweetness; }
    public void setSweetness(double sweetness) { this.sweetness = sweetness; }

    public Desserts(String name, int calories, Double price, Double ratings, ArrayList<String> ingredients, double sweetness) {
        super(name, calories, price, ratings, ingredients);
        this.sweetness = sweetness;
    }


    public String toString() {
        return super.toString()  + "Sweetness: " + String.format("%.2f",sweetness) + "/5"  + "   Calories: " + getCalories() + "   Price: " + String.format("%.2f$",getPrice()) + "   Ratings: " + String.format("%.2f", getRating()) + "/5";
    }

}
