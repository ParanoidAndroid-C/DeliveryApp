package sample;


import java.util.Random;

public class NonAlcoholicDrinks extends Drinks implements Temperature{
    private final int coldTime;

    public NonAlcoholicDrinks(String name, int calories, Double price, Double ratings, int mls) {
        super(name, calories, price, ratings, mls);
        coldTime = calculateTime();
    }

    public String toString() {
        return getName() +"\n" + "Size: "+ getMls() + "ml " +"  Calorie: " + getCalories()  + "   Ratings: " + String.format("%.2f", getRating()) + "/5"+ "\n" +
                "Price: " + String.format("%.2f$",getPrice());
    }


    private int calculateTime() {
        Random random = new Random();
        return (7 + random.nextInt(15));
    }
    public int getColdTime() {
        return coldTime;
    }

    public boolean timeEnough(int time) {
        return time < coldTime;
    }
}
