package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

public class BaseAquarium implements Aquarium{
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.decorations=new ArrayList<>();
        this.fish=new ArrayList<>();
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty())
            throw new NullPointerException("Aquarium name cannot be null or empty.");
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if(this.capacity<=this.fish.size())
            throw new IllegalStateException("Not enough capacity.");
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("%s (%s):\nFish: ",this.name,this.getClass().getSimpleName()));
        if(this.fish.isEmpty())
            str.append("none");
        else
        {
            for(Fish fish1: this.fish)
                str.append(String.format("%s ",fish1.getName()));
        }
        str.append("\n");
        str.append(String.format("Decorations: %d\n",this.decorations.size()));
        str.append(String.format("Comfort: %d\n",this.calculateComfort()));
        return str.toString();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
