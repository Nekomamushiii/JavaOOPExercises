package football;

import org.junit.Assert;
import org.junit.Test;

public class FootballTeamTests {
    @Test(expected = NullPointerException.class)
    public void testsSetNameNull(){
         FootballTeam footballTeam=new FootballTeam(null,5);
    }
    @Test(expected = NullPointerException.class)
    public void testsSetNameWhiteSpace(){
         FootballTeam footballTeam=new FootballTeam("           ",5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testsSetVacantPositionsLessThanZero(){
         FootballTeam footballTeam=new FootballTeam("Team Z",-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testsAddFootBallerFullCapacity(){
         FootballTeam footballTeam=new FootballTeam("Team Y",2);
         footballTeam.addFootballer(new Footballer("Bachira"));
         footballTeam.addFootballer(new Footballer("Isagi"));
         footballTeam.addFootballer(new Footballer("Chigri"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testsRemoveFoodBallerGetName(){
        FootballTeam footballTeam =new FootballTeam("Team Y",2);
        footballTeam.addFootballer(new Footballer("Bachira"));
        footballTeam.removeFootballer("Isagi");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testsFootballerForSaleGetName(){
        FootballTeam footballTeam=new FootballTeam("Team Y",1);
        footballTeam.footballerForSale("Bachira");
    }
    @Test
    public void testConstructor(){
        FootballTeam footballTeam=new FootballTeam("Team Z",3);
        Assert.assertEquals(3,footballTeam.getVacantPositions());
    }
}
