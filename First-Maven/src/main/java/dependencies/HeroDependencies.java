package dependencies;

import java.util.ArrayList;
import java.util.List;

public class HeroDependencies {
    private String name;
    private Weapon weapon;
    private int experience;


    public HeroDependencies(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
        this.experience=0;
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getExperience() {
        return experience;
    }
    public void attack(Target target){
        this.weapon.attack(target);
        if(target.isDead()){
            this.experience=target.giveExperience();
        }
    }

}
