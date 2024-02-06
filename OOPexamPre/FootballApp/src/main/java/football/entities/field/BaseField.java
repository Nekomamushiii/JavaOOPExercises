package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class BaseField implements Field{
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    protected BaseField(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.supplements=new ArrayList<>();
        this.players=new ArrayList<>();
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    protected void setName(String name) {
        if(name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Field name cannot be null or empty.");
        this.name = name;
    }

    @Override
    public int sumEnergy() {
        return this.supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if(this.capacity<=this.players.size())
            throw new IllegalStateException("Not enough capacity.");
        this.players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
         this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        this.players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        StringBuilder str =new StringBuilder();
        str.append(String.format("%s (%s):\n",this.name,this.getClass().getSimpleName()));
        str.append("Player: ");
        if(this.players.isEmpty())
            str.append("none\n");
        else
            str.append(this.players.stream().map(Player::getName).collect(Collectors.joining(" ")));
        str.append("\n");
        str.append(String.format("Supplement: %d\n",this.supplements.size()));
        str.append(String.format("Energy: %d\n",this.sumEnergy()));
        return str.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return capacity;
    }
}
