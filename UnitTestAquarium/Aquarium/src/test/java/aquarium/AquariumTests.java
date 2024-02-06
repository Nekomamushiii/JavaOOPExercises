package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AquariumTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium
    private static final String AQUARIUM_NAME="Aka";
    private static final int CAPACITY=10;
    private Aquarium aquarium;
    private Fish fish;
    @Before
    public void createAquarium(){
        this.aquarium = new Aquarium("Aka",5);
        this.fish=new Fish("Nemo");
    }
    @Test(expected = NullPointerException.class)
    public void testsSetNameNull(){
        this.aquarium=new Aquarium(null,10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityNegative(){
        Aquarium aquarium1=new Aquarium(AQUARIUM_NAME,-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testsAddFishFullAquarium(){
        aquarium.add(fish);
        aquarium.add(fish);
        aquarium.add(fish);
        aquarium.add(fish);
        aquarium.add(fish);
        aquarium.add(fish);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testsRemoveFishNotExists(){
        aquarium.remove("Dori");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testsSellFishDoesntExist(){
        aquarium.sellFish("Dori");
    }
    @Test
    public void testsAddFishToAquarium(){
        aquarium.add(fish);
        Assert.assertEquals(1,aquarium.getCount());
    }
    @Test
    public void testRemoveFishFromAquarium(){
        aquarium.add(fish);
        aquarium.add(new Fish("Dori"));

        Assert.assertEquals(2,aquarium.getCount());
        aquarium.remove("Nemo");
        Assert.assertEquals(1,aquarium.getCount());

    }
    @Test
    public void testSellFish(){
        aquarium.add(fish);
        Assert.assertTrue(fish.isAvailable());
        aquarium.sellFish("Nemo");
        Assert.assertFalse(fish.isAvailable());
    }
}

