import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Band extends Act{
    private final List<Artist> bandElements;
    public Band(String band, String uk) {
        super(band, uk);
        this.bandElements = new ArrayList<>();
    }

    public void addArtist(Artist artist) {
        bandElements.add(artist);
    }

    public List<Artist> getArtists(){
        return bandElements;
    }

    public boolean containsArtist(Artist artist){
        for(Artist elem : bandElements){
            if(Objects.equals(elem.getCountry(), artist.getCountry()) && Objects.equals(elem.getName() ,artist.getName())) return true;
        }
        return false;
    }
}
