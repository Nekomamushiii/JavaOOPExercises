package mlc.oop.inheritance.exersice.animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String produceSound() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s%n", this.getClass().getSimpleName()))
                .append(String.format("%s %d %s%n", this.getName(), this.getAge(), this.getGender()))
                .append(this.produceSound());

        return sb.toString().trim();
    }
}
