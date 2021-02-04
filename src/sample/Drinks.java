package sample;

public abstract class Drinks extends Product {
    private int mls;

    public int getMls() { return mls; }
    public void setMls(int mls) { this.mls = mls; }

    public Drinks(String name, int calories, Double price, Double ratings, int mls) {
        super(name, calories, price, ratings);
        this.mls = mls;
    }

}
