package mlc.advanced.examprep1.vetclinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {

    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (capacity > data.size()) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(x -> x.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        return data.stream().filter(x -> x.getName().equals(name) && x.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public Pet getOldestPet() {
        return data.stream().max(Comparator.comparing(Pet::getAge)).get();
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("The clinic has the following patients:\n");
        data.forEach(pet -> builder.append(String.format("%s %s%n", pet.getName(), pet.getOwner())));
        return builder.toString();
    }
}
