package sample;

import java.util.ArrayList;

public class VegetarianFood extends Food{
    private boolean ovo;

    public boolean isOvo() { return ovo; }

    public void setOvo(boolean ovo) { this.ovo = ovo; }

    public VegetarianFood(String name, int calories, Double price, Double ratings, ArrayList<String> ingredients, boolean ovo) {
        super(name, calories, price, ratings, ingredients);
        this.ovo = ovo;
    }


    public String toString() {
        String s = "";
       if (ovo) s = "Type: Ovo Vegetarian \n";
       return super.toString()  +  s + "Calories: " + getCalories() + "   Price: " + String.format("%.2f$",getPrice()) + "   Ratings: " + String.format("%.2f", getRating()) + "/5";

    }
}
