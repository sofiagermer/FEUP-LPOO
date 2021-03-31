import java.util.Objects;

public class Attendee extends User{
    private boolean paid;

    public Attendee(String name){
        super(name);
        this.paid = false;
    }
    public Attendee(String name, int age){
        super(name, age);
        this.paid = false;
    }
    public boolean hasPaid() {
        return paid;
    }
    public String toString(){
        return "Attendee " + this.name + (this.paid ? " has" : " hasn't") + " paid its registration.";
    }
}
