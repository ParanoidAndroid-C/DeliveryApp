package sample;

import java.util.ArrayList;

public class MainDishes extends Food {
    private String cuisine;


    public MainDishes(String name, int calories, Double price, Double ratings, ArrayList<String> ingredients, String cuisine) {
        super(name, calories, price, ratings, ingredients);
        this.cuisine = cuisine;
    }


    public String toString() {
        return super.toString()  + "Cuisine: " + cuisine  + "   Calories: " + getCalories() + "   Price: " + String.format("%.2f$",getPrice()) + "   Ratings: " + String.format("%.2f", getRating()) + "/5";

    }
}
