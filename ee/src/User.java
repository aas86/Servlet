
public class User {
    private String name;
    private String password;
    private int health;
    private int damage;
    private int rating;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.health = 100;
        this.damage = 10;
        this.rating = 0;
    }

    public User (String name, String password, int health, int damage, int rating){
        this.name = name;
        this.password = password;
        this.health = health;
        this.damage = damage;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
