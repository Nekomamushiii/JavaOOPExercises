package aquarium.entities.fish;

public class BaseFish implements Fish{
    private static final int INCREASE=5;
    private String name;
    private String species;
    private int size;
    private double price;

    public BaseFish(String name, String species, double price) {
        this.setName(name);
        this.setSpecies(species);
        this.setPrice(price);
        this.setSize(0);
    }

    @Override
    public void setName(String name) {
       if(name == null ||name.trim().isEmpty())
           throw new NullPointerException("Fish name cannot be null or empty.");
       this.name=name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        if(species == null || species.trim().isEmpty())
            throw new NullPointerException("Fish species cannot be null or empty.");
        this.species = species;
    }

    @Override
    public void eat() {
        this.setSize(this.getSize()+INCREASE);
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if(price<1)
            throw new IllegalArgumentException("Fish price cannot be below or equal to 0.");
        this.price = price;
    }
}
