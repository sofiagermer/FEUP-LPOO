public class Ticket {
    private final int number;
    private final Concert concert;

    public Ticket(int number, Concert concert) throws InvalidTicket {
        this.number = number;
        this.concert = concert;
        if(!concert.isValid(this)) throw new InvalidTicket();
    }

    public int getNumber(){
        return number;
    }

    public Concert getConcert() {
        return concert;
    }
}
