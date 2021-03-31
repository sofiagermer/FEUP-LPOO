import java.util.ArrayList;
import java.util.List;

public class Party extends Event{
    List<Event> eventList;
    private int partyPeople;
    public Party(String title, String date, String description){
        super(title, date, description);
        eventList = new ArrayList<>();
        partyPeople = 0;
    }

    public void addEvent(Event e) {
        for(Person p : e.getPersons()){
            partyPeople++;
        }
        eventList.add(e);
    }

    public void addPerson(Person person) {
        for (Person value : persons)
            if (value.equals(person)) return;
        partyPeople++;
    }

    public int getAudienceCount() { return partyPeople; }

}
