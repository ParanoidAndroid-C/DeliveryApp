package sample;

public abstract class People {
    private String username;

    public People(String username) {
        this.username = username;
    }

    public String getUsername() { return username; }
}
