import java.util.Objects;

public class Artist extends Act{
    public Artist(String band, String uk) {
        super(band, uk);
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if (getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return(Objects.equals(getCountry(), artist.getCountry()) && Objects.equals(getName(), artist.getName()));
    }
}
