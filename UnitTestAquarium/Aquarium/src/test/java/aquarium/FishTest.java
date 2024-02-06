package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FishTest{
    private Fish fish;
    private Aquarium aquarium;
    @Before
    public void createFish(){
        this.aquarium=new Aquarium("Aka",2);
        this.fish = new Fish("Nemo");
    }
    @Test
    public void testTestGetName() {
        Assert.assertEquals(4,fish.getName().length());
    }
    @Test
    public void testIsAvailable() {
        Assert.assertTrue(fish.isAvailable());

    }
    @Test
    public void testSetAvailable() {
        fish.setAvailable(false);
        Assert.assertFalse(fish.isAvailable());
    }
}