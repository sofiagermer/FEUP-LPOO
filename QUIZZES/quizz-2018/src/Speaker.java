import javax.accessibility.AccessibleText;
import java.util.Objects;

public class Speaker extends User{
    private int fee;

    public Speaker(String name){
        super(name);
        this.fee = 0;
    }
    public Speaker(String name, int age) {
        super(name, age);
        this.fee = 0;
    }
    public int getFee() {
        return fee;
    }
    public String toString(){
        return "Speaker " + this.name + " has a fee value of " + this.fee + "." ;
    }
}
