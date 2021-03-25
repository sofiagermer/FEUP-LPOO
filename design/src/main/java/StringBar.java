import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar{
    public StringBar(){
        hapyHour = false;
        observers = new ArrayList<>();
    }
    public void startHappyHour(){
        this.hapyHour = true;
        notifyObservers();
    }
    public void endHappyHour(){
        this.hapyHour = false;
        notifyObservers();
    }
}
