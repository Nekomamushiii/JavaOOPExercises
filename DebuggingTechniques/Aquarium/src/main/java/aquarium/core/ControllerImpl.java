package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.BaseAquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.BaseDecoration;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerImpl implements Controller{
    private DecorationRepository decorations;
    private Map<String,BaseAquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums=new LinkedHashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        if(aquariumType.equals("FreshwaterAquarium"))
            this.aquariums.put(aquariumName,new FreshwaterAquarium(aquariumName));
        else if (aquariumType.equals("SaltwaterAquarium"))
            this.aquariums.put(aquariumName,new SaltwaterAquarium(aquariumName));
        else
            throw new NullPointerException("Invalid aquarium type.");
        return "Successfully added "+aquariumType;

    }

    @Override
    public String addDecoration(String type) {
        if(type.equals("Ornament"))
            this.decorations.add(new Ornament());
        else if(type.equals("Plant"))
            this.decorations.add(new Plant());
        else
            throw new IllegalArgumentException("Invalid decoration type.");
        return "Successfully added "+type;
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration=this.decorations.findByType(decorationType);
        if(decoration==null)
            throw new IllegalArgumentException(String.format("There isn't a decoration of type %s.",decorationType));

        this.aquariums.get(aquariumName).addDecoration(decoration);
        this.decorations.remove(decoration);
        return "Successfully added "+decorationType+" to "+aquariumName+".";

    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        if(!fishType.equals("FreshwaterFish") && !fishType.equals("SaltwaterFish"))
            throw new IllegalArgumentException("Invalid fish type.");
        String aquarium = this.aquariums.get(aquariumName).getClass().getSimpleName().replaceFirst("Aquarium","");
        String fish =fishType.replaceFirst("Fish","");
       if(this.aquariums.get(aquariumName).getCapacity()<=this.aquariums.get(aquariumName).getFish().size())
           return "Not enough capacity.";
       else if(!aquarium.equals(fish))
           return "Water not suitable.";
       else{
           if(fishType.equals("FreshwaterFish"))
               aquariums.get(aquariumName).addFish(new FreshwaterFish(fishName,fishSpecies,price));
           else
               aquariums.get(aquariumName).addFish(new SaltwaterFish(fishName,fishSpecies,price));
       }

        return String.format("Successfully added %s to %s.",fishType,aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        int count=0;
        this.aquariums.get(aquariumName).feed();
        count=aquariums.get(aquariumName).getFish().size();
        return "Fish fed: "+count;
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.aquariums.get(aquariumName);
        double value = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum()+
                        aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        return String.format("The value of Aquarium %s is %.2f.",aquariumName,value);

    }

    @Override
    public String report() {
        StringBuilder str =new StringBuilder();

        this.aquariums.forEach((k,v)->str.append(v.getInfo()));
        return str.toString();
    }
}
