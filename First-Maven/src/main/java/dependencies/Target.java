package dependencies;

import java.util.List;

public interface Target {

    void takeAttack(int attackPoints);
    int getHealth();
    int giveExperience();
    boolean isDead();
}
