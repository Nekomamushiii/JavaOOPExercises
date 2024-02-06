package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

public class ControllerImpl implements Controller{
    private Repository<Discoverer> discovererRepository;
    private Repository<Spot> spotRepository;

    public ControllerImpl() {
        discovererRepository=new DiscovererRepository();
        spotRepository=new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        if(kind.equals("Anthropologist"))
           discovererRepository.add(new Anthropologist(discovererName));
        else if(kind.equals("Archaeologist"))
            discovererRepository.add(new Archaeologist(discovererName));
        else if(kind.equals("Geologist"))
            discovererRepository.add(new Geologist(discovererName));
        else
            throw new IllegalArgumentException("Discoverer kind doesn't exists.");
        return String.format("Added %s: %s.",kind,discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot=new SpotImpl(spotName);
        for(String e:exhibits)
            spot.getExhibits().add(e);
        spotRepository.add(spot);
        return String.format(ConstantMessages.SPOT_ADDED,spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {

        return null;
    }

    @Override
    public String inspectSpot(String spotName) {
        return null;
    }

    @Override
    public String getStatistics() {
        return null;
    }
}
