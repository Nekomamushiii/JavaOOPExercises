package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish{
    private static final int INITIALIZE_SIZE=3;
    private static final int INCREASE_SIZE=3;
    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        setSize(INITIALIZE_SIZE);
    }

    @Override
    public void eat() {
        setSize(this.getSize()+3);
    }
}
