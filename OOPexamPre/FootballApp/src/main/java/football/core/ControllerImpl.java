package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerImpl implements Controller {
    private SupplementRepository supplement;
    private Map<String,Field> fields;

    public ControllerImpl() {
        this.supplement=new SupplementRepositoryImpl();
        this.fields=new LinkedHashMap<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        if(fieldType.equals("ArtificialTurf"))
            this.fields.put(fieldName,new ArtificialTurf(fieldName));
        else if(fieldType.equals("NaturalGrass"))
            this.fields.put(fieldName,new NaturalGrass(fieldName));
        else
            throw new NullPointerException("Invalid field type.");
        return String.format("Successfully added %s.",fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        if(type.equals("Powdered"))
            this.supplement.add(new Powdered());
        else if(type.equals("Liquid"))
            this.supplement.add(new Liquid());
        else
            throw new IllegalArgumentException("Invalid supplement type.");
        return String.format("Successfully added %s.",type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Field field= this.fields.get(fieldName);
        Supplement supplement1=this.supplement.findByType(supplementType);
        if(supplement1==null)
            throw new IllegalArgumentException(String.format("There isn't a Supplement of type %s.",supplementType));
        else
            field.addSupplement(supplement1);

        return String.format("Successfully added %s to %s.",supplementType,fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Field field = this.fields.get(fieldName);
        String fieldType = field.getClass().getSimpleName();
        if(fieldType.equals("ArtificialTurf") && playerType.equals("Men") ||
        fieldType.equals("NaturalGrass") && playerType.equals("Woman"))
            return "The pavement of the terrain is not suitable.";
        if(playerType.equals("Men") && fieldType.equals("NaturalGrass"))
            field.addPlayer(new Men(playerName,nationality,strength));
        else if(playerType.equals("Women") && fieldType.equals("ArtificialTurf"))
            field.addPlayer(new Women(playerName,nationality,strength));
        else
            throw new IllegalArgumentException("Invalid player type.");
        return String.format("Successfully added %s to %s.",playerType,fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        this.fields.get(fieldName).drag();
        return String.format("Player drag: %d",this.fields.get(fieldName).getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field=this.fields.get(fieldName);
        int value = field.getPlayers().stream().mapToInt(Player::getStrength).sum();
        return String.format("The strength of Field %s is %d.",fieldName,value);
    }

    @Override
    public String getStatistics() {
        StringBuilder str =new StringBuilder();
        this.fields.forEach((k,v)->str.append(v.getInfo()).append("\n"));
        return str.toString().trim();
    }
}
