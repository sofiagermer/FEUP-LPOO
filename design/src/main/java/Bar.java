import java.util.List;

public abstract class Bar {
    boolean hapyHour;
    List<BarObserver> observers;
    public boolean isHappyHour() {return hapyHour;}
    public void startHappyHour() {};
    public void endHappyHour() {};
    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }

}
