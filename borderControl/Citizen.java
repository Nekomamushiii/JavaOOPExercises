package borderControl;

public class Citizen implements Identifiable {
    private String id;
    private String name;
    private int age;

    public Citizen(String name, int age, String id) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
