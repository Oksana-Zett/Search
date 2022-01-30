package manager;

import domain.Ticket;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 17200, "VKO", "DXB", 325);
    Ticket ticket2 = new Ticket(2, 10716, "LGW", "CDG", 80);
    Ticket ticket3 = new Ticket(3, 26457, "VKO", "DXB", 280);
    Ticket ticket4 = new Ticket(4, 11940, "LGW", "CDG", 65);
    Ticket ticket5 = new Ticket(5, 23600, "VKO", "DXB", 280);
    Ticket ticket6 = new Ticket(6, 9999, "LGW", "CDG", 65);
    Ticket ticket7 = new Ticket(7, 14896, "VKO", "CDG", 300);
    Ticket ticket8 = new Ticket(8, 7540, "CDG", "VKO", 75);
    Ticket ticket9 = new Ticket(9, 17201, "VKO", "DXB", 325);
    Ticket ticket10 = new Ticket(10, 10717, "LGW", "CDG", 80);
    Ticket ticket11 = new Ticket(11, 17202, "VKO", "DXB", 325);
    Ticket ticket12 = new Ticket(12, 10718, "LGW", "CDG", 80);
    Ticket ticket13 = new Ticket(13, 16999, "VKO", "DXB", 300);

    @Test
    void shouldSearchByEmpty() {

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchByAirport("VKO", "DXB");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByOneTicket() {
        manager.add(ticket1);

        Ticket[] expected = new Ticket[]{ticket1};
        Ticket[] actual = manager.searchByAirport("VKO", "DXB");

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchBySomeTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);
        manager.add(ticket13);

        Ticket[] expected = new Ticket[]{ticket13, ticket1, ticket9, ticket11, ticket5, ticket3};
        Ticket[] actual = manager.searchByAirport("VKO", "DXB");

        assertArrayEquals(expected, actual);
    }
}