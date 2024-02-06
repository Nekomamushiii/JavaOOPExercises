package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish{
    private static final int INITIALIZE_SIZE=5;
    private static final int INCREASE_SIZE=2;
    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        setSize(INITIALIZE_SIZE);
    }

    @Override
    public void eat() {
        setSize(this.getSize()+INCREASE_SIZE);
    }
}
