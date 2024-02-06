package kindergarten;
public class Child {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String parentName;
    private final String contactNumber;

    public Child(String firstName, String lastName, int age, String parentName, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.parentName = parentName;
        this.contactNumber = contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getParentName() {
        return parentName;
    }

    public String getContactNumber() {
        return contactNumber;
    }
    @Override
    public String toString() {
        return String.format("Child: %s %s, Age: %d, Contact info: %s - %s",
                firstName, lastName, age, parentName, contactNumber);
    }
}