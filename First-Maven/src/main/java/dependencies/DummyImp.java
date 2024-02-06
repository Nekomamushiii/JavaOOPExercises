package dependencies;

import java.util.List;

public class DummyImp implements Target{

    private int health;
    private int experience;

    public DummyImp(int health, int experience) {
        this.health = health;
        this.experience = experience;
    }
    @Override
    public void takeAttack(int attackPoints) {
        if(isDead())
           throw new IllegalArgumentException("Dummy is dead");
        this.health-=attackPoints;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int giveExperience() {
        if(!isDead())
            throw new IllegalArgumentException("Target is not dead.");
        return this.experience;
    }

    @Override
    public boolean isDead() {
        return this.health<=0;
    }
}
