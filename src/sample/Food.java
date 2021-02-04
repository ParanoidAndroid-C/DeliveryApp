package sample;

import java.util.ArrayList;
import java.util.Random;

public abstract class Food extends Product implements Temperature{
    private final ArrayList<String> ingredients;
    private final int coldTime;

    public ArrayList<String> getIngredients() { return ingredients; }

    public Food(String name, int calories, Double price, Double ratings, ArrayList<String> ingredients) {
        super(name, calories, price, ratings);
        this.ingredients = ingredients;
        coldTime = calculateTime();
    }


    public String toString() {
        return getName() + '\n' + ingredients + '\n';
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
