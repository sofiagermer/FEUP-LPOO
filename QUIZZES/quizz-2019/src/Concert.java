import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Concert {
    private final String city, country, date;
    private int numTicket;
    private List<Act> acts;

    public Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
        this.numTicket = 0;
        acts = new ArrayList<>();
    }
    public void addAct(Act act){
        acts.add(act);
    }

    public List<Act> getActs(){
        return acts;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }
   @Override
    public boolean equals(Object concert) {
        if (this == concert) return true;                   // are the references equal
        if (concert == null) return false;                  // is the other object null
        if (getClass() != concert.getClass()) return false; // both objects the same class
        Concert newConcert = (Concert) concert;                          // cast the other object
        return (Objects.equals(country, newConcert.getCountry()) && Objects.equals(date, newConcert.getDate()) && Objects.equals(city, newConcert.getCity()) && Objects.equals(acts, newConcert.getActs()));
    }

    @Override
    public int hashCode(){
        return Objects.hash(city,country, date, acts);
    }

    public boolean isValid(Ticket ticket) {
        if(ticket.getNumber() < 0) return false;
        if(ticket.getConcert() == this) return true;
        return false;


    }

    public boolean participates(Artist artist) {
        for(Act act : acts){
           if(act.getClass() == Band.class){
               if(((Band) act).containsArtist(artist)) return true;
           }
           else if(act.getClass() == Artist.class){
               if(act.equals(artist)) return true;
           }
        }
        return false;
    }
    public int buyTicket(){
        numTicket++;
        return numTicket;
    }
}
