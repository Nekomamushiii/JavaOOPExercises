package kindergarten;

import kindergarten.Child;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class softUniKindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;
    public softUniKindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }
    public boolean addChild(Child child) {
        if (registry.size() < capacity) {
            registry.add(child);
            return true;
        }
        return false;
    }
    public boolean removeChild(String firstName) {
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)) {
                registry.remove(child);
                return true;
            }
        }
        return false;
    }
    public int getChildCount() {
        return registry.size();
    }
    public Child getChild(String firstName) {
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)) {
                return child;
            }
        }
        return null;
    }
    public String registryReport() {
        registry.sort(Comparator
                .comparing(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName));
        StringBuilder report = new StringBuilder();
        report.append(String.format("Registered children in %s:\n", name));
        for (Child child : registry) {
            report.append("--\n").append(child.toString()).append("\n");
        }
        return report.toString();
    }
}