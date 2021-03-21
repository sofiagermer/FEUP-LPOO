import java.util.List;

public class City implements SumProvider{
    private final List<House> houseList;

    public City(List<House> houseList) {
        this.houseList = houseList;
    }
    public double sum(){
        int sum = 0;
        for(House house : houseList){
            sum += house.getArea();
        }
        return sum;
    }
}
