package sample;

import java.util.ArrayList;

public class FastFood extends Food{

    public FastFood(String name, int calories, Double price, Double ratings, ArrayList<String> ingredients) {
        super(name, calories, price, ratings, ingredients);

    }


    public String toString() {
        return super.toString()  + "Calories: " + getCalories() + "   Price: " + String.format("%.2f$",getPrice()) + "   Ratings: " + String.format("%.2f", getRating()) + "/5";
    }


}
