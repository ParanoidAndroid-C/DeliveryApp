package sample;

public abstract class Product implements Comparable{
    private String name;
    private int calories;
    private Double price;
    private Double rating;
    public static final int SORT_BY_NAME = 0;
    public static final int SORT_BY_CALORIES = 1;
    public static final int SORT_BY_PRICE = 2;
    public static final int SORT_BY_RATINGS= 3;
    public static int sortStrategy = SORT_BY_NAME;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getCalories() { return calories; }
    public void setCalories(int calories) { this.calories = calories; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public Product(String name, int calories, Double price, Double rating) {
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.rating = rating;
    }

    public int compareTo(Object obj) {
        if (obj instanceof Product) {
            Product p = (Product) obj;
            switch (sortStrategy) {
                case SORT_BY_NAME: return name.compareTo(p.name);
                case SORT_BY_CALORIES: return Integer.compare(this.calories, p.calories);
                case SORT_BY_PRICE: return Double.compare(this.price, p.price);
                case SORT_BY_RATINGS: return Double.compare(p.rating, this.rating);
            }
        }
        return 0;
    }

}
