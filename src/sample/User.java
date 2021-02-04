package sample;

public class User extends People {
    private String password;
    private String address;

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public User(String username, String password, String address) {
        super(username);
        this.password = password;
        this.address = address;
    }

}
