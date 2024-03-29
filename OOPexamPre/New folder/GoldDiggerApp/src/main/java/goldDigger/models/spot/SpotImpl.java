package goldDigger.models.spot;

import java.util.ArrayList;
import java.util.Collection;

public class SpotImpl implements Spot{
    private String name;
    private Collection<String> exhibits;

    public SpotImpl(String name) {
        this.setName(name);
        this.exhibits=new ArrayList<>();
    }

    public void setName(String name) {
        if(name==null || name.trim().isEmpty())
            throw new NullPointerException("Invalid name!");
        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }

    @Override
    public String getName() {
        return name;
    }
}
