package rpg_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

public class DummyTests {
    private static final int DUMMY_HEALTH=10;
    private static final int DUMMY_XP=1;
    private Dummy dummy;
    @Before
    public void initializeTestObject(){
        this.dummy=new Dummy(DUMMY_HEALTH,DUMMY_XP);
    }
    @Test
    public void dummyLosesHealth(){
        dummy.takeAttack(8);
        Assert.assertEquals(2,dummy.getHealth());
    }
    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowException(){
        dummy.takeAttack(10);
        dummy.takeAttack(1);
    }
    @Test
    public void deadDummyCanGiveXP(){
        dummy.takeAttack(10);
        Assert.assertEquals(1,dummy.giveExperience());
    }
    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP(){
        dummy.takeAttack(3);
        dummy.giveExperience();
    }
}
