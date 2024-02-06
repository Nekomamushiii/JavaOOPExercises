package mlc.oop.int_abs.exercise.MilitaryElite;

import java.util.Collection;

public interface Commando extends SpecialisedSoldier {

    Collection<MissionImpl> getMission();

    void addMission(MissionImpl mission);
}
