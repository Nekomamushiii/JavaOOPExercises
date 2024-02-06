package aquarium;

import aquarium.core.Engine;
import aquarium.core.EngineImpl;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();

    }
}
