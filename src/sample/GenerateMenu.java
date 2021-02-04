package sample;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateMenu {
    public static ArrayList<Product> generateMenu() {
        // non alcoholic
        // name, calories, price, ratings, mls)
        String[] generalIngredients = { "beef", "ham", "turkey", "chicken", "pork", "bacon", "lamb", "tomato", "cucumber", "lettuce",
                "broccoli", "cheese", "butter", "milk"};

        String[] vegetarianIngredients = { "tomato", "cucumber", "lettuce", "broccoli", "cheese", "butter", "milk"};

        ArrayList<Product> products = new ArrayList<Product>();
        String[] cuisine = {"Georgian", "Italian", "Spanish", "Indian", "Asian"};
        int randomNum = ThreadLocalRandom.current().nextInt(7, 10);
        Random rand = new Random();
        for (int i = 0; i < randomNum; i++) {
            int calories = ThreadLocalRandom.current().nextInt(10, 300);
            String name = "nonalcoholic" + i;
            double price = ThreadLocalRandom.current().nextInt(2, 10) + rand.nextDouble();
            double ratings = rand.nextDouble() * 5;
            int mls = ThreadLocalRandom.current().nextInt(50, 500);
            NonAlcoholicDrinks n = new NonAlcoholicDrinks(name, calories, price, ratings,mls );
            products.add(n);
        }
        // alcoholic String name, int calories, Double price, Double ratings, int mls, double alper
        randomNum = ThreadLocalRandom.current().nextInt(7, 10);
        for (int i = 0; i < randomNum; i++) {
            int calories = ThreadLocalRandom.current().nextInt(70, 500);
            String name = "alcoholic" + i;
            double price = ThreadLocalRandom.current().nextInt(5, 30) + rand.nextDouble();
            double ratings = rand.nextDouble() * 5;
            int mls = ThreadLocalRandom.current().nextInt(50, 500);
            double alper = rand.nextDouble() * 10;
            AlcoholicDrinks n = new AlcoholicDrinks(name, calories, price, ratings,mls, alper);
            products.add(n);
        }

        // desserts String name, int calories, Double price, Double ratings, ArrayList<String> ingredients, double sweetness
        randomNum = ThreadLocalRandom.current().nextInt(7, 15);
        for (int i = 0; i < randomNum; i++) {
            int calories = ThreadLocalRandom.current().nextInt(100, 700);
            String name = "dessert" + i;
            double price = ThreadLocalRandom.current().nextInt(7, 20) + rand.nextDouble();
            double ratings = rand.nextDouble() * 5;
            int randomNum2 = ThreadLocalRandom.current().nextInt(1, 5);
            ArrayList<String> ingredients = new ArrayList<>();
            for (int j = 0; j < randomNum2; j++ ) {
                ingredients.add(generalIngredients[5 - randomNum2 + j]);
            }
            double sweetness = rand.nextDouble() * 5;
            Desserts n = new Desserts(name, calories, price, ratings, ingredients,sweetness);
            products.add(n);
        }

        //fastfood String name, int calories, Double price, Double ratings, ArrayList<String> ingredients)
        randomNum = ThreadLocalRandom.current().nextInt(7, 15);
        for (int i = 0; i < randomNum; i++) {
            int calories = ThreadLocalRandom.current().nextInt(100, 700);
            String name = "fastfood" + i;
            double price = ThreadLocalRandom.current().nextInt(7, 20) + rand.nextDouble();
            double ratings = rand.nextDouble() * 5;
            int randomNum2 = ThreadLocalRandom.current().nextInt(1, 5);
            ArrayList<String> ingredients = new ArrayList<>();
            for (int j = 0; j < randomNum2; j++ ) {
                ingredients.add(generalIngredients[5 - randomNum2 + j]);
            }
            FastFood n = new FastFood(name, calories, price, ratings, ingredients);
            products.add(n);
        }

        //veg
        randomNum = ThreadLocalRandom.current().nextInt(7, 15);
        for (int i = 0; i < randomNum; i++) {
            int calories = ThreadLocalRandom.current().nextInt(100, 700);
            String name = "vegetarian" + i;
            double price = ThreadLocalRandom.current().nextInt(7, 20) + rand.nextDouble();
            double ratings = rand.nextDouble() * 5;
            int randomNum2 = ThreadLocalRandom.current().nextInt(1, 5);
            ArrayList<String> ingredients = new ArrayList<>();
            for (int j = 0; j < randomNum2; j++ ) {
                ingredients.add(vegetarianIngredients[5 - randomNum2 + j]);
            }
            boolean ovo;
            if (i % 2 == 0) ovo = true;
            else  ovo = false;
            VegetarianFood n = new VegetarianFood(name, calories, price, ratings, ingredients, ovo);
            products.add(n);
        }
        //maindish String name, int calories, Double price, Double ratings, ArrayList<String> ingredients, String cuisine
        randomNum = ThreadLocalRandom.current().nextInt(7, 15);
        for (int i = 0; i < randomNum; i++) {
            int calories = ThreadLocalRandom.current().nextInt(100, 700);
            String name = "mainDish" + i;
            double price = ThreadLocalRandom.current().nextInt(7, 20) + rand.nextDouble();
            double ratings = rand.nextDouble() * 5;
            int randomNum2 = ThreadLocalRandom.current().nextInt(1, 5);
            ArrayList<String> ingredients = new ArrayList<>();
            for (int j = 0; j < randomNum2; j++ ) {
                ingredients.add(generalIngredients[5 - randomNum2 + j]);
            }
            int index = ThreadLocalRandom.current().nextInt(0, 5);
            MainDishes n = new MainDishes(name, calories, price, ratings, ingredients, cuisine[index]);
            products.add(n);
        }

        return products;
    }

}
