package mlc.oop.inheritance.exersice.hero;

public class Hero {
    private String username;
    private int level;

    Hero(String username, int level) {
        this.level = level;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %s",
                this.getClass().getName(),
                this.getUsername(),
                this.getLevel());
    }
}
