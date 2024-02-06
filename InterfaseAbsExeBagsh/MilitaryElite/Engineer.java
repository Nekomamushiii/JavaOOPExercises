package mlc.oop.int_abs.exercise.MilitaryElite;

import java.util.Collection;

public interface Engineer extends SpecialisedSoldier {

    Collection<RepairImpl> getRepairs();

    void addRepair(RepairImpl repair);
}
