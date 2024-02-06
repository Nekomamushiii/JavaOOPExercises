package rpg_test;

import dependencies.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {
    private static final int TARGET_XP=10;
    private static final String HERO_NAME="Nekomamushi";
    @Test
    public void attackGainsXPIfTargetIsDead(){
       Weapon weaponMock = Mockito.mock(Weapon.class);
       Target targetMock = Mockito.mock(Target.class);
       Mockito.when(targetMock.isDead()).thenReturn(true);
       Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);
       HeroDependencies hero = new HeroDependencies(HERO_NAME,weaponMock);
       hero.attack(targetMock);
       Assert.assertEquals("Wrong XP",10,hero.getExperience());
    }
}
