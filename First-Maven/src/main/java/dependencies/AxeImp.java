package dependencies;

public class AxeImp implements Weapon{

    private int attackPoints;
    private int durabilityPoints;

    public AxeImp(int attackPoints, int durabilityPoints) {
        this.attackPoints = attackPoints;
        this.durabilityPoints = durabilityPoints;
    }

    @Override
    public void attack(Target target) {
        if(this.durabilityPoints<=0)
            throw new IllegalArgumentException("Axe is broken.");
        target.takeAttack(this.attackPoints);
        this.durabilityPoints-=1;
    }

    @Override
    public int getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public int getDurabilityPoints() {
        return this.durabilityPoints;
    }
}
