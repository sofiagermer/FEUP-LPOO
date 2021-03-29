import java.util.ArrayList;
import java.util.List;

public class BoxOffice {
    private Concert concert;
    private int numTicks;
    public static List<Ticket> buy(Concert concertLondon, int i) throws InvalidTicket {
        List<Ticket> tickets = new ArrayList<>();
        for (int x = 0; x < i ; x++){
            tickets.add(new Ticket(concertLondon.buyTicket(), concertLondon));
        }
        return tickets;
    }
}
