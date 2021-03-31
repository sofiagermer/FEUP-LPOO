import java.util.ArrayList;
import java.util.List;

public class Icecream {
    private List<Flavor> scoop;
    private int counter;

    public Icecream() {
        this.scoop = new ArrayList<>();
        this.counter = 0;
    }

    public void addScoop(Flavor flavor){
        scoop.add(flavor);
        counter++;
    }
    public void removeScoop(){
        scoop.remove(scoop.size()-1);
        counter--;
    }

    public int getScoopCount(){
        return this.counter;
    }

    public boolean contains(String flavor){
        for(Flavor ball : scoop){
            if(ball.getName() == flavor) return true;
        }
        return false;
    }

    public int getFlavorCount(){
        List<Flavor> diffFlavors = new ArrayList<>();
        boolean has = false;
        for(Flavor ball : scoop){
            for(Flavor diffball : diffFlavors){
                if(ball.getName() == diffball.getName()) has = true;
            }
            if(!has) diffFlavors.add(ball);
            has = false;
        }
        return diffFlavors.size();
    }
}
